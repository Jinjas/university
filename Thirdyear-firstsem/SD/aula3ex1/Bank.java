package aula3ex1;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Bank {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readlock =lock.readLock();
    private final Lock writelock =lock.writeLock();

    private static class Account {
        private int balance;
        private final ReentrantLock lock = new ReentrantLock();
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

    private Map<Integer, Account> map = new HashMap<Integer, Account>();
    private int nextId = 0;

    // create account and return account id
    public int createAccount(int balance) {
        Account c = new Account(balance);
        this.writelock.lock();
        int id = nextId;
        nextId += 1;
        map.put(id, c);
        this.writelock.unlock();
        return id;
    }

    // close account and return balance, or 0 if no such account
    public int closeAccount(int id) {

        this.writelock.lock();

        Account c = map.remove(id);
        if (c == null){
            this.writelock.unlock();
            return 0;
        }

        c.lock.lock();
        this.writelock.unlock();
        int balance = c.balance();
        c.lock.unlock();

        return balance;
    }

    // account balance; 0 if no such account
    public int balance(int id) {
        this.readlock.lock();
        Account c = map.get(id);
        if (c == null) {
            this.readlock.unlock();
            return 0;
        }
        c.lock.lock();
        this.readlock.unlock();

        try{
            return c.balance();
        }finally{
            c.lock.unlock();
        }
    }

    // deposit; fails if no such account
    public boolean deposit(int id, int value) {
        this.readlock.lock();
        Account c = map.get(id);
        if (c == null) {
            this.readlock.unlock();
            return false;
        }
        c.lock.lock();
        this.readlock.unlock();

        try{
            return c.deposit(value);
        }finally{
            c.lock.unlock();
        }
    }

    // withdraw; fails if no such account or insufficient balance
    public boolean withdraw(int id, int value) {
        this.readlock.lock();
        Account c = map.get(id);
        if (c == null) {
            this.readlock.unlock();
            return false;
        }
        c.lock.lock();
        this.readlock.unlock();

        try{
            return c.withdraw(value);
        }finally{
            c.lock.unlock();
        }
    }

    // transfer value between accounts;
    // fails if either account does not exist or insufficient balance
    public boolean transfer(int from, int to, int value) {
        Account cfrom, cto;
        this.readlock.lock();
        cfrom = map.get(from);
        cto = map.get(to);
        if (cfrom == null || cto == null){
            this.readlock.unlock();
            return false;
        }
        try {
            if (from<to) {
                cfrom.lock.lock();
                cto.lock.lock();
            }else{
                cto.lock.lock();
                cfrom.lock.lock();
            }
            this.readlock.unlock();
            return cfrom.withdraw(value) && cto.deposit(value);
        }finally {
            cfrom.lock.unlock();
            cto.lock.unlock();
        }
    }

    // sum of balances in set of accounts; 0 if some does not exist
    public int totalBalance(int[] ids) {
        int total = 0;
        Account[] accs = new Account[ids.length];
        this.readlock.lock();
        for (int i = 0 ; i <ids.length;i++) {
            accs[i] = map.get(i);

            if (accs[i] == null){
                for (int j = 0 ; j < i;j++)
                    accs[i].lock.unlock();
                this.readlock.unlock();
                return 0;
            }
            accs[i].lock.lock();
        }
        this.readlock.unlock();
        for (int i = 0 ; i <ids.length;i++) {

            total += accs[i].balance();
            accs[i].lock.unlock();
        }
        return total;
    }

}
