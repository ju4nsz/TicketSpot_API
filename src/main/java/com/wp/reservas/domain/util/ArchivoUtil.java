package com.wp.reservas.domain.util;

import com.wp.reservas.domain.models.exceptions.HttpGenericException;
import com.wp.reservas.domain.strategy.validacion.ExtensionesTipos;
import com.wp.reservas.domain.strategy.validacion.FileValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.Triple;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ArchivoUtil {

    private static final MessageDigest messageDigest;
    private static final String SHA256 = "SHA-256";
    private final FileValidator fileValidator;

    private static String rutaRaiz = "C:\\\\ticketspot\\\\files";

    static {
        try {
            messageDigest = MessageDigest.getInstance(SHA256);
        } catch (NoSuchAlgorithmException e) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public Triple<String, String, String> subirArchivo(byte [] file, String sufijo, String archivoNombre, String carpeta) {

        String ruta = carpeta+"/fotos/" + sufijo;
        archivoNombre = archivoNombre.replaceAll("[\\\\/:*?\"<>|]", "_");
        String rutaArchivo = archivoNombre;
        Path pathDirectorio = Paths.get(rutaRaiz).resolve(ruta);
        Path pathArchivo = pathDirectorio.resolve(rutaArchivo);
        crearDirectiorios(pathDirectorio);

        log.info("Guardando el archivo en la ruta {}...", ruta + rutaArchivo);
        try {
            Files.write(pathArchivo, file, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e){
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, "Ha ocurrido un error guardando el archivo en la ruta %s" + pathArchivo.toString());
        }

        return new Triple<>(pathArchivo.toString(), getSha256(file), archivoNombre);
    }

    public byte [] getBytes(MultipartFile file){
        try {
            return file.getBytes();
        } catch (IOException e) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, "¡Lo sentimos! Ha ocurrido un error guardando la foto ;/");
        }
    }

    public void validarArchivos(List<MultipartFile> archivos, ExtensionesTipos tipo) {

        boolean extensionesValidas = archivos.stream()
                .allMatch(f -> fileValidator.validarExtension(tipo, f.getOriginalFilename()));
        if (!extensionesValidas) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "¡Lo sentimos! Deben ser archivo de tipo " + tipo.toString() + " válidos para poder cargarlos :/");
        }

        boolean tamanioValido = archivos.stream()
                .allMatch(f -> (f.getSize() / 1024) <= 2048);
        if (!tamanioValido) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "¡Lo sentimos! El tamaño de los archivos debe ser menor o igual a " + (2048 / 1024) + "MB para poder cargarlos :/");
        }
    }

    public void crearDirectiorios(Path path) {
        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
        } catch (IOException e) {
            System.out.println("El Archivo Ya Existe");
        }
    }

    public String getSha256(byte[] file) {
        messageDigest.update(file);
        return bytesToHex(messageDigest.digest());
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes)
            result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }

}
