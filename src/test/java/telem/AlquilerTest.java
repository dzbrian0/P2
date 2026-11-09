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
    
}
