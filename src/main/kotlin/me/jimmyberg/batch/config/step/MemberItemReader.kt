package me.jimmyberg.batch.config.step

import me.jimmyberg.batch.entity.Member
import org.springframework.batch.item.database.JpaPagingItemReader
import javax.persistence.EntityManagerFactory

class MemberItemReader(
    entityManagerFactory: EntityManagerFactory
): JpaPagingItemReader<Member>() {

    init {
        this.pageSize = 1
        this.setName("memberItemReader")
        this.setQueryString("select m from Member m order by id")
        this.setEntityManagerFactory(entityManagerFactory)
    }

}