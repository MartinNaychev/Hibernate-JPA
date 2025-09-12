import entities.Town;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Town> resultList = em.createQuery("SELECT t FROM Town as t", Town.class).getResultList();

        for (Town town : resultList) {
            if (town.getName().length() > 5) {
                em.detach(town);
            }else {
                town.setName(town.getName().toUpperCase());
            }
        }

        em.getTransaction().commit();
        em.close();

    }
}
