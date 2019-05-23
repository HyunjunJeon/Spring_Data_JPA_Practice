package me.juooon.datajpa.ver2;

import me.juooon.datajpa.ver2.post.Post2;
import me.juooon.datajpa.ver2.post.Post2Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Post2RepositoryTest {
    @Autowired
    Post2Repository post2Repository;

    @Test
    public void crud() {
        Post2 post = new Post2();
        post.setTitle("Hibernate");

        assertThat(post2Repository.contains(post)).isFalse();

        post2Repository.save(post);

        assertThat(post2Repository.contains(post)).isTrue();

        post2Repository.delete(post);
        post2Repository.flush();
    }
}
