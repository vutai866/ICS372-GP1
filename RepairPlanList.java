import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepairPlanList implements Iterable<RepairPlan>{
    private List<RepairPlan> RepairPlans = new ArrayList<>();

    public boolean insertRepairPlan(RepairPlan RepairPlan){
        RepairPlans.add(RepairPlan);
        return true;
    }

    public List<RepairPlan> getRepairPlans() {
        return RepairPlans;
    }

    @Override
    public Iterator<RepairPlan> iterator() {
        // TODO Auto-generated method stub
        return RepairPlans.iterator();
    }
} // end RepairPlanList
