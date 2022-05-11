import Tables.Project;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        List<Project> emp=em.createNamedQuery("Project.findAll").getResultList();
        for(Project e:emp)
        {
            System.out.println(e.getPname());
        }
    }
    
}
