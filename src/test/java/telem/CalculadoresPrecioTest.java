package telem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

public class CalculadoresPrecioTest {

    // Método auxiliar para crear un alquiler
    private Alquiler crearAlquiler(Cliente cliente,
                                   LocalDate inicio,
                                   LocalDate fin) {

        Vehiculo vehiculo = new Turismo(
            "ABC123", Categoria.NORMAL, 2020, 5, 400.0
        );

        return new Alquiler(vehiculo, cliente, inicio, fin);
    }

    // 1. TEST PRECIO NORMAL
    @Test
    public void testPrecioNormal() {

        Cliente cliente = new Cliente("Juan", "123");

        Alquiler alquiler = crearAlquiler(
            cliente,
            LocalDate.of(2026, 5, 10),
            LocalDate.of(2026, 5, 15)
        );

        CalculadorPrecioNormal calculador =
            new CalculadorPrecioNormal();

        int resultado = calculador.calcularPrecioAlquiler(alquiler);

        assertEquals(250, resultado);
    }

    // 2. TEST TEMPORADA ALTA
    @Test
    public void testTemporadaAlta() {

        Cliente cliente = new Cliente("Juan", "123");

        Alquiler alquiler = crearAlquiler(
            cliente,
            LocalDate.of(2026, 7, 10),
            LocalDate.of(2026, 7, 15)
        );

        CalculadorPrecioTemporadaAlta calculador =
            new CalculadorPrecioTemporadaAlta();

        int resultado = calculador.calcularPrecioAlquiler(alquiler);

        assertEquals(500, resultado);
    }

    // 3. TEST OFERTÓN
    @Test
    public void testOferton() {

        Cliente cliente = new Cliente("Juan", "123");

        Alquiler alquiler = crearAlquiler(
            cliente,
            LocalDate.of(2026, 1, 10),
            LocalDate.of(2026, 1, 20)
        );

        CalculadorPrecioOferton calculador =
            new CalculadorPrecioOferton();

        int resultado = calculador.calcularPrecioAlquiler(alquiler);

        assertEquals(300, resultado);
    }

    // 4. TEST CLIENTE FRECUENTE
    @Test
    public void testClienteFrecuente() {

        Cliente cliente = new Cliente("Juan", "123");

        CalculadorPrecioClienteFrecuente calculador =
            new CalculadorPrecioClienteFrecuente();

        // Registramos 4 alquileres anteriores del mismo cliente
        for (int i = 0; i < 4; i++) {

            Alquiler anterior = crearAlquiler(
                cliente,
                LocalDate.of(2025, 1, 1).plusDays(i * 2),
                LocalDate.of(2025, 1, 2).plusDays(i * 2)
            );

            calculador.gestor.agregarAlquiler(anterior);
        }

        // Alquiler actual de 10 días
        Alquiler alquiler = crearAlquiler(
            cliente,
            LocalDate.of(2026, 5, 10),
            LocalDate.of(2026, 5, 20)
        );

        int resultado = calculador.calcularPrecioAlquiler(alquiler);

        assertEquals(300, resultado);
    }
}
