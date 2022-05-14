
import Tables.Department;
import Tables.Employee;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query07 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        
        List<Department> allDep = em.createNamedQuery("Department.findAll").getResultList();
        List<Employee> Emps = em.createNamedQuery("Employee.findAll").getResultList();
    
        System.out.println("\n7.List the summation of salaries for each department that are paid to their employees.\n\n\t--------------------\t----------------------");
        System.out.println("\t Department Name\tsummation of salaries");
        for(Department d : allDep)
        {
            double count=0;
            System.out.println("\t--------------------\t----------------------");
            for(Employee e : Emps)
            {
                if(Objects.equals(e.getDno().getDnumer(), d.getDnumer()))
                    count+=e.getSalary().doubleValue();
            }
            System.out.println("\t "+d.getDname()+"\t\t\t"+count);
        }
    }
    
}
