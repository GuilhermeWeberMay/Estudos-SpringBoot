package br.edu.ifsc.fln.vendas;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource; // Se der erro, tente jakarta.annotation.PostConstruct e javax.sql

import jakarta.annotation.PostConstruct;

@Configuration
public class FlywayConfig {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void migrate() {
        System.out.println(">>>>>>>>>>> FORÇANDO INÍCIO DO FLYWAY <<<<<<<<<<<");

        Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .load()
                .migrate();

        System.out.println(">>>>>>>>>>> FLYWAY FINALIZADO <<<<<<<<<<<");
    }
}