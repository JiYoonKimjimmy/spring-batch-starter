package me.jimmyberg.batch.config

import org.slf4j.LoggerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@EnableBatchProcessing
@Configuration
class BatchJobConfig(
    val jobBuilderFactory: JobBuilderFactory,
    val stepBuilderFactory: StepBuilderFactory
) {
    // logger
    private val logger = LoggerFactory.getLogger(BatchJobConfig::class.java)

    @Bean
    fun simpleJob(): Job = jobBuilderFactory.get("simpleJob").start(simpleStep()).build()

    @Bean
    fun simpleStep(): Step = stepBuilderFactory
                                .get("simpleStep")
                                .tasklet { contribution, chunkContext ->
                                    logger.info("==== This is Step !! ====")
                                    RepeatStatus.FINISHED
                                }
                                .build()
}