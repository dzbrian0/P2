
package telem;
import java.time.LocalDate; //vi que esta clase es menos obsoleta
import telem.GestorAlquileres;
import java.time.temporal.ChronoUnit; 
import telem.GestorAlquileres;


public class CalculadorPrecioClienteFrecuente implements IcalculadorPrecio{
    @Override
    public int calcularPrecioAlquiler(Alquiler alquiler) {
           
       LocalDate x = alquiler.getFechaInicio();
        LocalDate y = alquiler.getFechaFin();

          //para el tiempo de alquiler uso el método chronoUnit, indicado en la guía.
        int TiempodeAlquiler = (int) ChronoUnit.DAYS.between(x, y);

        int alquilerActual = alquiler.calcularPrecioAlquiler(x, y);

              if(gestor.esClienteFrecuente().equals(true)){
          
                    if(TiempodeAlquiler <= 3 && TiempodeAlquiler >0 ){
                     int precio = (int) (alquilerActual*0.8);
                     return precio;}

                     else if(TiempodeAlquiler >= 4){
                     int precio = (int) (alquilerActual*0.6);
                      return precio;}
              }   
                      return alquilerActual;

           

            }
                    

}