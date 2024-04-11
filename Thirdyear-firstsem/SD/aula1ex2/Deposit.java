package aula1ex2;

public class Deposit implements Runnable{
    int value;
    Bank bank;
    int repetitions;
    public Deposit (int value,int repetitions, Bank bank){
        this.value = value;
        this.bank = bank;
        this.repetitions = repetitions;
    }
    public void run(){
        for (int i = 0; i<repetitions ; i++)
            bank.deposit(this.value);
    }
}
