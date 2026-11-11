package telem;
import java.time.LocalDate; //vi que esta clase es menos obsoleta
import telem.GestorAlquileres;
import java.time.temporal.ChronoUnit; 
import telem.Alquiler;



public class CalculadorPrecioClienteFrecuente implements IcalculadorPrecio{
  

     public GestorAlquileres gestor = new GestorAlquileres();
    //hago un objeto gestor para invocar el metodo  esClienteFrecuente()

      @Override
    public int calcularPrecioAlquiler(Alquiler alquiler) {
       LocalDate x = alquiler.getFechaInicio();
        LocalDate y = alquiler.getFechaFin();

          //para el tiempo de alquiler uso el método chronoUnit, indicado en la guía.
        int TiempodeAlquiler = (int) ChronoUnit.DAYS.between(x, y);
Cliente cliente = alquiler.getCliente();
int umbral = 3; //umbral de días para aplicar el descuento
        int alquilerActual = alquiler.calcularPrecioAlquiler(x, y);
                 if (gestor.esClienteFrecuente(cliente, umbral) == 
                true) {
                  
                    if(TiempodeAlquiler <= 3 && TiempodeAlquiler >0 ){
                     int precio = (int) (alquilerActual*0.8);
                     return precio;}

                     else if(TiempodeAlquiler >= 4){
                     int precio = (int) (alquilerActual*0.6);
                      return precio;}
              }   
                      return alquilerActual;

           

            }
                    public static void main(String[] args) {

    Vehiculo vehiculo = new Turismo(
        "ABC123", Categoria.NORMAL, 2020, 5, 400.0
    );

    Cliente cliente = new Cliente("Juan Pérez", "123456789");

    Alquiler alquiler = new Alquiler(
        vehiculo,
        cliente,
        LocalDate.of(2026, 5, 10),
        LocalDate.of(2026, 5, 20)
    );

    CalculadorPrecioClienteFrecuente calculador =
        new CalculadorPrecioClienteFrecuente();

    System.out.println(
        "Precio cliente frecuente: " +
        calculador.calcularPrecioAlquiler(alquiler)
    );
}

}