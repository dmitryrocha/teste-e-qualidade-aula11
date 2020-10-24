package br.ucsal.bes20202.aula11.dmitryrocha;

public class Classe1 {
    public static int metodo1() {
        return 1;
    }

    private static int metodo2() {
        return 2;
    }

    private int metodo3() {
        return 3;
    }

    public void metodo4() {
        System.out.println("metodo1()=" + metodo1());
        System.out.println("metodo2()=" + metodo2());
        System.out.println("metodo3()=" + metodo3());
    }

    public int metodo5() {
        return metodo1() + metodo2() + metodo3();
    }
    
    private int metodo6() {
        return metodo1() + metodo2() + metodo3();
    }

    private int metodo7(int n1, int n2){
        return n1 + n2;
    }

}
