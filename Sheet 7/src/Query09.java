
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import Tables.Dependent;
import Tables.Employee;
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tuhamy
 */
public class Query09 {

    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em = Persistence.createEntityManagerFactory("TryProject").createEntityManager();
        em.getTransaction().begin();

        List<Employee> Emps = em.createNamedQuery("Employee.findAll").getResultList();
        List<Dependent> Dep = em.createNamedQuery("Dependent.findAll").getResultList();

        System.out.println("\n9.List the name of each employee and his/her spouse.\n");
        System.out.format("\t%5s ,\t%5s\n","------------------------","----------------------");
        System.out.format("\t%18s,\t%25s\n","Employee Name", "Spouse Name");

        for (Employee e : Emps) 
        {
            System.out.format("\t%5s,\t%5s\n","------------------------","----------------------");
            System.out.format("\t%5s",e.getFname() + "." + e.getMinit() + "." + e.getLname());

            Collection<Dependent> depen = e.getDependentCollection();
            if (depen.size() == 0) {
                System.out.format("%30s\n","No spouse");
            } 
            else 
            {
                for (Dependent dp : depen) 
                {
                    if (dp.getRelationship().equalsIgnoreCase("spouse")) 
                    {
                        System.out.format("%30s\n",dp.getDependentPK().getDependentname());
                    }
                }
            }
        }
        System.out.format("\t%5s,\t%5s\n","------------------------","----------------------\n");
    }
}
