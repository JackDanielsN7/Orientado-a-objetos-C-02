package pe.edu.upeu.claseinterface;

public class Gato implements Animal {
    @Override
    public void emitirSonido() {
        System.out.println("Miu...meu..");
    }

    @Override
    public void dormir() {
        System.out.println("Zzzz...Zzz..");
    }
}
