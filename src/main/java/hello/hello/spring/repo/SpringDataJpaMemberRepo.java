package hello.hello.spring.repo;

import hello.hello.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepo extends JpaRepository<Member, Long>, MemberRepo { //구현체 자동생성 및 bin에 등록

    @Override
    Optional<Member> findByName(String name);

}
