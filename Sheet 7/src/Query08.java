
import Tables.Employee;
import Tables.WorksOn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query08 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        List<Employee> emp=em.createNamedQuery("Employee.findAll").getResultList();
        for(Employee e:emp)
        {
            if(e.getDno().getDnumer()==5)
            {
                for(WorksOn w:e.getWorksOnCollection())
                    if(w.getHours()>20&&w.getProject().getPname().equals("ProductX"))
                        System.out.println(e.getFname()+" "+w.getHours()+" "+w.getProject().getPname());
            }
        }
    }
    
}
