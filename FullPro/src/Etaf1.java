
import Tables.Department;
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
                if(Objects.equals(e.getDno().getDno(), d.getDno()))
                    count++;
            }
            System.out.println("\t "+d.getDname()+"\t\t\t"+count);
        }
    }
    
}
