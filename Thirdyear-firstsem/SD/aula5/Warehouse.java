package aula5;


import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Warehouse {
    private Map<String, Product> map =  new HashMap<String, Product>();
    private ReentrantLock lock = new ReentrantLock();


    private class Product {
        int quantity = 0;
        private Condition cond = lock.newCondition();
    }

    private Product get(String item) {
        Product p = map.get(item);
        if (p != null) return p;
        p = new Product();
        map.put(item, p);
        return p;
    }

    /**
    public void supply(String item, int quantity) {
        this.lock.lock();
        Product p = get(item);
        p.lock.lock();
        this.lock.unlock();
        p.quantity += quantity;
        p.cond.signalAll();
        p.lock.unlock();
    }

    // Errado se faltar algum produto...
    public void consume(Set<String> items) throws InterruptedException {
        this.lock.lock();
        for (String s : items){
            Product prod = get(s);
            prod.lock.lock();
            }
        //ja existem todos os items e estes estão bloqueados
        this.lock.unlock();
        for (String s : items){
            Product prod = get(s);
            while (prod.quantity == 0){//quantidade do artigo é 0
                prod.cond.await();
            }
            get(s).quantity--;
            prod.lock.unlock();
        }
    }
    */
    public void supply(String item, int quantity) {
        this.lock.lock();
        Product p = get(item);
        //p.lock.lock();
        p.quantity += quantity;
        p.cond.signalAll();
        this.lock.unlock();
        //p.lock.unlock();
    }

    // Errado se faltar algum produto...
    public void consume(Set<String> items) throws InterruptedException {
        this.lock.lock();
        List<String> itemss = new ArrayList(items);
        int i = 0;
        while (i < itemss.size()) {
            Product it = this.get(itemss.get(i));
            i++;
            while (it.quantity == 0){
                it.cond.await();
                i = 0;
            }
        }
        for (String item : items)
            get(item).quantity--;

        this.lock.unlock();
    }

}
