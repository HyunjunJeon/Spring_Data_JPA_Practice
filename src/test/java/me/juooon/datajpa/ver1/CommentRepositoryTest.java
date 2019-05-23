package me.juooon.datajpa.ver1;

import me.juooon.datajpa.ver1.Comment;
import me.juooon.datajpa.ver1.CommentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() {
        // Given
        Comment comment = new Comment();
        comment.setComment("Jpa love hibernates");

        // When
        Comment savedComment = commentRepository.save(comment);

        // Then
        assertThat(savedComment.getId()).isEqualTo(1L);
        assertThat(savedComment.getComment()).isEqualTo("Jpa love hibernates");

        // When
        long count = commentRepository.count();

        // Then
        assertThat(count).isEqualTo(1);

        // When
        Optional<Comment> byId = commentRepository.findById(100L);
        // assertThat(byId).isNull(); // Optional은 Null을 리턴하지 않음
        assertThat(byId).isEmpty(); // isEmpty 는 Optional이 비어있는지 체크함(Null은 나오지 않음)
        // Comment comment1 = byId.orElseThrow(IllegalArgumentException::new); // 무조건 Exception이 발생하는 경우라서.. 보기만하고 주석처리함

    }

    @Test
    public void makeQuery() {
        // Given
        this.createComment("spring data jpa 1234", 100);
        this.createComment("Hibernate JPA Spring Data RDBMS", 55);

        // When
        List<Comment> comments = commentRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThan("spring", 10);

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "LikeCount"));
//        Page<Comment> comments1 = commentRepository.findByCommentContainsIgnoreCase("Hibernate", pageRequest);

        try (Stream<Comment> comments2 = commentRepository.findByCommentContainsIgnoreCase("1234", pageRequest)) {
            Comment firstComment = comments2.findFirst().get();
            assertThat(firstComment.getLikeCount()).isEqualTo(100);
        }

        // Then
        assertThat(comments.size()).isEqualTo(2);
//        assertThat(comments1.getNumberOfElements()).isEqualTo(1);
//        assertThat(comments1).first().hasFieldOrPropertyWithValue("likeCount", 55);


    }

    private void createComment(String keyword, int likeCount) {
        Comment comment = new Comment();
        comment.setComment(keyword);
        comment.setLikeCount(likeCount);
        commentRepository.save(comment);
    }
}