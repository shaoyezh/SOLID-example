package solid.facade;

import java.util.ArrayList;

public class worker {
    private int wage = 20;
    private ArrayList<String> work = new ArrayList<String>();
    public void doWork(String w){
        work.add(w);
    }

    public int countWage(){
        return wage * work.size();
    }
}
