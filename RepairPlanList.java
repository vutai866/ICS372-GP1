import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepairPlanList implements Iterable<RepairPlan>{
    private List<RepairPlan> repairPlans = new ArrayList<>();

    public boolean insertRepairPlan(RepairPlan RepairPlan){
        repairPlans.add(RepairPlan);
        return true;
    }
    
    public RepairPlan searchRepairPlan(int repairPlanID){
		Iterator<RepairPlan> repairPlanIterator = repairPlans.iterator();
		while(repairPlanIterator.hasNext()) {
			RepairPlan targetRepairPlan  = repairPlanIterator.next();
			if(targetRepairPlan.getPlanID() == repairPlanID) {
				return targetRepairPlan;
			}
		}
		return null;
	}

    public List<RepairPlan> getRepairPlans() {
        return repairPlans;
    }

    @Override
    public Iterator<RepairPlan> iterator() {
        // TODO Auto-generated method stub
        return repairPlans.iterator();
    }
} // end RepairPlanList
