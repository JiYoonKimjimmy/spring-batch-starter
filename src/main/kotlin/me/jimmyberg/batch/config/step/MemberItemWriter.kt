package me.jimmyberg.batch.config.step

import me.jimmyberg.batch.entity.Member
import org.springframework.batch.item.ItemWriter

class MemberItemWriter : ItemWriter<Member> {

    override fun write(items: MutableList<out Member>) {
        items.forEach(::println)
    }

}