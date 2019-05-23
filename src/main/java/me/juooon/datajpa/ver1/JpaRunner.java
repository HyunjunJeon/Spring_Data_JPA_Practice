package me.juooon.datajpa.ver1;

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
//        Account account = new Account();
//        account.setUsername("jhj"); account.setPassword("jpa_lec");
//
//
//        Study study = new Study();
//        study.setName("Data JPA");
//        //study.setOwner(account);
//
//        account.getStudies().add(study);
//        study.setOwner(account); // 양방향 관계이기 때문에 반드시 해줘야함!!
//
//        // 영속화 시키는 같은 코드 ~ Session을 얻어서 직접하느냐, 구현된 메서드로 쉽게 하느냐
//        //Session session = entityManager.unwrap(Session.class);
//        //session.save(account);
//
//        entityManager.persist(account);

        Post post = new Post();
        post.setTitle("Spring Data JPA....");

        Comment comment1 = new Comment();
        comment1.setComment("Spring Mastter11111");
        post.addComment(comment1);

        Comment comment2 = new Comment();
        comment2.setComment("Spring Mastter22222");
        post.addComment(comment2);

        Session session = entityManager.unwrap(Session.class);
        session.save(post);
    }
}
