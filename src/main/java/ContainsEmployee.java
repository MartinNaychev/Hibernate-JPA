import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Scanner;

public class ContainsEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split("\\s+");

        String firstName = array[0];
        String lastName = array[1];

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
       // em.getTransaction().begin();
   /*     TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee AS e WHERE e.firstName = :firstName and e.lastName = :lastName", Employee.class)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName);

        List<Employee> resultList = query.getResultList();

        if (resultList.isEmpty()) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }*/

        TypedQuery<Long> query = em.createQuery("SELECT count(e) FROM Employee AS e WHERE e.firstName = :firstName and e.lastName = :lastName", Long.class)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName);

        Long count = query.getSingleResult();

        if (count == 0) {
            System.out.println("No");
        }else  {
            System.out.println("Yes");
        }

    }
}
