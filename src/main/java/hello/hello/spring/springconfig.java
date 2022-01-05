package hello.hello.spring;


import hello.hello.spring.Service.MemberService;
import hello.hello.spring.repo.JpaMemberRepo;
import hello.hello.spring.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class springconfig {
    
    private final MemberRepo memberRepo;

    @Autowired
    public springconfig(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepo);
    }


}
