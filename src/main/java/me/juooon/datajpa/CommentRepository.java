package me.juooon.datajpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// 내가 만든 공통 레포지토리 인터페이스를 상속받음
public interface CommentRepository extends MyRepository<Comment, Long> {
    //@Query(value = "SELECT c FROM Comment AS c", nativeQuery = false) // 2. 미리 정의해둔 쿼리 찾아 사용하기(USE_DECLARED_QUERY)
    List<Comment> findByCommentContains(String comment); // 1. 메서드 이름을 분석해서 쿼리 만들기(CREATE)
    // 3. 미리 정의한 쿼리 찾아보고 없으면 만들기(CREATE_IF_NOT_FOUND) => default, 생성전략은 @EnableJpaRepositories 에 속성으로 변경가능

    // Paging 할때는 Pageable을 보내줘야하며, Sort만 필요로할때는 Sort 객체만 보내주면되며, List로 리턴 받아야겠지? Pageable이 Sort를 포함하고있으니까
    // OrderByCreatedDesc는 Pageable때문에 필요하지 않긴해 지금은.. 그냥 메서드 이름으로 어케 만드는지 확인용
    Page<Comment> findByLikeCountGreaterThanAndPostOrderByCreatedDesc(int likeCount, Post post, Pageable pageable);
}

/*
// Repository 인터페이스로 공개할 메서드를 직접 일일히 정의하고 싶다면....
// 특정 리포지토리
@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository {
    Comment save(Comment comment);
    List<Comment> findAll();
}
 */
