package me.jimmyberg.batch.member

import me.jimmyberg.batch.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>