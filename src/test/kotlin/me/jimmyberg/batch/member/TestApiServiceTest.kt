package me.jimmyberg.batch.member

import me.jimmyberg.batch.entity.Member
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest(showSql = true)
class TestApiServiceTest {

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Test
    fun saveMember() {
        val member = Member(name = "KIM", age = 33)
        memberRepository.save(member)
    }

}