package telem;
import java.time.LocalDate; //vi que esta clase es menos obsoleta
import telem.GestorAlquileres;
import java.time.temporal.ChronoUnit; 


public class CalculadorPrecioOferton implements IcalculadorPrecio {

    @Override
    public int calcularPrecioAlquiler(Alquiler alquiler) {

  LocalDate x = alquiler.getFechaInicio();
        LocalDate y = alquiler.getFechaFin();

        int alquilerActual = alquiler.calcularPrecioAlquiler(x, y);
       
       if ( x.getMonthValue() == 1 ||
                x.getMonthValue() == 2 ||
                x.getMonthValue() == 11)
                
                {
                  if(TiempodeAlquiler >= 7 ){
                   precio = (int) (0.6*alquilerActual);
                    return precio;}

               else { precio = (int) (0.7*alquilerActual);
                 return precio; }

              }
                      return alquilerActual;

              }
       
       }