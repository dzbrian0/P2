package telem;

import java.util.Date;

import org.json.JSONObject;

/**
 * Modela un alquiler de un vehículo por parte de un cliente, con fechas de inicio y fin.
 * Almacena los alquileres realizados en un array estático y proporciona métodos para calcular el precio del alquiler.
 * Alquiler
 */
public class Alquiler {
    
    private Vehiculo vehiculo;
    private Cliente cliente;
    private Date fechaInicio;
    private Date fechaFin;

    private static Alquiler[] alquileres = new Alquiler[1000];

    public static final int PRECIO_BASE = 50;
    private static int contadorAlquileres = 0;

    public Alquiler(Vehiculo vehiculo, Cliente cliente, Date fechaInicio, Date fechaFin) {
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    //Deserializamos
    public Alquiler(String jsonString) {
        JSONObject json = new JSONObject(jsonString);
        this.cliente = new Cliente(json.getJSONObject("cliente").toString());
        this.vehiculo = FactoriaVehiculos.getVehiculo(json.getJSONObject("vehiculo").toString());
        this.fechaInicio = new Date(json.getLong("fechaInicio"));
        this.fechaFin = new Date(json.getLong("fechaFin"));
    }

    public static Alquiler[] obtenerAlquileres() {
        return alquileres; 
    }

    public static void agregarAlquiler(Alquiler alquiler) {
        if (contadorAlquileres < alquileres.length) {
            alquileres[contadorAlquileres] = alquiler;
            contadorAlquileres++;
        } else {
            System.out.println("No se pueden agregar más alquileres. Capacidad máxima alcanzada.");
        }
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public int calcularPrecioAlquiler(Date fechaInicio, Date fechaFin) {
        int dias = (int) ((fechaFin.getTime() - fechaInicio.getTime()) / (1000 * 60 * 60 * 24));
        return dias * PRECIO_BASE;
    }

    //Serializamos
    @Override 
    public String toString() {
        JSONObject json = new JSONObject(this);
        json.put("fechaInicio", fechaInicio.getTime());
        json.put("fechaFin", fechaFin.getTime());
        return json.toString();
    }

    public static void main(String[] args) {
        // Crear instancias de Vehiculo y Cliente
        Vehiculo vehiculo1 = new Turismo("ABC123", Categoria.NORMAL, 2020, 5, 400.0);
        Cliente cliente1 = new Cliente("Juan Pérez", "123456789");
        Alquiler alquiler1 = new Alquiler(vehiculo1, cliente1, new Date(), new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000)); // Alquiler de 3 días
        
        System.out.println(alquiler1.toString());
        //Lo serializamos
        String json = alquiler1.toString();

        //Lo deserializamos
        Alquiler recuperado = new Alquiler(json);

        //Comprobamos que efectivamente recuperamos los datos de ese cliente y vehiculo
        System.out.println("Cliente recuperado: " + recuperado.getCliente().getNombre());
        System.out.println("Vehiculo recuperado: " + recuperado.getVehiculo().getTipo());

        Vehiculo vehiculo2 = new VehiculoIndustrial("ABC123", Categoria.NORMAL, 2020, 1000, 3);
        Alquiler alquiler2 = new Alquiler(vehiculo2, cliente1, new Date(), new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000)); // Alquiler de 3 días

        System.out.println(alquiler2.toString());
        System.out.println("--------------------------------------------------------");
    }
}
