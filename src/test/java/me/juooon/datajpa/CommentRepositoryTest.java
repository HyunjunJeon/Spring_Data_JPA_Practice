package me.juooon.datajpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    }
}