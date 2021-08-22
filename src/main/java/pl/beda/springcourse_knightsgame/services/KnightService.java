package pl.beda.springcourse_knightsgame.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.beda.springcourse_knightsgame.domain.Knight;
import pl.beda.springcourse_knightsgame.domain.PlayerInformation;
import pl.beda.springcourse_knightsgame.domain.repository.KnightRepository;
import pl.beda.springcourse_knightsgame.domain.repository.PlayerInformationRepository;
import pl.beda.springcourse_knightsgame.domain.repository.QuestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    PlayerInformationRepository playerInformation;

    public List<Knight> getAllKnights() {
        return new ArrayList<>(knightRepository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        knightRepository.createKnight(knight);
    }

    public Knight getKnight(Integer id) {
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() {

        Predicate<Knight> knightPredicate = knight -> {
            if (knight.getQuest() != null) {
                return knight.getQuest().isCompleted();
            } else {
                return false;
            }
        };

        int sum = knightRepository.getAllKnights().stream().filter(knightPredicate)
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();

        knightRepository.getAllKnights().stream().filter(knightPredicate).forEach(knight -> {
            knight.setQuest(null);
        });

        return sum;
    }

    @Transactional
    public void getMyGold() {

        List<Knight> allKnights = getAllKnights();
        allKnights.forEach(knight -> {
                    if (knight.getQuest() != null) {
                        boolean completed = knight.getQuest().isCompleted();

                        if (completed) {
                            questRepository.update(knight.getQuest());
                        }
                    }
                }
        );
        PlayerInformation first = playerInformation.getFirst();
        int currentGold = first.getGold();
        first.setGold(currentGold + collectRewards());
    }
}
