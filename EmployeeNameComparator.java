package Task3;
import java.util.Comparator;


public class EmployeeNameComparator implements Comparator<Employee> {
    
    private SortType sortType;

    public EmployeeNameComparator(SortType sortType){
        this.sortType = sortType;
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return  sortType == SortType.Ascending ? o1.getName().compareTo(o2.getName()) :
                o2.getName().compareTo(o1.getName());
    }
}
