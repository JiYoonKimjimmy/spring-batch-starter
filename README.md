# Spring Batch Starter

## Spring Batch
- Spring Framework 를 활용한 Batch 시스템 구축 Framework
- Spring Data JPA 등 다양한 라이브러리 활용 가능
- 별도 JAR 구성 가능하며, CronJob 등을 활용한 스케쥴링 가능

### Build Project
- Kotlin 1.5.31
- Spring Batch 2.5.6
- Spring Data JPA 2.5.6
- QueryDSL
- H2 Database

---

### Spring Batch `with QueryDSL`
- `JpaPagingItemReader` 인터페이스에서 Native Query 가 아닌 QueryDSL 를 활용하여 SQL 문 작성
- Native Query 의 Typed-Safe 하지 못한 단점을 보완 
- 참고 글 : [우아한형제들 기술블로그 - "Spring Batch 와 Querydsl"](https://techblog.woowahan.com/2662/)

---

### Trouble-Shooting
#### H2 Database 설치 후 연동 문제
- H2 Console 접속할 때와 프로젝트 Properties 설정할 때의 접속 URL 차이 확인
- H2 Console 에서 `jdbc:h2:~/데이터베이스명` 으로 DB 생성
- Spring Boot 프로젝트에서 연동할 때는 TCP 방식으로 `jdbc:h2:tcp://localhost/~/데이터베이스명` 으로 접속

```yaml
spring:
  datasource:
    hikari:
      driver-class-name: org.h2.Driver
      jdbc-url: jdbc:h2:tcp://localhost/~/test
      username: sa
      password:
```

#### 관련 : https://adg0609.tistory.com/62

#### Kotlin & Spring Data JPA 연동 문제
- Kotlin 프로젝트에서 Spring Data JPA 를 사용할 때는, **Build Plugin** 주입 필요

```groovy
plugins {
    // ...
    kotlin("plugin.spring") version "1.5.31"
    kotlin("plugin.jpa") version "1.5.31"
    // ...
}
```

#### 관련 : https://stackoverflow.com/questions/32038177/kotlin-with-jpa-default-constructor-hell
