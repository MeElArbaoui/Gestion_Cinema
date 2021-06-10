package com.example.cinema;

import com.example.cinema.entities.Film;
import com.example.cinema.entities.Salle;
import com.example.cinema.entities.Ticket;
import com.example.cinema.services.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {

    @Autowired
    private ICinemaInitService initService;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Film.class, Salle.class, Ticket.class);
        initService.initVilles();
        initService.initCinemas();
        initService.initSalles();
        initService.initPlaces();
        initService.initSeances();
        initService.initCategories();
        initService.initFilms();
        initService.initProjections();
        initService.initTickets();

        System.err.println("Executed!");

    }
}
