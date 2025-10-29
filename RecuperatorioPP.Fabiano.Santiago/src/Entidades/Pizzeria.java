package Entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Pizzeria implements Iterable<Producto> {

    private String nombre;
    private int capacidad;
    private Collection<Producto> productos;

    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.capacidad = 3;
        this.productos = new ArrayList<>();
    }


    public Pizzeria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();

    }
    
    private boolean sonIguales(Producto producto) {
        for (Producto pro: productos) {
            if (pro.equals(producto)) {
                return true;
            }
        }
        return false;
    }
    
    public void agregar(Producto producto) {
        if (productos.size() >= capacidad) {
            System.out.println("No se puede agregar '" + producto.nombre + ": capacidad máxima alcanzada");
        } else if (sonIguales(producto)) {
            System.out.println("El producto '" + producto.nombre + " ya existe en la pizzeria");
        } else {
            productos.add(producto);
            System.out.println("Producto agregado: " + producto.nombre);
        }
    }
    
    private double getPrecioProductos(TipoProducto tipo) {
        double total = 0;

        for (Producto p : productos) {
            if (tipo == TipoProducto.TODOS) {
                total += ((IVendible) p).getPrecioTotal();
            } else if (tipo == TipoProducto.PIZZAS && p instanceof Pizza) {
                total += ((IVendible) p).getPrecioTotal();
            } else if (tipo == TipoProducto.POSTRES && p instanceof Postre) {
                total += ((IVendible) p).getPrecioTotal();
            }
        }

        return total;
    }
    
    private double getPrecioDePizzas() {
        return getPrecioProductos(TipoProducto.PIZZAS);
    }

    private double getPrecioDePostres() {
        return getPrecioProductos(TipoProducto.POSTRES);
    }

    private double getPrecioTotal() {
        return getPrecioProductos(TipoProducto.TODOS);
    }
    
    @Override
    public Iterator<Producto> iterator() {
        return productos.iterator();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Pizzeria: ").append(nombre)
          .append(" Capacidad: ").append(capacidad)
          .append(" Productos actuales: ").append(productos.size())
          .append("LISTA DE PRODUCTOS");

        for (Producto p : productos) {
            sb.append(p.toString()).append("\n");
        }

        sb.append("RESUMEN DE PRECIOS");
        sb.append("Total Pizzas: ").append(String.format("%.2f", getPrecioDePizzas())).append("\n");
        sb.append("Total Postres: ").append(String.format("%.2f", getPrecioDePostres())).append("\n");
        sb.append("Total General: ").append(String.format("%.2f", getPrecioTotal())).append("\n");

        return sb.toString();
    }
    
    
    
}
