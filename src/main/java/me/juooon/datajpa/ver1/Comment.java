package me.juooon.datajpa.ver1;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter @Setter
@Entity
public class Comment {
    @Id @GeneratedValue
    private Long id;

    private String comment;
    private Date created;
    private Integer likeCount = 0;

    @ManyToOne
    private Post post;
}
