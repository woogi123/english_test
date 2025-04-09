package swEngineering.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swEngineering.member.entity.MemberEntity;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 이메일로 회원정보 조회(select * from member_table where member_email=?)
    Optional<MemberEntity> findByMemberEmail(String memberEmail);


}