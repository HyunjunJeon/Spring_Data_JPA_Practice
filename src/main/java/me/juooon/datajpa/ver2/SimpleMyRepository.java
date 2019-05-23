package me.juooon.datajpa.ver2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean // 중간에 사용되는 Repository는 꼭 붙어줘야함
public interface SimpleMyRepository<T, ID> extends JpaRepository<T, ID> {

    boolean contains(T entity);

}
