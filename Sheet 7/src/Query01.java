
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
        EntityManager em=Persistence.createEntityManagerFactory("FullProPU").createEntityManager();
        em.getTransaction().begin();
        System.out.println("\n1.Retrieve names of employees who live in Houston.\n\n\t-------------------------");
        System.out.println("\t  Names of all employees");
        List<Employee> allEmp= em.createNamedQuery("Employee.findAll").getResultList();
        for(Employee e : allEmp)
        {
            if(e.getAddress().contains("Houston"))
            {
                System.out.println("\t-------------------------\n\t\t"+e.getFname());
            }
        }
        System.out.println("\t-------------------------\n");
    }
    
}
