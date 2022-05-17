
import Tables.Dependent;
import Tables.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query09 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        
        List<Employee> Emps = em.createNamedQuery("Employee.findAll").getResultList();
        List<Dependent> Dep = em.createNamedQuery("Dependent.findAll").getResultList();
        System.out.println("\n9.List the name of each employee and his/her spouse.\n");
        System.out.println("\t____________________________________________");
        System.out.format("\t%18s%5s%15s\n","Employee Name ","|","Spouse Name");
        System.out.println("\t______________________|_____________________");
        for(Dependent d: Dep)
        {
            if(d.getRelationship().equalsIgnoreCase("Spouse"))
            {
                System.out.format("\t%14s%9s%15s\n", d.getEmployee().getFname() ,"|",d.getDependentPK().getDependentname());
            }
        }
        System.out.println("\t____________________________________________\n");
    }
    
}
