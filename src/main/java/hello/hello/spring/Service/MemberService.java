package hello.hello.spring.Service;

import hello.hello.spring.domain.Member;
import hello.hello.spring.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service
public class MemberService {

    private final MemberRepo memberRepo;

    //Autowired
    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }


    public long join(Member member){ //회원가입

        validateDuplicaterMember(member);
        memberRepo.save(member);
        return member.getId();

    }


    private void validateDuplicaterMember(Member member) {
        memberRepo.findByName(member.getName())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미존재하는 회원");
                });
    }
    public List<Member> findMember(){
        return memberRepo.findAll();
    }

    public Optional<Member> findOne(Long memberId ){
        return memberRepo.findById(memberId);

    }

}
