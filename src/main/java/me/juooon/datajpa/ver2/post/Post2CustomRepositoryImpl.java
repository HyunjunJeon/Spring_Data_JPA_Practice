package me.juooon.datajpa.ver2.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class Post2CustomRepositoryImpl implements Post2CustomRepository { // Naming Convention이 있으니까 조심해서 사용할 것

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Post2> findMyPost2() {
        return entityManager.createQuery("SELECT p FROM Post2 AS p").getResultList();
    }
}
