package aula4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//nao reutilizavel
/**
public class Barrier {
    int n;
    ReentrantLock l = new ReentrantLock();
    Condition cond = l.newCondition();
    Barrier (int N) {
        this.n = N;
    }
    void espera() throws InterruptedException{

        try {
            this.l.lock();
            this.n -= 1;
            if (this.n == 0)
                cond.signalAll();
            else
                while (n != 0)
                    cond.await();
        }
        finally{
            this.l.unlock();
        }
    }

}

*/

public class Barrier {
    int n;
    int c;
    int epoch;
    ReentrantLock l = new ReentrantLock();
    Condition cond = l.newCondition();
    Barrier (int N) {
        this.n = N;
    }
    void espera() throws InterruptedException{

        try {
            this.l.lock();
            int e = epoch;
            c += 1;
            if (c < n)
                while (epoch == e)
                    cond.await();
            else {
                cond.signalAll();
                c = 0;
                epoch += 1;
            }
        }
        finally{
            this.l.unlock();
        }
    }

}