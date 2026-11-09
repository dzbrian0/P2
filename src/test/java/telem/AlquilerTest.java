package telem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Date;

public class AlquilerTest {

    @Test
    public void testPrecioAlquiler() {
        Turismo turismo = new Turismo("1234abc", Categoria.NORMAL, 2020, 5, 400.0);
        Cliente cliente = new Cliente("Juan", "12345678a");

        Date inicio = new Date(0);
        Date fin = new Date(3L*24*60*60*1000);

        Alquiler alquiler = new Alquiler(turismo, cliente, inicio, fin);
        
        assertEquals(150, alquiler.calcularPrecioAlquiler(inicio, fin));
    }

    @Test
    public void testDeserializacion() {
        Turismo turismo = new Turismo("1234ABC", Categoria.NORMAL, 2020, 5, 400.0);
        Cliente cliente = new Cliente("Juan", "12345678A");

        Alquiler alquiler = new Alquiler(turismo, cliente, new Date(0), new Date(86400000L)); //86400000L representan los ms de un día, L indica que es un num del tipo long.

        String json = alquiler.toString();
        Alquiler recuperado = new Alquiler(json);

        assertEquals("Juan", recuperado.getCliente().getNombre());
        assertEquals("Turismo", recuperado.getVehiculo().getTipo());
        assertEquals(86400000L, recuperado.getFechaFin().getTime());
    }
    
}
