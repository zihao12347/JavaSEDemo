package staticdemo;


public class StaticCodeArea {
    static {
        System.out.println("I AM A CONTENT AT STATIC CODE AREA !");
    }

    public StaticCodeArea() {
        System.out.println("I A CONSTRUCTION METHOD!");
    }

    public static void main(String[] args) {

        System.out.println(" I AM A MAIN METHOD!");
    }

}
