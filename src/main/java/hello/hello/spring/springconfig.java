package hello.hello.spring;


import hello.hello.spring.Service.MemberService;
import hello.hello.spring.repo.JpaMemberRepo;
import hello.hello.spring.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class springconfig {

    // private DataSource dataSource;

    //   @Autowired
    //   public springconfig(DataSource dataSource) {
    //       this.dataSource = dataSource;
    //   }

    private EntityManager em;

    @Autowired
    public springconfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepo());
    }

    @Bean
    public MemberRepo memberRepo(){

       // return new MemoryMemberRepo();
        return new JpaMemberRepo(em);
    }
}
