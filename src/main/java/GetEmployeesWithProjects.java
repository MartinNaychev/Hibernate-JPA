import entities.Employee;
import entities.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.Comparator;
import java.util.Scanner;

public class GetEmployeesWithProjects {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeeId = Integer.parseInt(scanner.nextLine());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();


        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee AS e WHERE e.id = :id", Employee.class)
                .setParameter("id", employeeId);
        Employee employee = query.getSingleResult();

        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
        for (Project project : employee.getProjects().stream().sorted(Comparator.comparing(Project::getName)).toArray(Project[]::new)) {
            System.out.printf(" %s%n", project.getName());

        }
    }
}
