package solid.facade;

import java.util.ArrayList;

/* A facade class for manager. Manager has several responsibility:
    1. assign work to worker
    2. pay wage to worker according to how many work this worker has done
 */
public class ManagerFacade {
    private AssignWork assignWork;
    private PayWage payWage;
    public ManagerFacade(AssignWork assignWork, PayWage payWage){}

    public void assign(worker w, String work){
        assignWork.assign(w, work);
    }

    public void pay(worker w){
        payWage.pay(w);
    }

}
