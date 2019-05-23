package me.juooon.datajpa;

// 내가 만든 공통 레포지토리 인터페이스를 상속받음
public interface CommentRepository extends MyRepository<Comment, Long> {
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
