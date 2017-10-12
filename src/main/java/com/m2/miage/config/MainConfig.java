package com.m2.miage.config;

import com.m2.miage.empruntReservationService.entity.Emprunt;
import com.m2.miage.empruntReservationService.entity.Reservation;
import com.m2.miage.exemplaireOeuvreService.entity.Exemplaire;
import com.m2.miage.exemplaireOeuvreService.entity.Oeuvre;
import com.m2.miage.usagerService.entity.Usager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class MainConfig {

  @Bean
  public RepositoryRestConfigurer repositoryRestConfigurer() {
    return new RepositoryRestConfigurerAdapter() {
      @Override
      public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Emprunt.class, Reservation.class, Usager.class, Exemplaire.class,
            Oeuvre.class);
      }
    };
  }
}
