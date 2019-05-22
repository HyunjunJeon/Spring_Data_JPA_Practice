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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
            @AttributeOverride(name = "state", column = @Column(name = "home_state")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "home_zipCode"))
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "office_street")),
            @AttributeOverride(name = "city", column = @Column(name = "office_city")),
            @AttributeOverride(name = "state", column = @Column(name = "office_state")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "office_zipCode"))
    })
    private Address officeAddress;
}
