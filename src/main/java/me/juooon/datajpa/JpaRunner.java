package me.juooon.datajpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("jhj"); account.setPassword("jpa_lec");

        // 영속화 시키는 같은 코드 ~ Session을 얻어서 직접하느냐, 구현된 메서드로 쉽게 하느냐
        Session session = entityManager.unwrap(Session.class);
        //session.save(account);

        //entityManager.persist(account);
    }
}
