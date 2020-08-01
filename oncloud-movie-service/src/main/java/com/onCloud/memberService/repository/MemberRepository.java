package com.onCloud.memberService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onCloud.memberService.models.Member;

@Repository("memberRepository")
public interface MemberRepository extends MongoRepository<Member, String> {

}
