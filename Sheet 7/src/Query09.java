
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
        System.out.println("\n9.List the name of each employee and his/her spouse.\n\n\t--------------------\t----------------------");
        System.out.println("\t  Employee Name \t\tSpouse Name");
        
        for(Dependent d: Dep)
        {
            if(d.getRelationship().equalsIgnoreCase("Spouse"))
            {
                System.out.println("\t--------------------\t----------------------");
                System.out.println("\t  "+ d.getEmployee().getFname() +"\t\t\t"+d.getDependentPK().getDependentname());
            }
        }
    }
    
}
