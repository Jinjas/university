package aula1ex3;

public class Main {
    public static void main( String [] args) throws InterruptedException {
        int N = 10;
        Thread[] threads = new Thread[N];
        Bank b = new Bank();
        for (int i = 0; i <N; i++){
            threads[i] = new Thread( new Deposit(100, 1000, b));
            threads[i].setName("thread " + i);
        }
        for (int i = 0 ; i < N; i++){
            threads[i].start();
        }
        for (int i = 0 ; i < N; i++){
            threads[i].join();
        }
        System.out.println(b.balance());
    }
}
