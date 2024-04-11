package aula2ex1;

import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private static class Account {
        private int balance;
        Account(int balance) { this.balance = balance; }
        int balance() { return balance; }
        boolean deposit(int value) {
            balance += value;
            return true;
        }
        boolean withdraw(int value) {
            if (value > balance)
                return false;
            balance -= value;
            return true;
        }
    }

    // Bank slots and vector of accounts

    private int slots;
    private Account[] av;
    private ReentrantLock[] lock;

    public Bank(int n) {
        slots=n;
        av=new Account[slots];
        lock=new ReentrantLock[slots];
        for (int i=0; i<slots; i++) {
            lock[i] = new ReentrantLock();
            av[i]=new Account(0);
        }
    }

    // Account balance
    public int balance(int id) {
        if (id < 0 || id >= slots)
            return 0;

        try{
            this.lock[id].lock();
            return av[id].balance();
        } finally {
            this.lock[id].unlock();
        }

        //return av[id].balance();
    }

    public int totalBalance(){
        int result = 0;
        for (int id=0; id<slots; id++) {
            this.lock[id].lock();
            result += av[id].balance();

        }
        for (int id=0;id<slots;id++){
            this.lock[id].unlock();
        }
        return result;
    }

    public int totalBalance2(){
        int result = 0;
        for (int id=0;id<slots;id++){
            this.lock[id].lock();
        }
        for (int id=0; id<slots; id++) {
            result += av[id].balance();
            this.lock[id].unlock();
        }
        return result;
    }

    boolean transfer (int from, int to, int value){
        if (to < 0 || to >= slots || from < 0 || from >= slots) {
            return false;
        }

        if (from < to) {
            this.lock[from].lock();
            if (av[from].balance < value){
                this.lock[from].unlock();
                return false;
            }

            withdraw(from,value);  //tirou com sucesso dinheiro

            this.lock[to].lock();
            this.lock[from].unlock();

            deposit(to,value); //colocou o dinheiro na conta
            this.lock[to].unlock();

            return true;
        }

        this.lock[to].lock();
        this.lock[from].lock();

        if (av[from].balance < value){
            this.lock[from].unlock();
            return false;
        }

        withdraw(from, value);  //tirou com sucesso dinheiro
        this.lock[from].unlock();

        deposit(to, value); //colocou o dinheiro na conta
        this.lock[to].unlock();

        return true;
    }


    // Deposit
    public boolean deposit(int id, int value) {
        if (id < 0 || id >= slots)
            return false;

        try{
            this.lock[id].lock();
            return av[id].deposit(value);
        } finally {
            this.lock[id].unlock();
        }
    }

    // Withdraw; fails if no such account or insufficient balance
    public boolean withdraw(int id, int value) {
        if (id < 0 || id >= slots)
            return false;
        try{
            this.lock[id].lock();
            return av[id].withdraw(value);
        } finally {
            this.lock[id].unlock();
        }
    }
}
