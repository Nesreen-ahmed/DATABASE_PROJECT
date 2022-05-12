
import Tables.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Dell
 */
public class Query01
{
    public static void main(String[] args) 
    {
        EntityManager em = Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        System.out.println("Names of all employees");
        List<Employee> allEmp= em.createNamedQuery("Employee.findAll").getResultList();
        for(Employee e : allEmp)
        {
            if(e.getAddress().contains("Houston"))
                System.out.println(e.getFname());
        }
    }
    
}
