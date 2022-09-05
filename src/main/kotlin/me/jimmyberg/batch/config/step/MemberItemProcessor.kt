package me.jimmyberg.batch.config.step

import me.jimmyberg.batch.entity.Member
import org.springframework.batch.item.ItemProcessor

class MemberItemProcessor : ItemProcessor<Member, Member> {

    override fun process(item: Member): Member = item.apply { this.nickName = "${this.id}_${this.name}_${this.age}" }

}