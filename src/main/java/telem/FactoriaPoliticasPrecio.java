package telem;

import java.time.LocalDate;

public class FactoriaPoliticasPrecio {

    public static IcalculadorPrecio crearPolitica(PoliticasDePrecios politica) {

        switch (politica) {

            case Normal:
                return new CalculadorPrecioNormal();

            case TemporadaAlta:
                return new CalculadorPrecioTemporadaAlta();

            case ClienteFrecuente:
                return new CalculadorPrecioClienteFrecuente();

            case Oferton:
                return new CalculadorPrecioOferton();

            default:
                throw new IllegalArgumentException("Política no válida");
        }
    }
      public static void main(String[] args) {

        // Creamos un vehículo y un cliente
        Vehiculo vehiculo = new Turismo("ABC123", Categoria.NORMAL, 2020, 5, 400.0);
        Cliente cliente = new Cliente("Juan Pérez", "123456789");

        // Creamos un alquiler de 3 días
        LocalDate hoy = LocalDate.now();
        LocalDate dentroDeTresDias = hoy.plusDays(3);

        Alquiler alquiler = new Alquiler(
            vehiculo, cliente, hoy, dentroDeTresDias
        );

        // Pedimos a la factoría una política
        IcalculadorPrecio calculador =
            FactoriaPoliticasPrecio.crearPolitica(
                PoliticasDePrecios.Normal
            );

        // Calculamos el precio
        int precio = calculador.calcularPrecioAlquiler(alquiler);

        System.out.println("Precio del alquiler: " + precio);
    }

}


