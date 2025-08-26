package pe.edu.upeu.encapsulamiento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Trabajador {
    private String nombre;
    private String apellido;
    private String area;
    private int edad;
    private char genero;

    @Override
    public String toString() {
        return "Tiene las siguientes caracteristicas:\n"+
                "Nombre: "+nombre+"\n"+
                "Apellido: "+apellido+"\n";

    }
}
