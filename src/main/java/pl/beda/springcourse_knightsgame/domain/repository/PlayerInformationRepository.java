package pl.beda.springcourse_knightsgame.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.beda.springcourse_knightsgame.domain.PlayerInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PlayerInformationRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createPlayerInfromation(PlayerInformation playerInformation) {
        em.persist(playerInformation);
    }

    public PlayerInformation getFirst() {
        return em.createQuery("from PlayerInformation", PlayerInformation.class).getResultList().get(0);
    }
}
