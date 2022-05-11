import Tables.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        List<Employee> emp=em.createNamedQuery("Employee.findAll").getResultList();
        for(Employee e:emp)
        {
            System.out.println(e.getFname()+" "+e.getLname());
        }
    }
    
}
