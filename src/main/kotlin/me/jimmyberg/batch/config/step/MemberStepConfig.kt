package me.jimmyberg.batch.config.step

import me.jimmyberg.batch.entity.Member
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManagerFactory

@Configuration
class MemberStepConfig(
    val stepBuilderFactory: StepBuilderFactory,
    val entityManagerFactory: EntityManagerFactory
) {

    @Bean
    fun memberStep(): Step =
        stepBuilderFactory
            .get("memberStep")
            .chunk<Member, Member>(1)
            .reader(MemberItemReader(entityManagerFactory))
            .processor(MemberItemProcessor())
            .writer(MemberItemWriter())
            .build()

}