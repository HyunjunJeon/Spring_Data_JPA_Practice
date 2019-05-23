package me.juooon.datajpa;

import me.juooon.datajpa.ver2.SimpleMyRepository;
import me.juooon.datajpa.ver2.SimpleMyRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// Spring Data JPA - Common Query 생성 전략(CREATE / USE_DECLARED_QUERY / CREATE_IF_NOT_FOUND)
// @EnableJpaRepositories(queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
@EnableJpaRepositories(repositoryBaseClass = SimpleMyRepositoryImpl.class) // 기본 레포지토리 커스터마이징
public class DatajpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatajpaApplication.class, args);
    }
}
