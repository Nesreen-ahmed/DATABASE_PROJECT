
import Tables.Department;
import Tables.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query11 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        List<Department> dept=em.createNamedQuery("Department.findAll").getResultList();
        for(Department d:dept)
        {
            int num=d.getDnumer();
            double tsalary=0;
            int n=0;
            for(Employee e:d.getEmployeeCollection())
            {
                if(e.getDno().getDnumer()==num)
                {
                    n++;
                    tsalary+=e.getSalary().doubleValue();
                }
            }
            System.out.println(d.getDname()+" "+(tsalary/n));
        }
    }
    
}
