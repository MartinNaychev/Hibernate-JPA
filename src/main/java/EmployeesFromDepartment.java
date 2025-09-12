import dtos.EmployeeSummaryDto;
import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class EmployeesFromDepartment {
    private static final String DEPARTMENT_NAME = "Research and Development";
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();


        List<EmployeeSummaryDto> resultList = em.createQuery("SELECT e.firstName, e.lastName, e.department.name, e.salary FROM Employee e WHERE e.department.name = :dn ORDER BY e.salary, e.id", EmployeeSummaryDto.class).setParameter("dn", DEPARTMENT_NAME).getResultList();

        for (EmployeeSummaryDto employee : resultList) {
            System.out.printf("%s %s from %s - $%.2f%n", employee.getFirstName(), employee.getLastName(), employee.getDepartmentName(), employee.getSalary());
        }
    }
}
