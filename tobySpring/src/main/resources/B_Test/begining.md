# 테스트

어플리케이션의 변화에 대응하는 첫번째 전략은 IoC/DI다.두번째 전략은 만들어지는 코드를 확신할 수 있게 해주고 변화에 유연하게 대처할 수 있는 자신감을 주는 테스트 기술이다.

테스트 대상이되는 클래스에서 `ctrl + shift + t` 를 누르면 생성한 테스트 클래스로 이동한다.

## 빌드툴

프로젝트의 빌드를 위해 ANT나 메이븐 같은 빌드 툴과 스크립트를 사용한다. 빌드 툴에서 제공하는 Junit 플러그인이나 테스크를 이용해 테스트 할 수 있다. 테스트 결과는 옵션에따라 HTML이나 텍스트 파일의
형태로 보기 좋게 만들어진다.

개발자 개인별로는 IDE에서 Junit 도구를 활용해 테스트 하는것이 가장 편리하지만, 여러 개발자가 만든 코드를 모두 통합해서 테스트 할때도 있다. 이때 빌드 스크립트를 이용해 Junit을 테스트하고 그 결과를
메일로 받을 수 있다.

## 스프링 테스트

ApplicationContext를 메서드마다 생성하게되면 어플리케이션 컨택스트가 3개 생성된다. AC가 만들어질때는 모든 싱글톤 빈 오브젝트를 초기화한다. 단순히 빈을 만드는 정도는 문제가 되지않지만 어떤 빈은
오브젝트 생성시 초기화 작업을 진행해서 많은시간을 필요로 할 수 있다. 또 한가지 문제는 어플리케이션 컨텍스트가 초기화될때 어떤 빈은 독자적으로 많은 리소스를 할당하거나 독립적인 스레드를 띄우기도 한다는 점이다.

이런 경우에는 테스트를 마칠때마다 AC내의 빈이 할당한 리소스를 깔끔하게 정리해주지 않으면 다음테스트에서 새로운 AC가 만들어지면서 문제가 발생할 수 잇다. 테스트는 가능한 독립적으로 매번 새로운 오브젝트를 만들어
사용하는것이 원칙이지만 AC처럼 생성에 많은 시간과 자원이 드는 경우에는 테스트 전체가 공유하는 오브젝트를 만들기도 한다. 이때도 테스트는 일관성이 있는 실행 결과를 보장해야하고, 테스트의 실행 순서가 결과에 영향을
미치지 않아야 한다.

AC는 초기화 되고나면 내부의 상태가 바뀌는 일은 거의 없다. 빈을 싱글톤으로 만들었기 때문에 상태를 갖지 않는다. 따라서 AC는 한번 만들고 여러 테스트가 공유해서 사용해도 된다.

문제는 JUnit이 매번 테스트클래스의 오브젝트를 새로 만든다는 점인데 따라서 여러 테스트가 함꼐 참조할 AC를 오브젝트 래밸에 저장해두면 곤란한다. 이때 이용하는 것이 @BeforeClass를 어노테이션하고 스태틱
메서드를 작성하면 된다.

## 테스트시의 AC관리

```java

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/chapter2/B_springTest/applicationContext.xml")
public class UserDaoTest {

	@Autowired
	ApplicationContext context;

	@Test
	public void test() throws SQLException {
		UserDao userDao = context.getBean("userDao", UserDao.class);
		log.info(userDao.get("kim90soo"));
	}
}
```

이 소스에서 context는 NPE가 발생하지 않는다. Junit은 확장할떄 사용하는 @RunWith를 선언하면 테스트를 진행하는 중에 사용할 AC를 직접 만들고 관리하는 작업을 해준다.

## 테스트 메소드간 컨택스트 공유

```java

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/chapter2/B_springTest/applicationContext.xml")
public class UserDaoTest {

	@Autowired
	ApplicationContext context;

	@Before
	public void setUp() {
		log.info(this.toString());
		log.info(this.context.toString());
	}

	@Test
	public void t1() {
	}

	@Test
	public void t2() {
	}

	@Test
	public void t3() {
	}
}
```

```commandline
[INFO ] [UserDaoTest.setUp(24)] toby.vol1.chapter2.B_springTest.UserDaoTest@6f7fd0e6
[INFO ] [UserDaoTest.setUp(25)] org.springframework.context.support.GenericApplicationContext@73ad2d6: startup date [Thu Apr 01 15:25:40 KST 2021]; root of context hierarchy
[INFO ] [UserDaoTest.setUp(24)] toby.vol1.chapter2.B_springTest.UserDaoTest@318ba8c8
[INFO ] [UserDaoTest.setUp(25)] org.springframework.context.support.GenericApplicationContext@73ad2d6: startup date [Thu Apr 01 15:25:40 KST 2021]; root of context hierarchy
[INFO ] [UserDaoTest.setUp(24)] toby.vol1.chapter2.B_springTest.UserDaoTest@2f112965
[INFO ] [UserDaoTest.setUp(25)] org.springframework.context.support.GenericApplicationContext@73ad2d6: startup date [Thu Apr 01 15:25:40 KST 2021]; root of context hierarchy
```

UserDaoTest 클래스는 매번 생성되어 hashcode가 변하지만 context는 하나로 공유된다.

### 그렇다면 context 변수에 어떻게 AC가 들어가 잇는것일까?

@Runwith는 테스트가 실행되기전 딱 한번 AC를 만들어 두고 테스트 오브젝트가 만들어 질때마다 AC를 자신의 테스트 오브젝트의 특정 필드에 주입한다.

## 테스트 클래스 간의 컨택스트 공유

테스트 클래스 내에서 컨텍스트를 공유하는것이 전부가 아닌 여러개의 클래스에서도 공유할 수 있다.
```java
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/chapter2/B_springTest/applicationContext.xml")
public class UserDaoTest {
	@Autowired
	ApplicationContext context;
	...
}

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/chapter2/B_springTest/applicationContext.xml")
public class UserDaoTest2 {
	@Autowired
	ApplicationContext context;
	...
}
```
위 두개 클래스는 AC를 공유한다.
```commandline
[INFO ] [UserDaoTest.setUp(24)] toby.vol1.chapter2.B_springTest.UserDaoTest@12b0404f
[INFO ] [UserDaoTest.setUp(25)] org.springframework.context.support.GenericApplicationContext@4b952a2d: startup date [Thu Apr 01 15:31:15 KST 2021]; root of context hierarchy
[INFO ] [UserDaoTest.setUp(24)] toby.vol1.chapter2.B_springTest.UserDaoTest@1ffe63b9
[INFO ] [UserDaoTest.setUp(25)] org.springframework.context.support.GenericApplicationContext@4b952a2d: startup date [Thu Apr 01 15:31:15 KST 2021]; root of context hierarchy
[INFO ] [UserDaoTest.setUp(24)] toby.vol1.chapter2.B_springTest.UserDaoTest@7c469c48
[INFO ] [UserDaoTest.setUp(25)] org.springframework.context.support.GenericApplicationContext@4b952a2d: startup date [Thu Apr 01 15:31:15 KST 2021]; root of context hierarchy

[INFO ] [UserDaoTest2.setUp(22)] toby.vol1.chapter2.B_springTest.UserDaoTest2@48fa0f47
[INFO ] [UserDaoTest2.setUp(23)] org.springframework.context.support.GenericApplicationContext@4b952a2d: startup date [Thu Apr 01 15:31:15 KST 2021]; root of context hierarchy
[INFO ] [UserDaoTest2.setUp(22)] toby.vol1.chapter2.B_springTest.UserDaoTest2@5e316c74
[INFO ] [UserDaoTest2.setUp(23)] org.springframework.context.support.GenericApplicationContext@4b952a2d: startup date [Thu Apr 01 15:31:15 KST 2021]; root of context hierarchy
[INFO ] [UserDaoTest2.setUp(22)] toby.vol1.chapter2.B_springTest.UserDaoTest2@1e802ef9
[INFO ] [UserDaoTest2.setUp(23)] org.springframework.context.support.GenericApplicationContext@4b952a2d: startup date [Thu Apr 01 15:31:15 KST 2021]; root of context hierarchy
```
따라서 수백개의 테스크 클래스를 만들어서 모두 같은 설정파일을 공유한다고 해도 단 하나의 AC만 만들어져서 사용된다.
이 덕분에 테스트 성능은 대폭 상향된다.

> ApplicationContext가 @Autowired로 DI되는 이유?
>> XML 설정파일을 보면 ApplicationContext는 빈으로 등록한 적이없다.
>>
>> 스프링 AC는 초기화할 때 자신도 빈으로 등록한다. 따라서  AC에는 ApplicationContext 타입의 빈이 존재하는셈이고 DI도 할 수 있다.