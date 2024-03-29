package me.juooon.datajpa.ver1;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// 현재 Spring Data JPA는... 가장 진보한 형태인 Interface의 Interface를 상속받아서 구현함
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByTitleContains(String title, Pageable pageable);

    long countByTitleContains(String title);
}
/*
 구버전
@Repository
@Transactional
public class PostRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Post add(Post post){
        entityManager.persist(post);
        return post;
    }

    public void delete(Post post){
        entityManager.remove(post);
    }

    public List<Post> findAll(){
        return entityManager.createQuery("SELECT p FROM post AS p", Post.class)
                .getResultList();
    }

}*/