
import Tables.Department;
import Tables.Employee;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query04 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        
        List<Department> allDep = em.createNamedQuery("Department.findAll").getResultList();
        List<Employee> Emps = em.createNamedQuery("Employee.findAll").getResultList();
    
        System.out.println("\n4.List the count of employees for each department.\n\n\t--------------------\t--------------------");
        System.out.println("\t Department Name "+"\t"+"Count of employees ");
        for(Department d : allDep)
        {
            int count=0;
            System.out.println("\t--------------------\t--------------------");
            for(Employee e : Emps)
            {
                if(Objects.equals(e.getDno().getDnumer(), d.getDnumer()))
                    count++;
            }
            System.out.println("\t "+d.getDname()+"\t\t\t"+count);
        }
    }
    
}
