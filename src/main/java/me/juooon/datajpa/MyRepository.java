package me.juooon.datajpa;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

// 공통 인터페이스 정의
@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends Repository<T, ID> {
    <E extends T> E save(E entity);

    List<T> findAll();

    long count();

    <E extends T> Optional<E> findById(ID id); // 리턴되는 값이 Null 이더라도...
}
