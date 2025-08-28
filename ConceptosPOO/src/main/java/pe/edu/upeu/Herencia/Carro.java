package pe.edu.upeu.Herencia;


    public class Carro extends Vehiculo{


        public static void main(String[] args) {
            Carro c= new Carro();
            System.out.println("Caracteristicas");

            c.marca="Toyota";
            System.out.println("Marca"+c.marca);
            System.out.println("Modelo"+c.modelo);
            System.out.println("Color"+"No se puede "+" Heredar pór ser privado ");
            c.sonid();
        }
    }

