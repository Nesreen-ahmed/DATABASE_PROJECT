import Tables.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query02 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        List<Employee> emp=em.createNamedQuery("Employee.findAll").getResultList();
        for(Employee e:emp)
        {
            if(e.getSuperssn()==null)
            System.out.println(e.getFname()+" "+e.getSalary());
        }
    }
    
}
