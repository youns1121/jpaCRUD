package com.jpacrud.repository;

import com.jpacrud.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MemberRepository extends JpaRepository<Member, Long> {

   Member findByMemberId(String memberId);




}
