# Spring Test

> 테스트가 독립적이라고 해서 매번 스프링 컨텍스트, 즉 컨테이너를 새로 만드는 것은 매우 비효율적.
> 스프링 테스트는 사용하는 컨텍스트를 캐싱해ㅔ서 여러 테스트에서 하나의 컨텍스트를 공유할 수 있는 방법을 제공한다.
>> 즉 동일한 컨텍스트 구성을 갖는 테스트끼리는 같은 컨텍스트를 공유하는것
>> 공유는 메서드 사이에서만 가능한 게 아니라 여러 클래스 사이에서도 가능하다. 

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>${org.springframework-version}</version>
    <scope>test</scope>
</dependency>
```

### 1. @RunWith(SpringJunit4ClassRunner.class)
- ApplicationContext를 만들고 관리하는 작업을 할 수 있도록 jUnit의 기능을 확장
- jUnit에서는 테스트 메소드별로 객체를 따로 생성해 관리하는 반면 Spring-Test 라이브러리로 확장된 jUnit에서는 컨테이너 기술을 써서 싱글톤으로 관리되는 객체를 사용해 모든 테스트에 사용

### 2. @ContextConfiguration(locations = "classpath:xml파일위치")
- 스프링 빈(Bean) 설정 파일의 위치를 지정
- @RunWith 어노테이션은 컨테이너를 생성하겠다는 의미인데, 어떤 파일을 참조할지 모르는 상태이기 때문에 이 어노테이션을 함께 써줘야함
- 파일 위치의 루트는 `src/test/resources`이며 운영 설정 파일을 이곳에 복사해놓고 사용해도 됨