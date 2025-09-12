import entities.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.Scanner;

public class AddNewAddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        Address address = new Address();
        address.setText("Vitoshka 15");
        em.getTransaction().begin();
        int affectedEmployees = 0;

        try {
            em.persist(address);
            Query query = em.createQuery("UPDATE Employee e SET e.address = :address WHERE e.lastName = :lastName")
                    .setParameter("address", address)
                    .setParameter("lastName", lastName);

            affectedEmployees = query.executeUpdate();
            em.getTransaction().commit();


        } catch (Exception e) {
            em.getTransaction().rollback();
        }

        System.out.printf("%d employees updated.%n", affectedEmployees);



    }
}
