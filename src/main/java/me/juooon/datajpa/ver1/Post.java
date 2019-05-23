package me.juooon.datajpa.ver1;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
public class Post {
    /*
        Cascade를 설명하기 위한 Parent(Post) - Child(Comment) 연관관계
     */

    @Id @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> commments = new HashSet<>();

    public void addComment(Comment comment){
        this.getCommments().add(comment);
        comment.setPost(this);
    }

}
