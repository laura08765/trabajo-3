
package ces2.trabajo3.Repositorio;

import ces2.trabajo3.Modelo.Categoria;
import ces2.trabajo3.Modelo.Cultivo;
import ces2.trabajo3.Modelo.EnumCultivo;

import java.util.Stack;

public class CultivoRepositorio {

    public static Stack<Cultivo> crearCultivos() {

        Stack<Cultivo> cultivos = new Stack<>();

        Cultivo cultivo1 = new Cultivo(
                "Tomate", 50, "Invernadero",
                EnumCultivo.TOMATE, Categoria.HORTALIZA
        );
        cultivo1.agregarConteo(10);
        cultivo1.agregarConteo(20);
        cultivo1.agregarConteo(30);

        Cultivo cultivo2 = new Cultivo(
                "Zanahoria", 40, "Huerta",
                EnumCultivo.TOMATE, Categoria.HORTALIZA
        );
        cultivo2.agregarConteo(5);
        cultivo2.agregarConteo(15);

        Cultivo cultivo3 = new Cultivo(
                "Maiz", 100, "Campo abierto",
                EnumCultivo.TOMATE, Categoria.HORTALIZA
        );
        cultivo3.agregarConteo(25);
        cultivo3.agregarConteo(35);
        cultivo3.agregarConteo(40);

        Cultivo cultivo4 = new Cultivo(
                "Frijol", 80, "Parcela",
                EnumCultivo.TOMATE, Categoria.HORTALIZA
        );
        cultivo4.agregarConteo(12);
        cultivo4.agregarConteo(18);

        Cultivo cultivo5 = new Cultivo(
                "Lechuga", 60, "Invernadero",
                EnumCultivo.TOMATE, Categoria.HORTALIZA
        );
        cultivo5.agregarConteo(8);
        cultivo5.agregarConteo(22);

        cultivos.push(cultivo1);
        cultivos.push(cultivo2);
        cultivos.push(cultivo3);
        cultivos.push(cultivo4);
        cultivos.push(cultivo5);

        return cultivos;
    }
}
