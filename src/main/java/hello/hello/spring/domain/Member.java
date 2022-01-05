package hello.hello.spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Member {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id; //시스템값
    private  String name; //고객이설정

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
