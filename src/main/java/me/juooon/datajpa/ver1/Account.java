package me.juooon.datajpa.ver1;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
class Account {
    @Id @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @Temporal(TemporalType.DATE)
    private Date created;

    //@Transient
    private String email;

    @OneToMany(mappedBy = "owner") // 1개의 Account는 여러개의 Study를 만들 수 있음
    private Set<Study> studies = new HashSet<>();

    public void addStudy(Study study){ // 양방향 매핑의 경우 해당 메서드를 호출(Convenient 메서드라고 부름)
        this.getStudies().add(study);
        study.setOwner(this);
    }

    public void removeStudy(Study study){
        this.getStudies().remove(study);
        study.setOwner(null);
    }



    // 다른 것을 확인하는데 너무 복잡해서 주석처리
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
//            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
//            @AttributeOverride(name = "state", column = @Column(name = "home_state")),
//            @AttributeOverride(name = "zipCode", column = @Column(name = "home_zipCode"))
//    })
//    private Address homeAddress;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "street", column = @Column(name = "office_street")),
//            @AttributeOverride(name = "city", column = @Column(name = "office_city")),
//            @AttributeOverride(name = "state", column = @Column(name = "office_state")),
//            @AttributeOverride(name = "zipCode", column = @Column(name = "office_zipCode"))
//    })
//    private Address officeAddress;
}
