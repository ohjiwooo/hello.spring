package hello.hello.spring.Service;

import hello.hello.spring.domain.Member;
import hello.hello.spring.repo.MemoryMemberRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService  memberService;
    MemoryMemberRepo memberRepo;

    @BeforeEach
    public void beforeEach(){
        memberRepo = new MemoryMemberRepo();
        memberService = new MemberService(memberRepo);

    }

    @AfterEach
    public void afterEach(){
        memberRepo.clearStore();
    };
    @Test
    void 회원가입() {

        //given
        Member member = new Member();
        member.setName("spring");

        //when

        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void  중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when

        memberService.join(member1);

        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    /*    try{
            memberService.join(member2);
            fail();
        }catch(IllegalStateException e){
            org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("이미존재하는 회원");
        }*/

        //then
    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}