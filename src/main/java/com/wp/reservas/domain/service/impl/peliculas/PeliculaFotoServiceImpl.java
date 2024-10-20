package com.wp.reservas.domain.service.impl.peliculas;

import com.wp.reservas.domain.models.consts.DatosGenerales;
import com.wp.reservas.domain.models.exceptions.HttpGenericException;
import com.wp.reservas.domain.models.request.peliculas.PeliculaFotoRequest;
import com.wp.reservas.domain.models.response.GenericResponse;
import com.wp.reservas.domain.service.in.peliculas.PeliculaFotoInService;
import com.wp.reservas.domain.service.out.configuraciones.ParametroOutService;
import com.wp.reservas.domain.service.out.peliculas.PeliculaFotoOutService;
import com.wp.reservas.domain.service.out.peliculas.PeliculaOutService;
import com.wp.reservas.domain.strategy.validacion.ExtensionesTipos;
import com.wp.reservas.domain.strategy.validacion.FileValidator;
import com.wp.reservas.domain.util.ArchivoUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.Triple;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PeliculaFotoServiceImpl implements PeliculaFotoInService {

    private final PeliculaFotoOutService peliculaFotoOutService;
    private final ParametroOutService parametroOutService;
    private final PeliculaOutService peliculaOutService;
    private final FileValidator fileValidator;
    private final ArchivoUtil archivoUtil;

    @Override
    public GenericResponse subir(PeliculaFotoRequest request) {

        log.info("Validando que la película con id {} exista...", request.getIdPelicula());
        if (!peliculaOutService.existePorId(request.getIdPelicula())){
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "¡Lo sentimos! No pudimos encontrar la película que buscaste :/");
        }

        log.info("Validando extensiones y tamaño de las fotos a subir para la película con id {}...", request.getIdPelicula());
        archivoUtil.validarArchivos(request.getFotos(), ExtensionesTipos.IMG);

        log.info("Validando que la cantidad de fotos no supere la máxima permitida...");
        validarCantidadFotos(request.getFotos(), request.getIdPelicula());

        log.info("Guardando fotos para la película con id {}...", request.getIdPelicula());
        guardarFotos(request.getFotos(), request.getIdPelicula());

        return GenericResponse.ok(true, "¡Lo logramos! Logramos subir las fotos para la película con éxito :)");
    }

    private void validarCantidadFotos(List<MultipartFile> fotos, Integer idPelicula){

        Integer maxFotosPorPelicula = Integer.parseInt(parametroOutService.obtenerParametro(DatosGenerales.CLAVE_MAX_FOTOS_POR_PELICULA).getValor());
        Integer fotosSubidas = peliculaFotoOutService.obtenerCantidadFotosPorPelicula(idPelicula);
        Integer cantidad = fotosSubidas + fotos.size();

        if (cantidad > maxFotosPorPelicula) {
             throw new HttpGenericException(HttpStatus.BAD_REQUEST, "¡Lo sentimos! Solo se pueden subir " + maxFotosPorPelicula + " fotos para cada película :/");
        }
    }

    private void guardarFotos(List<MultipartFile> fotos, Integer idPelicula){
        fotos.parallelStream().forEach(f -> {

            log.info("Obteniendo bytes de la foto {} para la película con id {}...", f.getOriginalFilename(), idPelicula);
            byte [] bytes = archivoUtil.getBytes(f);

            log.info("Guardando foto {} para la película con id {}...", f.getOriginalFilename(), idPelicula);
            Triple<String, String, String> respuesta = archivoUtil.subirArchivo(bytes, idPelicula.toString(), f.getOriginalFilename(),"Peliculas");

            log.info("Guardando datos de la foto {} para la película con id {} en la base de datos...", f.getOriginalFilename(), idPelicula);
            peliculaFotoOutService.guardar(PeliculaBuilder.construirDtoFoto(idPelicula, respuesta.b, respuesta.a));
        });
    }

}
