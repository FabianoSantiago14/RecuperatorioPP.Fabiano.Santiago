package Entidades;

public class Postre extends Producto implements IVendible {

    private TipoPostre tipoPostre;

    public Postre(String nombre, double precio, Fabricante fabricante, TipoPostre tipoPostre) {
        super(nombre, precio, fabricante);
        this.tipoPostre = tipoPostre;
    }

    @Override
    public double getPrecioTotal() {
        double incremento = 0;

        switch (tipoPostre) {
            case TIRAMISU:
                incremento = 0.20; 
                break;
            case HELADO:
                incremento = 0.15; 
                break;
            case FLAN:
                incremento = 0.10; 
                break;
        }

        return precio + (precio * incremento);
    }
    
    public String toString() {
        return "Postre: " + nombre + " Tipo: " + tipoPostre + " Precio: " + precio + " Precio Total: " + getPrecioTotal();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Postre)) {
            return false;
        }
        Postre otro = (Postre) obj;
        
        return Producto.sonIguales(this, otro)
                && this.tipoPostre == otro.tipoPostre;
    }

}
