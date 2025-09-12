import entities.Address;
import entities.Town;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Scanner;

public class RemoveTowns {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String townName = scanner.nextLine();


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Town> townQuery = em.createQuery("SELECT t FROM Town t WHERE t.name = :townName", Town.class).setParameter("townName", townName);
        Town town = townQuery.getSingleResult();


        TypedQuery<Address> addressQuery = em.createQuery("SELECT a FROM Address a WHERE a.town = :townName", Address.class).setParameter("townName", town);

        List<Address> addresses = addressQuery.getResultList();

        em.getTransaction().begin();

        try {
            for (Address address : addresses) {
                em.remove(address);
            }

            em.remove(town);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

        }
    }
}
