package ces2.trabajo3.Modelo;

import java.util.ArrayDeque;
import java.util.Deque;

public class Plantacion {

    private String nombre;
    private String ubicacion;
    private EnumCultivo tipoCultivo;
    private Categoria categoria;
    private Deque<Cultivo> cultivos;

    public Plantacion() {
        this.cultivos = new ArrayDeque<>();
    }

    public Plantacion(String nombre, String ubicacion,
                      EnumCultivo tipoCultivo, Categoria categoria) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipoCultivo = tipoCultivo;
        this.categoria = categoria;
        this.cultivos = new ArrayDeque<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Deque<Cultivo> getCultivos() {
        return cultivos;
    }

    public void setCultivos(Deque<Cultivo> cultivos) {
        this.cultivos = cultivos;
    }

    public void agregarCultivo(Cultivo cultivo) {
        cultivos.addLast(cultivo);
    }
}
