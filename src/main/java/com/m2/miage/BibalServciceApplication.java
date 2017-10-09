package com.m2.miage;

import com.m2.miage.usagerService.entity.Usager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;


@SpringBootApplication
public class BibalServciceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibalServciceApplication.class, args);
    }

    @Configuration
    public class RepositoryConfig extends RepositoryRestMvcConfiguration {
        @Override
        public RepositoryRestConfiguration config() {
            config().exposeIdsFor(Usager.class);
            return super.config();
        }
    }
}
