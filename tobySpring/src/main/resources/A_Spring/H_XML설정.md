# XML을 이용한 설정
자바 클래스를 이용하는것 외에 다양한 방법을 통해 DI 의존관계 설정정보를 만들 수 있다. XML 은 쉽게 이해할 수 있으며 컴파일과 같은 별도의 빌드 작업이 없다는것이 장점이다. 환경이 달라져 오브젝트의 관계가
바뀌는 경우에도 빠르게 변경사항을 반영할 수 있다. 스키마, DTD를 통해 정해진 포멧에 따라 작성됐는지 쉽게 확인할 수 있다.

## XML 설정

DI 정보가 담긴 XML 파일은 `<beans>`를 루트 엘리먼트로 사용한다. 

@Bean 어노테이션을 얻을 수 있는 정보는 다음과 같다.
1. 빈의 이름: 어노테이션이 붙은 메서드의 이름이 빈의 이름이다, 이 이름은 getBean()에서 사용된다.
2. 빈의 클래스: 빈 오브젝트를 어떤 클래스를 이용해서 만들지를 정한다.
3. 빈의 의존 오브젝트: 빈의 생성자, 수정자 메서드를 통해 의존 오브젝트를 넣어준다. 의존 오브젝트도 하나의 빈이므로 이름이 있을것이고, 그 이름에 해당하는 메서드를 호출해서 의존 오브젝트를 가져온다. 의존
   오브젝트는 하나 이상일 수 도 있다.

의존 오브젝트가 없는 빈의 경우는 3번을 생략할 수 있다.

## 자바설정에서 XML 설정으로
```java
@Configuration
public class DaoFactory {

	@Bean
	public UserDao userDao(){
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}

	@Bean
	public SimpleConnectionMaker connectionMaker(){
		return new NConnectionMaker();
	}
}
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="connectionMaker" class="toby.vol1.chapter1.I_xmlConfig.NConnectionMaker"/>
    <bean id="userDao" class="toby.vol1.chapter1.I_xmlConfig.UserDao">
        <property name="connectionMaker" ref="connectionMaker"/>
    </bean>
</beans>
```
class 어트리뷰트는 메서드 내에서 오브젝트를 만들 때 사용하는 클래스 이름을 넣어줘야한다. 리턴타입을 적는것이 아니다.
e.g. connectionMaker() 메서드의 리턴타입은 SimpleConnectionMaker이지만 NConnectionMaker를 적어준것이 이 이유다.

자바빈의 관례를 따라서 수정자 메서드는 프로퍼티가 된다. 프로퍼티 이름은 메서드 이름에서 set을 제외한 나머지 부분을 사용한다.
e.g. setConnectionMaker() 메서드를 갖고잇으면 connectionMaker라는 프로퍼티를 갖게되는 것

`<property>` 태그는 name과 ref라는 두개의 어트리뷰트를 갖는다.

```java
@Slf4j
public class UserDao {

	SimpleConnectionMaker connection;

	public void setConnectionMaker(SimpleConnectionMaker connection) {
		this.connection = connection;
	}

	public String get(String id) throws SQLException {
		Connection con = connection.makeConnection();
		...
	}
}
```
자바빈의 관례를 따라서 수정자 메서드는 프로퍼티가 된다. 프로퍼티 이름은 메서드 이름에서 set을 제외한 나머지 부분을 사용한다.
setConnectionMaker() 메서드를 갖고잇으면 connectionMaker라는 프로퍼티를 갖게되는 것

## 테스트

```java

@Slf4j
public class UserDaoTest {
	@Test
	public void xmlConfig() throws SQLException {
		ApplicationContext applicationContext = new GenericXmlApplicationContext("I_xmlConfig/applicationContext.xml");
		log.info(String.valueOf(applicationContext.getBeanDefinitionCount()));
		log.info(Arrays.toString(applicationContext.getBeanDefinitionNames()));
		UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
		log.info(userDao.get("kim90soo"));
	}
}
```
```commandline
[INFO ] [UserDaoTest.xmlConfig(20)] 2
[INFO ] [UserDaoTest.xmlConfig(21)] [connectionMaker, userDao]
[INFO ] [UserDaoTest.xmlConfig(23)] User(id=kim90soo, name=김은수, password=qwe123!@#)
```

GeericXmlApplicationContext를 이용하여 어플리케이션 컨텍스트를 생성할 수 있다. 생성자에는 xml 파일의 경로를 넣어주면 된다.
ClassPathXmlApplicationContext를 용하여 가져올 수 도 있는데 이름과 같이 xml 을 classpath부터 찾는다. 

## value 값의 자동 변환
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean  id="dataSource" class="org.springframework.jdbc.datasource.SimpleDriverDataSource">
        <property name="driverClass" value="com.mysql.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost/toby?characterEncoding=utf8"/>
        <property name="username" value="zlatn91"/>
        <property name="password" value="kim90soo"/>
    </bean>
   
</beans>
```
driverClass 는 class타입을 받고있는데 xml에서는 문자열을 전달했는데도 테스트에 성공한다.
가능한 이유는 스프링이 프로퍼티의 값을 수정자 메서드의 파라미터 타입을 참조해서 적절한 형태로 ㅂ
변환해준다. 

## 정리
