package org.example.Controller;

import org.example.Model.Funko;
import org.example.Utils.Lector;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerFunko {

   private List<Funko>funkos;
    private static ControllerFunko instance;
    public static ControllerFunko getInstance() {
        if (instance == null) {
            instance = new ControllerFunko();
        }
        return instance;
    }
    private ControllerFunko(){funkos= new Lector().Leer();}
    public void FunkoPrecioMasAlto(){
        System.out.println(funkos.stream().max(Comparator.comparingDouble(value -> value.getPrecio())));
    }
    public void mediaPreciosFunkos(){
        System.out.println(funkos.stream().collect(Collectors.averagingDouble(value -> value.getPrecio())));
    }
    public void funkosAgrupadosPorModelo(){
    Map<String,List<Funko>> agrupar=funkos.stream().collect(Collectors.groupingBy(funko -> funko.getModelo()));

        for (Map.Entry<String,List<Funko>> funkos:agrupar.entrySet()) {
            String Modelo = funkos.getKey();
            List<Funko> ad=funkos.getValue();
            System.out.println(Modelo+"--------------");
            for (int i = 0; i < ad.size(); i++) {
                System.out.println(ad.get(i));
            }
        }
    }

    public void numeroFunkosPorModelo(){
        Map<String,Long> agrupar=funkos.stream().collect(Collectors.groupingBy(funko -> funko.getModelo(),Collectors.counting()));
        for (Map.Entry<String,Long> funkos:agrupar.entrySet()) {
            String Modelo = funkos.getKey();
            Long cantidad=funkos.getValue();
            System.out.println("Hay de "+Modelo+" la cantidad de :"+cantidad);
        }
    }
    public void funkosAnoDosMil(){
        funkos.stream().filter(funko -> funko.getFecha().getYear()==2023).forEach(System.out::println);
    }
    public void listadoDeStitch(){
       var contador = funkos.stream().filter(funko -> funko.getNombre().contains("Stitch")).count();
       List<Funko> lista=funkos.stream().filter(funko -> funko.getNombre().contains("Stitch")).toList();
        System.out.println("El nuermo de Stitch es : " +contador);
        lista.forEach(System.out::println);
    }
}
