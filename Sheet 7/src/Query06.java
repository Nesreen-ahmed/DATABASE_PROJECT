
import Tables.Project;
import Tables.WorksOn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query06 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        //System.out.println("Names of all employees");
        Project proj=(Project) em.createNamedQuery("Project.findByPname").setParameter("pname", "Computerization").getSingleResult();
        List<WorksOn> worker=em.createNamedQuery("WorksOn.findByPno").setParameter("pno",proj.getPnumber()).getResultList();
        
        System.out.println("\n6.For the project “Computerization”, retrieve the name of employee who works on it and his/her salary greater than 3000.\n");
        System.out.format("%25s,%18s,%20s\n","--------------------","--------------------","--------------------");
        System.out.format("%22s,%15s,%20s\n","Name of employee","Ssn","Salary");
        for(WorksOn w : worker)
        {
            if(w.getEmployee().getSalary().doubleValue()>3000)
            {
                 System.out.format("%25s,%16s,%20s\n","--------------------","--------------------","--------------------");
                 System.out.format("%20s,%20s,%20s\n", w.getEmployee().getFname(),w.getEmployee().getSsn(),w.getEmployee().getSalary());
            }
        }
         System.out.format("%25s,%16s,%20s\n","--------------------","--------------------","--------------------\n");
    }
    
}
