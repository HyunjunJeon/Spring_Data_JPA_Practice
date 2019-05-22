package me.juooon.datajpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
public class Account {
    @Id @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @Temporal(TemporalType.DATE)
    private Date created;

    @Transient
    private String email;
}
