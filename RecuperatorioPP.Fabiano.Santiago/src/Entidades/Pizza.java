
package Entidades;

public class Pizza extends Producto implements IVendible {
    private TipoPizza sabor;
    private TamañoPizza tamaño;
    
    public Pizza(String nombre,double precio, Fabricante fabricante,TipoPizza sabor, TamañoPizza tamaño) {
        super(nombre, precio, fabricante);
        this.sabor = sabor;
        this.tamaño = tamaño;
    }
    
    @Override
    public double getPrecioTotal() {
        double incremento = 0;
        
        switch (tamaño) {
            case CHICA:
                incremento = 0.05;
                break;
            case MEDIANA:
                incremento = 0.10;
                break;
            case GRANDE: 
                incremento = 0.20;
                break;
        }
        return precio + (precio * incremento);
    }
    
    @Override
    public String toString() {
        return "Pizza: " + nombre + " Sabor: " + sabor + " Tamaño: " + tamaño + " Precio base: " + precio + " Precio total: " + getPrecioTotal();
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Pizza)) {
            return false;
        }
        Pizza otra = (Pizza) object;
        return Producto.sonIguales(this, otra)
                && this.sabor == otra.sabor
                && this.tamaño == otra.tamaño;
    }
    
}
