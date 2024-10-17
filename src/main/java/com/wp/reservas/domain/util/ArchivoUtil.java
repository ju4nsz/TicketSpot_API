package com.wp.reservas.domain.util;

import com.wp.reservas.domain.models.exceptions.HttpGenericException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.Triple;
import org.springframework.beans.factory.annotation.Value;
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

@Component
@Slf4j
public class ArchivoUtil {

    private static final String SHA256 = "SHA-256";
    private static final MessageDigest messageDigest;

    private static String rutaRaiz = "C:\\\\ticketspot\\\\files";

    static {
        try {
            messageDigest = MessageDigest.getInstance(SHA256);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public Triple<String, String, String> subirArchivo(byte [] file, String sufijo, String archivoNombre) {

        String ruta = "peliculas/fotos/" + sufijo;
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
