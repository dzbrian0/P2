package telem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;

public class AlquilerTest {

    @Test
    public void testPrecioAlquiler() {
        Turismo turismo = new Turismo("1234abc", Categoria.NORMAL, 2020, 5, 400.0);
        Cliente cliente = new Cliente("Juan", "12345678a");

        LocalDate inicio = LocalDate.of(1970, 1, 1);
        LocalDate fin = inicio.plusDays(3);

        Alquiler alquiler = new Alquiler(turismo, cliente, inicio, fin);
        
        assertEquals(150, alquiler.calcularPrecioAlquiler(inicio, fin));
    }

    @Test
    public void testDeserializacion() {
        Turismo turismo = new Turismo("1234ABC", Categoria.NORMAL, 2020, 5, 400.0);
        Cliente cliente = new Cliente("Juan", "12345678A");

        Alquiler alquiler = new Alquiler(turismo, cliente, LocalDate.of(1970, 1, 1), LocalDate.of(1970, 1, 2));

        String json = alquiler.toString();

        Alquiler recuperado = new Alquiler(json);

        assertEquals("Juan", recuperado.getCliente().getNombre());
        assertEquals("Turismo", recuperado.getVehiculo().getTipo());
        assertEquals(LocalDate.of(1970, 1, 2), recuperado.getFechaFin());
    }
    
}
