package solid.facade;

public class BuildFacade {
    private worker worker;
    private AssignWork assignWork;
    private  PayWage payWage;

    public void buildWorker(worker w){
        worker = w;
    }

    public void buildAssignWork(String work){
        assignWork.assign(worker, work);
    }

}
