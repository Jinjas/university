package aula4;

/**
public class main{
    public static void main(String[] args) throws InterruptedException {
        int N = 10;

        Barrier bar = new Barrier(N);
        Thread[] threads = new Thread[N];

        for (int i = 0 ; i < N; i++){
            threads[i] = new Thread (new Increment(bar));
        }

        for (int i = 0 ; i < N; i++){
            threads[i].start();
        }

        for (int i = 0 ; i < N; i++) {
            threads[i].join();
        }
    }
}
*/
public class main{
    public static void main(String[] args) throws InterruptedException {
        int N = 10;

        Barrier bar = new Barrier(N);
        Thread[] threads = new Thread[N];

        for (int i = 0 ; i < N; i++){
            int myId = i;
            threads[i] = new Thread (() -> {
                try {
                    Thread.sleep(1000 * myId);
                    System.out.println("thread " + myId + " is starting round1...");
                    bar.espera();
                    System.out.println("thread " + myId + " finished round1");
                    System.out.println("thread " + myId + " is starting round2...");
                    bar.espera();
                    System.out.println("thread " + myId + " finished round2");

                }
                catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            });
        }

        for (int i = 0 ; i < N; i++){
            threads[i].start();
        }

        for (int i = 0 ; i < N; i++) {
            threads[i].join();
        }
    }
}

