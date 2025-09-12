import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class WellPaiedEmployees {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        TypedQuery<String> query = em.createQuery("SELECT e.firstName FROM Employee AS e WHERE e.salary > 50000", String.class);
        List<String> resultList = query.getResultList();

        for (String employeeName : resultList) {
            System.out.printf("%s%n", employeeName);
        }
    }
}
