package telem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TurismoTest {

    @Test
    public void testTurismo() {
        Turismo turismo = new Turismo("1234abc", Categoria.NORMAL, 2020, 5, 400.0);

        assertEquals("1234abc", turismo.getMatricula());
        assertEquals(5, turismo.getPlazas());
    }

    @Test
    public void testDisponibilidad(){
        Turismo turismo = new Turismo("1234abc", Categoria.NORMAL, 2020, 5, 400.0);

        turismo.setDisponible(true);
        assertTrue(turismo.isDisponible());

        turismo.setDisponible(false);
        assertFalse(turismo.isDisponible());
        
    }
}

