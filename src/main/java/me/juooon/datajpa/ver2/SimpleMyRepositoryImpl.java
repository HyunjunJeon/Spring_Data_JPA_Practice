package me.juooon.datajpa.ver2;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class SimpleMyRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements SimpleMyRepository<T, ID> {

    private EntityManager entityManager; // Bean이 아니라 전달받는 EntityManager

    public SimpleMyRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public boolean contains(T entity) {
        return entityManager.contains(entity);
    }
}
