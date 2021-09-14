package com.jpacrud;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.mappers.ModelMapper;

import javax.persistence.EntityManager;

@SpringBootApplication
@EnableJpaAuditing
public class JpaCrudApplication {





    public static void main(String[] args) {
        SpringApplication.run(JpaCrudApplication.class, args);
    }






}
