
import Tables.Department;
import Tables.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query12 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        Department dp = (Department) em.createNamedQuery("Department.findByDname").setParameter("dname","Research").getSingleResult();
        List<Employee> allEmp= em.createNamedQuery("Employee.findAll").getResultList();
        double sum=0;
        int count =0;
        double avg;
        for(Employee e : allEmp)
        {
            
            if(e.getDno().getDnumer().equals(dp.getDnumer()))
            {
                count++;
                sum+=e.getSalary().doubleValue();

            }
        }
        avg =  sum/count;
        for(Employee e : allEmp)
        {
            if(e.getSalary().doubleValue()>avg)
            {
                System.out.println("name = "+e.getFname()+" "+e.getMinit()+" "+e.getLname()+" , Ssn = "+e.getSsn()+" , Address = "+e.getAddress()+" , Salary = "+e.getSalary());
            }
        }
    }
}
