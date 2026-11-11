package telem;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ClienteTest 
{
    @Test 
    public void testCliente() {
        Cliente cliente = new Cliente("Juan", "12345678A");

        assertEquals("Juan", cliente.getNombre());
        assertEquals("12345678A", cliente.getDni());

    }
}
