
package ces2.trabajo3.Modelo;

import java.util.Stack;
import java.util.function.Function;

public class Cultivo {

    private String nombre;
    private int cantidadSemillas;
    private String ubicacion;
    private EnumCultivo tipoCultivo;
    private Categoria categoria;
    private Stack<Integer> conteo;


    public Cultivo() {
        this.conteo = new Stack<>();
    }


    public Cultivo(String nombre, int cantidadSemillas, String ubicacion,
                   EnumCultivo tipoCultivo, Categoria categoria) {
        this.nombre = nombre;
        this.cantidadSemillas = cantidadSemillas;
        this.ubicacion = ubicacion;
        this.tipoCultivo = tipoCultivo;
        this.categoria = categoria;
        this.conteo = new Stack<>();
    }


    public Cultivo(String nombre, int cantidadSemillas, String ubicacion,
                   EnumCultivo tipoCultivo, Categoria categoria,
                   Stack<Integer> conteo) {
        this.nombre = nombre;
        this.cantidadSemillas = cantidadSemillas;
        this.ubicacion = ubicacion;
        this.tipoCultivo = tipoCultivo;
        this.categoria = categoria;
        this.conteo = conteo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadSemillas() {
        return cantidadSemillas;
    }

    public void setCantidadSemillas(int cantidadSemillas) {
        this.cantidadSemillas = cantidadSemillas;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public EnumCultivo getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(EnumCultivo tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Stack<Integer> getConteo() {
        return conteo;
    }

    public void setConteo(Stack<Integer> conteo) {
        this.conteo = conteo;
    }


    public void agregarConteo(int cantidad) {
        conteo.push(cantidad);
    }


    public int sumarConteo() {
        return conteo.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }


    public void verTotales(Function<Cultivo, Integer> funcion) {
        System.out.println("Cultivo: " + nombre);
        System.out.println("Total del conteo: " + funcion.apply(this));
    }
}

