package telem;

import org.json.JSONObject;

public class Motocicleta extends Vehiculo {

    int cilindrada;

    public Motocicleta(String matricula, Categoria categoria, int annio,
        int cilindrada
    ) {
        super(matricula, categoria, annio);
        this.cilindrada = cilindrada;
    }

    //Deserializamos
    public Motocicleta(String jsonString) {
        super(jsonString);
        JSONObject json = new JSONObject(jsonString);
        this.cilindrada = json.getInt("cilindrada");
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override 
    public String getTipo() {
        return "Motocicleta";
    }

}
