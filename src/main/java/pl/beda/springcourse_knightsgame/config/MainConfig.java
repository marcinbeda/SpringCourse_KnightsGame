package pl.beda.springcourse_knightsgame.config;

import org.springframework.context.annotation.*;
import pl.beda.springcourse_knightsgame.domain.repository.DBKnightRepository;
import pl.beda.springcourse_knightsgame.domain.repository.InMemoryRepository;
import pl.beda.springcourse_knightsgame.domain.repository.KnightRepository;

@Configuration
public class MainConfig {

    @Bean(name = "inMemoryKnighRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepo() {
        KnightRepository repo = new InMemoryRepository();
        return repo;
    }

    @Bean(name = "DBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBRepo() {
        KnightRepository repo = new DBKnightRepository();
        return repo;
    }
}
