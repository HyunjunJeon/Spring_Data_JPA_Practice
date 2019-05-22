package me.juooon.datajpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter @Setter
@Entity
class Study {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne // 반대쪽에 대한 Entity를 참조하고 있으므로 '주인'
    private Account owner;

}
