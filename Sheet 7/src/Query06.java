
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
        for(WorksOn w : worker)
        {
            if(w.getEmployee().getSalary().doubleValue()>3000)
            System.out.println("name = "+w.getEmployee().getFname()+
                                " , Ssn =  "+w.getEmployee().getSsn()+
                                 "  , Salary = "+w.getEmployee().getSalary());
        }
        
    }
    
}
