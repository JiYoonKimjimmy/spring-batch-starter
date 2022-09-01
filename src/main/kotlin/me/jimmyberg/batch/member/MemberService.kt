package me.jimmyberg.batch.member

import me.jimmyberg.batch.entity.Member
import org.springframework.stereotype.Service

@Service
class MemberService(
    val memberRepository: MemberRepository
) {

    fun save(member: Member) = memberRepository.save(member)

    fun findAll(): List<Member> = memberRepository.findAll()

}