package pe.edu.upeu.abspolimorfismo;

public class Loro extends animal {
    @Override
    void imitirSonido() {
        System.out.println("Hey..No te distraigas");
    }
    @Override
    void dormir() {
        super.dormir();
        System.out.println("Zzz...zz");
    }
}
