package hello.hello.spring.repo;
import hello.hello.spring.domain.Member;
import java.util.Optional;
import java.util.List;
import java.util.Optional;

public interface MemberRepo {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
