package telem;

import java.time.LocalDate; //vi que esta clase es menos obsoleta
import java.time.temporal.ChronoUnit;


public class CalculadorPrecioOferton implements IcalculadorPrecio {

    @Override
    public int calcularPrecioAlquiler(Alquiler alquiler) {
    int precio;
  LocalDate x = alquiler.getFechaInicio();
        LocalDate y = alquiler.getFechaFin();

                  //para el tiempo de alquiler uso el método chronoUnit, indicado en la guía.
        int TiempodeAlquiler =(int) ChronoUnit.DAYS.between(x, y);

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

              public static void main(String[] args) {

    Vehiculo vehiculo = new Turismo(
        "ABC123", Categoria.NORMAL, 2020, 5, 400.0
    );

    Cliente cliente = new Cliente("Juan Pérez", "123456789");

    Alquiler alquiler = new Alquiler(
        vehiculo,
        cliente,
        LocalDate.of(2026, 1, 10),
        LocalDate.of(2026, 1, 20)
    );

    CalculadorPrecioOferton calculador =
        new CalculadorPrecioOferton();

    System.out.println(
        "Precio con oferta: " + calculador.calcularPrecioAlquiler(alquiler)
    );
}
       
       }