package aula4;


public class Increment implements Runnable {
    Barrier bar;
    Increment(Barrier bar){
        this.bar = bar;
    }
    public void run() {

        System.out.println("olaI");
        try {
            bar.espera();
            System.out.println("olaI2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
