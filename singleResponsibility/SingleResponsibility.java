package solid.singleResponsibility;

public class SingleResponsibility {
    public static void main(String[] args) {
        EmployeeData data = new EmployeeData();
        data.addWorkHour(8);
        data.setHourWage(28.5);
        EmployeeFacade employeeFacade = new EmployeeFacade();
        System.out.println(employeeFacade.payCalculator(data));
        System.out.println(employeeFacade.reportHour(data));
    }
}

class EmployeeData{
    private double hourWage;
    private int workHour = 0;

    public int getWorkHour(){return workHour;}

    public void addWorkHour(int time){workHour += time;}

    public double getHourWage(){return hourWage;}

    public void setHourWage(double newWage){hourWage = newWage;}

    public String toString(){
        return String.valueOf(workHour);
    }

}

class PayCalculator{

    public double payCalculator(EmployeeData data){
        return data.getWorkHour() * data.getHourWage();
    }
}

class HumanReporter{
    public String reportHour(EmployeeData data){
        return "Today, you have worked " + data + " hours.";
    }
}

class EmployeeFacade{
    private HumanReporter report = new HumanReporter();
    private PayCalculator calculator = new PayCalculator();
    public double payCalculator(EmployeeData data){
        return calculator.payCalculator(data);
    }

    public String reportHour(EmployeeData data){
        return report.reportHour(data);
    }

}