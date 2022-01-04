package hello.hello.spring;


import hello.hello.spring.Service.MemberService;
import hello.hello.spring.repo.MemberRepo;
import hello.hello.spring.repo.MemoryMemberRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class springconfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepo());
    }

    @Bean
    public MemberRepo memberRepo(){

        return new MemoryMemberRepo();
    }
}
