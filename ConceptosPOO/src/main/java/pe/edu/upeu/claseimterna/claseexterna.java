package pe.edu.upeu.claseimterna;

public class claseexterna {
    int a, b;

    class claseinterna1{
        double r;
        double sumar(){
            r=a+b;
            return b;
        }
    }
    class claseinterna2{
        double r;
        double restar(){
            r=a-b;
            return b;
        }


    }

    public static void main(String[] args) {
        claseexterna c = new claseexterna();
        c.a=4;
        c.b=3;
        claseinterna1 ci1=c.new claseinterna1();
        System.out.println(ci1.sumar());

        claseinterna2 ci2=c.new claseinterna2();
        ci2.restar();
        System.out.println(ci2.r);
    }
}
class claseexterna3{

}
