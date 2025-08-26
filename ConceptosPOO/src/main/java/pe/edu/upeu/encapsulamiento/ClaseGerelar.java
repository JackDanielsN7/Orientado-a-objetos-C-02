package pe.edu.upeu.encapsulamiento;

public class ClaseGerelar {
    public static void main(String[] args) {
        Persona p = new Persona();//P es=objeto
        //p.nombre = "Jack";
        //p.edad = 20;
        p.saludo();
        p.setNombre("jack");//Encapsula
        p.setEdad(20);//Encapsulamiento
        p.apellido="Mario";//No se esta aplicando emcapsulamiento
        p.saludo();

        Trabajador t1 = new Trabajador();
        t1.setNombre("Jack");
        t1.setApellido("Daniels");
        t1.setEdad(20);
        t1.setArea("Sistema");
        t1.setGenero('M');
        System.out.println(t1);
    }
}
