import dtos.AddressSummaryDto;
import entities.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AddressesInfo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //TypedQuery<AddressSummaryDto> query = em.createQuery("SELECT a.text,a.town.name, size(a.employees) FROM Address a ORDER BY size(a.employees) desc", AddressSummaryDto.class).setMaxResults(10);

        TypedQuery<AddressSummaryDto> query = em.createQuery("SELECT a.text,a.town.name, size(a.employees) FROM Address a LEFT JOIN a.town ORDER BY size(a.employees) desc", AddressSummaryDto.class).setMaxResults(10);
        List<AddressSummaryDto> addresses = query.getResultList();
        for (AddressSummaryDto address : addresses) {
           String townName = address.getTownName() == null ? "n/a" : address.getTownName();

            System.out.printf("%s, %s - %d employees%n", address.getText(), townName, address.getEmployeesCount());
        }

    }
}
