package modelos;

// Crear equipo: Esta opción te permitirá crear un nuevo equipo. Deberás pedir al usuario el nombre del equipo.

public class Equipo {

    String nombreEquipo;

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombre(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }


}
