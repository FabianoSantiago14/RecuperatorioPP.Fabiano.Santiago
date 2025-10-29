package Entidades;

public class Fabricante {

    private String nombre;
    private String ciudad;
    private int antiguedad;

    public Fabricante(String nombre, String ciudad, int antiguedad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.antiguedad = antiguedad;
    }

    public static boolean sonIguales(Fabricante fabricante1, Fabricante fabricante2) {
        return fabricante1.nombre.equals(fabricante2.nombre) && fabricante1.ciudad.equals(fabricante2.ciudad) && fabricante1.antiguedad == fabricante2.antiguedad;
    }

    public String getInfoFabricante() {
        return "Nombre: " + this.nombre + " Ciudad: " + this.ciudad + " Antiguedad: " + this.antiguedad;
    }

    @Override
    public String toString() {
        return getInfoFabricante();
    }

}
