package pl.beda.springcourse_knightsgame.domain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KnightTest {

    @Test
    public void testIfQuestMarkedAsStarted() {

        Knight knight = new Knight("Percival", 25);
        Quest quest = new Quest(1, "Testowe zdanie");

        knight.setQuest(quest);

        assertTrue(knight.getQuest().isStarted());
    }
}
