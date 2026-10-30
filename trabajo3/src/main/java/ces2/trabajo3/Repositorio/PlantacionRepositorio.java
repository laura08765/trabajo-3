package ces2.trabajo3.Repositorio;

import ces2.trabajo3.Modelo.Categoria;
import ces2.trabajo3.Modelo.Cultivo;
import ces2.trabajo3.Modelo.EnumCultivo;
import ces2.trabajo3.Modelo.Plantacion;

import java.util.Stack;

public class PlantacionRepositorio {

    public static Plantacion crearPlantacion() {

        Stack<Cultivo> cultivos = CultivoRepositorio.crearCultivos();

        Plantacion plantacion = new Plantacion(
                "Plantacion ",
                "Antioquia",
                EnumCultivo.TOMATE,
                Categoria.HORTALIZA
        );

        for (Cultivo cultivo : cultivos) {
            plantacion.agregarCultivo(cultivo);
        }

        return plantacion;
    }
}