package telem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FactoriaVehiculosTest {

    @Test
    public void testFactoriaVehiculos() {
        Motocicleta moto = new Motocicleta("1234ABC", Categoria.NORMAL, 2020, 125);
        VehiculoIndustrial industrial = new VehiculoIndustrial("5678DEF", Categoria.NORMAL, 2020, 1000, 3);

        Vehiculo motoRecuperada = FactoriaVehiculos.getVehiculo(moto.toString());
        Vehiculo industrialRecuperado = FactoriaVehiculos.getVehiculo(industrial.toString());

        assertEquals("Motocicleta", motoRecuperada.getTipo());
        assertEquals("VehiculoIndustrial", industrialRecuperado.getTipo());
    }
    
}
