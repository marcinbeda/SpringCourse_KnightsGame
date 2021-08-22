package pl.beda.springcourse_knightsgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.beda.springcourse_knightsgame.domain.PlayerInformation;
import pl.beda.springcourse_knightsgame.domain.repository.KnightRepository;
import pl.beda.springcourse_knightsgame.domain.repository.PlayerInformationRepository;
import pl.beda.springcourse_knightsgame.domain.repository.QuestRepository;
import pl.beda.springcourse_knightsgame.services.QuestService;
import pl.beda.springcourse_knightsgame.utils.Role;
import pl.beda.springcourse_knightsgame.utils.RoleRepository;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        knightRepository.createKnight("Percival", 32);

        PlayerInformation playerInformation1 = new PlayerInformation("user1", "{noop}user1");
        playerInformationRepository.createPlayerInfromation(playerInformation1);
        PlayerInformation playerInformation2 = new PlayerInformation("user2", "{noop}user2");
        playerInformationRepository.createPlayerInfromation(playerInformation2);

        Role user1RoleUSER = new Role("user1", "USER");
        Role user2RoleUSER = new Role("user2", "USER");
        Role user2RoleADMIN = new Role("user2", "ADMIN");

        roleRepository.persistRole(user1RoleUSER);
        roleRepository.persistRole(user2RoleUSER);
        roleRepository.persistRole(user2RoleADMIN);

        questService.assignRandomQuest("Percival");

        System.out.println(roleRepository.getAll());
    }
}
