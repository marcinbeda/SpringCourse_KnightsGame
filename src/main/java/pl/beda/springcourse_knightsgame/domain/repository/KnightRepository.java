package pl.beda.springcourse_knightsgame.domain.repository;

import pl.beda.springcourse_knightsgame.domain.Knight;

import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {

    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void deleteKnight(Integer id);

    void build();

    void createKnight(Knight knight);

    Knight getKnightById(Integer id);

    default void updateKnight(int id, Knight knight) {
    }
}
