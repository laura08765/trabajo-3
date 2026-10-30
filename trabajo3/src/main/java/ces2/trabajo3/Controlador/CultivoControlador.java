package ces2.trabajo3.Controlador;

import ces2.trabajo3.Modelo.Cultivo;
import ces2.trabajo3.Modelo.EnumCultivo;
import ces2.trabajo3.Modelo.Plantacion;
import ces2.trabajo3.Repositorio.CultivoRepositorio;
import ces2.trabajo3.Repositorio.PlantacionRepositorio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class CultivoControlador {

    @GetMapping("/punto2")
    public String mostrarCultivos(Model model) {


        Stack<Cultivo> cultivos = CultivoRepositorio.crearCultivos();


        Plantacion plantacion = PlantacionRepositorio.crearPlantacion();


        StringBuilder listaCultivos = new StringBuilder();

        ListIterator<Cultivo> listIterator = cultivos.listIterator();

        while (listIterator.hasNext()) {
            Cultivo cultivo = listIterator.next();

            listaCultivos.append("Nombre: ").append(cultivo.getNombre())
                    .append(" | Semillas: ").append(cultivo.getCantidadSemillas())
                    .append(" | Ubicación: ").append(cultivo.getUbicacion())
                    .append(" | Tipo: ").append(cultivo.getTipoCultivo())
                    .append(" | Categoría: ").append(cultivo.getCategoria())
                    .append(" | Conteo: ").append(cultivo.getConteo())
                    .append("\n");
        }


        StringBuilder cultivosPlantacion = new StringBuilder();

        Iterator<Cultivo> iterator = plantacion.getCultivos().iterator();

        while (iterator.hasNext()) {
            Cultivo cultivo = iterator.next();

            cultivosPlantacion.append("Nombre: ").append(cultivo.getNombre())
                    .append(" | Semillas: ").append(cultivo.getCantidadSemillas())
                    .append(" | Ubicación: ").append(cultivo.getUbicacion())
                    .append(" | Tipo: ").append(cultivo.getTipoCultivo())
                    .append(" | Categoría: ").append(cultivo.getCategoria())
                    .append(" | Conteo: ").append(cultivo.getConteo())
                    .append("\n");
        }

        model.addAttribute("listaCultivos", listaCultivos.toString());
        model.addAttribute("cultivosPlantacion", cultivosPlantacion.toString());

        return "punto2";
    }


    @GetMapping("/punto3")
    public String mostrarPunto3(Model model) {

        Plantacion plantacion = PlantacionRepositorio.crearPlantacion();

        Stack<Cultivo> stack = CultivoRepositorio.crearCultivos();

        Deque<Cultivo> deque = new ArrayDeque<>(stack);

        plantacion.setCultivos(deque);

        var cultivosFiltrados = plantacion.getCultivos()
                .stream()
                .filter(cultivo -> cultivo.getTipoCultivo() == EnumCultivo.TOMATE)
                .toList();

        model.addAttribute("cultivosFiltrados", cultivosFiltrados);

        return "punto3";
    }


    @GetMapping("/punto4")
    public String mostrarPunto4(Model model) {

        Plantacion plantacion = PlantacionRepositorio.crearPlantacion();

        java.util.function.Function<Cultivo, Integer> funcionSuma =
                cultivo -> cultivo.sumarConteo();

        var resultados = plantacion.getCultivos()
                .stream()
                .map(cultivo -> new Object[] {
                        cultivo,
                        funcionSuma.apply(cultivo)
                })
                .toList();

        model.addAttribute("resultados", resultados);

        return "punto4";
    }

    @GetMapping("/punto5")
    public String mostrarPunto5(Model model) {

        Plantacion plantacion = PlantacionRepositorio.crearPlantacion();

        Cultivo cultivo = plantacion.getCultivos().peekFirst();

        java.util.function.Function<Cultivo, Integer> funcionSuma =
                c -> c.sumarConteo();

        cultivo.verTotales(funcionSuma);
        int total = funcionSuma.apply(cultivo);

        model.addAttribute("nombreCultivo", cultivo.getNombre());
        model.addAttribute("totalConteo", total);

        return "punto5";
    }
}