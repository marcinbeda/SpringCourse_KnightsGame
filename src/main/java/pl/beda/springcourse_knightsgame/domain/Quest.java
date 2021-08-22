package pl.beda.springcourse_knightsgame.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;

    private int reward = 100;

    protected int lenghtInSeconds = 10;

    private boolean started = false;

    private boolean completed = false;

    protected LocalDateTime startDate;

    public Quest() {
    }

    public Quest(String description) {
        this.description = description;
    }

    public Quest(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {

        if (started) {
            this.startDate = LocalDateTime.now();
        }

        this.started = started;
    }

    public boolean isCompleted() {

        if (this.completed) {
            return this.completed;
        } else {
            LocalDateTime now = LocalDateTime.now();

            LocalDateTime questEndDate = this.startDate.plusSeconds(this.lenghtInSeconds);

            boolean isAfter = now.isAfter(questEndDate);

            if (isAfter) {
                this.completed = true;
            }
            return isAfter;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", reward=" + reward +
                ", lenghtInSeconds=" + lenghtInSeconds +
                ", started=" + started +
                ", completed=" + completed +
                ", startDate=" + startDate +
                '}';
    }
}
