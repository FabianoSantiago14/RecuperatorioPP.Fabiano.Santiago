package Entidades;

import java.util.Random;

public abstract class Producto {

    protected Fabricante fabricante;
    protected String nombre;
    protected double precio;
    protected int tiempoPreparacion;
    protected int calorias;
    protected static Random generadorAleatorio;

    static {
        generadorAleatorio = new Random();
    }

    public Producto(String nombre, double precio, Fabricante fabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
    }

    public Producto(String nombre, double precio, String nombreFabricante, String ciudadFabricante, int antiguedadFabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = new Fabricante(nombreFabricante, ciudadFabricante, antiguedadFabricante);
    }

    public int getCalorias() {
        if (calorias == 0) {
            calorias = generadorAleatorio.nextInt(601) + 200;

        }
        return calorias;

    }

    public int getTiempoPreparacion() {
        if (tiempoPreparacion == 0) {
            tiempoPreparacion = generadorAleatorio.nextInt(16) + 5;

        }
        return tiempoPreparacion;
    }

    private static String mostrar(Producto producto) {
        return "Nombre: " + producto.nombre + "Precio: " + producto.precio + "Calorias: " + producto.getCalorias() + "Tiempo de preparacion: " + producto.getTiempoPreparacion() + "Fabricante: " + producto.fabricante.toString();
    }

    protected static boolean sonIguales(Producto producto1, Producto producto2) {
        return producto1.nombre.equals(producto2.nombre) && Fabricante.sonIguales(producto1.fabricante, producto2.fabricante);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Producto)) {
            return false;
        }
        Producto otro = (Producto) object;
        return this.nombre.equals(otro.nombre)
                && Fabricante.sonIguales(this.fabricante, otro.fabricante);
    }
    
    @Override
    public String toString() {
        return mostrar(this);
    }

}
