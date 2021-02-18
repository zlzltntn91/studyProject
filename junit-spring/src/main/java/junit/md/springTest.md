# Spring Test

jUnit을 확장한 스프링의 테스트 라이브러리

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>${org.springframework-version}</version>
</dependency>
```

> ### 1. @RunWith(SpringJunit4ClassRunner.class)
> - ApplicationContext를 만들고 관리하는 작업을 할 수 있도록 jUnit의 기능을 확장
> - jUnit에서는 테스트 메소드별로 객체를 따로 생성해 관리하는 반면 Spring-Test 라이브러리로 확장된 jUnit에서는 컨테이너 기술을 써서 싱글톤으로 관리되는 객체를 사용해 모든 테스트에 사용
> ### 2. @ContextConfiguration(locations = "classpath:xml파일위치")
> - 스프링 빈(Bean) 설정 파일의 위치를 지정
> - @RunWith 어노테이션은 컨테이너를 생성하겠다는 의미인데, 어떤 파일을 참조할지 모르는 상태이기 때문에 이 어노테이션을 함께 써줘야함
> - 파일 위치의 루트는 `src/test/resources`이며 운영 설정 파일을 이곳에 복사해놓고 사용해도 됨
s