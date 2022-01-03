package hello.hello.spring.repo;

import hello.hello.spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepoTest {

    MemoryMemberRepo repo = new MemoryMemberRepo();

    @AfterEach
    public void afterEach(){
        repo.clearStore();
    };

    @Test
    public void save(){
        Member member = new Member();
        member.setName("jiwoo");

        repo.save(member);
        Member result = repo.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
        //Assertions.assertEquals(member,result);

    }

    @Test
    public  void findByName(){

        Member member1 = new Member();
        member1.setName("jiwoo");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("jiwoo2");
        repo.save(member2);


        Member result = repo.findByName("jiwoo").get();
        Assertions.assertThat(result).isEqualTo(member1);

    }

    @Test

    public void findAll(){

        Member member1 = new Member();
        member1.setName("jiwoo");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("jiwoo2");
        repo.save(member2);

        List<Member> result = repo.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);

    }
}
