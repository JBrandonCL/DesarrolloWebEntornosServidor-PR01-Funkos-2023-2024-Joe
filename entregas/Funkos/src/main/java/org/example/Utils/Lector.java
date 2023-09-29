package org.example.Utils;

import org.example.Model.Funko;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Lector {
    public Lector() {}
    public  List<Funko> Leer() {
        String DATA_FILE = "funkos.csv";
        String WORKING_DIRECTORY = System.getProperty("user.dir");
        Path path = Paths.get(WORKING_DIRECTORY + File.separator + "data" + File.separator + DATA_FILE);

        try {
            final List<String> lineas = Files.readAllLines(path, StandardCharsets.UTF_8);
            return lineas.stream().skip(1).map(Lector::parseFunko).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error en la lectura del fichero");
        }
        return null;
    }
    private static Funko parseFunko(String linea) {
        String[] vs = linea.split(",");
        String uuid=vs[0];
        String nombre=vs[1];
        String modelo=vs[2];
        Double precio=Double.parseDouble(vs[3]);
        LocalDate fecha=fecha(vs[4]);

        return new Funko(uuid,nombre,modelo,precio,fecha);
    }
    private static LocalDate fecha(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(fecha, formatter);
    }
    }
