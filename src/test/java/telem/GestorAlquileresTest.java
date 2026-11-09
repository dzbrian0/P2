
package telem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Date;

public class GestorAlquileresTest {

    @Test
    public void testGuardarYCargar() {
        GestorAlquileres gestor = new GestorAlquileres();

        Turismo turismo = new Turismo("1234ABC", Categoria.NORMAL, 2020, 5, 400.0);
        Cliente cliente = new Cliente("Juan", "12345678A");
        Alquiler alquiler = new Alquiler(turismo, cliente, new Date(0), new Date(86400000L));

        gestor.agregarAlquiler(alquiler);
        gestor.guardarAlquileres("prueba-alquileres.json");

        GestorAlquileres gestor2 = new GestorAlquileres();
        gestor2.cargarAlquileres("prueba-alquileres.json");

        assertEquals("Juan", gestor2.obtenerAlquileres()[0].getCliente().getNombre());
        assertEquals("Turismo", gestor2.obtenerAlquileres()[0].getVehiculo().getTipo());
    }
}
