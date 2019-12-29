package solid.dependencyInversion;
import java.util.ArrayList;

interface IWorker{
    /* Follow Open Closed Principle here. Open for extension, closed for modification.
       We can add any number of worker, and don't need rewrite Manager class.
     */
    void work();
    String toString();
    int getWage();
}

class Manager{
    private ArrayList<IWorker> workers;
    public Manager(){
        workers = new ArrayList<IWorker>();
    }

    public void setWorker(IWorker worker){
        workers.add(worker);
    }

    public void removeWorker(IWorker worker){
        if(workers.contains(worker)){
            workers.remove(worker);
            System.out.print("You fire " + worker + ". You still have: ");
            for (IWorker otherWorker : workers) {
                System.out.print(otherWorker + " ");
            }
        }else{
            System.out.println();
            System.out.println("You can not fire " + worker + ". This worker is not working for you yet.");
        }
    }

    public void manage(){
        for(IWorker worker: workers){
            worker.work();
            System.out.println(" is working for you!");
        }
    }

    public void payWage(IWorker worker){
        System.out.println(worker.getWage());
    }
}

class Worker implements IWorker{
    private String workerName;
    private int wage = 15;
    public Worker(String name){
        workerName = name;
    }

    public String toString(){
        return workerName;
    }

    public void work(){
        System.out.print(workerName);
    }

    public int getWage(){return wage;}
}

class SuperWorker implements IWorker {
    private String workerName;
    private int wage = 20;

    public SuperWorker(String name) {
        workerName = name;
    }

    public String toString(){
        return workerName;
    }

    public void work() {
        System.out.print(workerName);
    }

    public int getWage(){return wage;}
}

public class DependencyInversion {
    public static void main(String[] args) {
        Manager Angel = new Manager();
        IWorker Darren = new Worker("Darren");
        IWorker SuperDareen = new SuperWorker("SuperDarren");
        System.out.println(Darren.getClass());
        System.out.println(SuperDareen.getClass());
        Angel.setWorker(Darren);
        Angel.setWorker(SuperDareen);
        Angel.manage();
        Angel.removeWorker(Darren);
        Worker BadDarren = new Worker("BadDarren");
        Angel.removeWorker(BadDarren);
        Angel.payWage(SuperDareen);
    }
}