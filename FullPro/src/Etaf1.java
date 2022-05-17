
import Tables.Department;
import Tables.Dependent;
import Tables.Employee;
import Tables.Project;
import Tables.WorksOn;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tuhamy
 */
public class Etaf1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("FullProPU").createEntityManager();
        em.getTransaction().begin();
        
        Department dp = (Department) em.createNamedQuery("Department.findByDname").setParameter("dname","Research").getSingleResult();
        List<Employee> allEmp= em.createNamedQuery("Employee.findAll").getResultList();
        
        double sum=0;
        int count =0;
        double avg;
        
        System.out.println("\n12.Retrieve the details of each employee who takes salary greater than the average salaries of the research department's employees.\n");
        System.out.println("\t_______________________________________________________________________________________________________________");
        System.out.format("\t%20s%5s%10s%8s%20s%20s%15s\n","NameOfEmpolyee","|","Ssn","|","Adress","|","Salary");
        System.out.println("\t________________________|_________________|_______________________________________|____________________________");
        for(Employee e : allEmp)
        {
            
            if(e.getDno().getDno().equals(dp.getDno()))
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
                System.out.format("\t%20s%5s%13s%5s%25s%15s%15s\n",e.getFname()+"."+e.getMinit()+"."+e.getLname(),"|",e.getSsn(),"|",e.getAddress(),"|",e.getSalary());
            }
        }
         System.out.println("\t______________________________________________________________________________________________________________");
    }
}
