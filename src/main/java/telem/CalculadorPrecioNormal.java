package telem;
import java.time.LocalDate; //vi que esta clase es menos obsoleta
import telem.GestorAlquileres;
import java.time.temporal.ChronoUnit; 
import telem.Alquiler;


 public class CalculadorPrecioNormal implements IcalculadorPrecio{

    @Override

    public int calcularPrecioAlquiler(Alquiler alquiler) {
    int precio;

         LocalDate x = alquiler.getFechaInicio();
        LocalDate y = alquiler.getFechaFin();
       
        int alquilerActual = alquiler.calcularPrecioAlquiler(x, y);

if (x.getMonthValue() == 3 ||
           x.getMonthValue() == 4 ||
           x.getMonthValue() == 5 ||
           x.getMonthValue() == 6 ||
         x.getMonthValue() == 10 ){
      precio = alquilerActual;
       return precio;
}
        return alquilerActual;


       }

       public static void main(String[] args) {

    Vehiculo vehiculo = new Turismo(
        "ABC123", Categoria.NORMAL, 2020, 5, 400.0
    );

    Cliente cliente = new Cliente("Juan PÃ©rez", "123456789");

    Alquiler alquiler = new Alquiler(
        vehiculo,
        cliente,
        LocalDate.of(2026, 5, 10),
        LocalDate.of(2026, 5, 15)
    );

    CalculadorPrecioNormal calculador =
        new CalculadorPrecioNormal();

    System.out.println(
        "Precio normal: " + calculador.calcularPrecioAlquiler(alquiler)
    );
}
    }