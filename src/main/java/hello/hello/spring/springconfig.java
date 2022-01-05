package hello.hello.spring;


import hello.hello.spring.Service.MemberService;
import hello.hello.spring.repo.JdbcMemberRepo;
import hello.hello.spring.repo.JdbcTempleteMemberRepo;
import hello.hello.spring.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class springconfig {

    private DataSource dataSource;

    @Autowired
    public springconfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepo());
    }

    @Bean
    public MemberRepo memberRepo(){

       // return new MemoryMemberRepo();
        return new JdbcTempleteMemberRepo(dataSource);
    }
}
