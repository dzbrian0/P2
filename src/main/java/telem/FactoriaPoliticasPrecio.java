package telem;
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
}


