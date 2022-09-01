package me.jimmyberg.batch.member

import me.jimmyberg.batch.entity.Member
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/member")
class MemberController(
    val memberService: MemberService
) {

    @PostMapping
    fun post(@RequestBody member: Member) = memberService.save(member)

    @GetMapping("/all")
    fun findAll() = memberService.findAll()

}