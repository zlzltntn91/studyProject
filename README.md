# StudyProject
## GIT 21/02/01 ~ 21/02/28
- [Do it! 지옥에서 온 문서 관리자 깃&깃허브](http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&linkClass=&barcode=9791163031222)

## CI/CD 21/01/20 ~ 21/02/28
- [자바 프로젝트 필수 유틸리티](https://kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9791162240700&orderClick=JAj)
   
## DesignPatterns 21/01/20 ~ 21/02/28
- [Head first design patterns](http://www.kyobobook.co.kr/product/detailViewKor.laf?barcode=9788979143409)
  
## TobySpring 21/01/01 ~ 21/06/01
- [토비의 스프링 3.1](http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9788960773417)
 
### 예정

#### 자바
- 이펙티브 자바
- 모던 자바 인 액션
- 카이호스트만의 코어 자바 8

#### 자바스크립트
- 인사이드 자바스크립트
- 코어 자바스크립트

#### 기타
- Node.js 교과서
- Do it! 지옥에서 온 문서 관리자 깃&깃허브 입문
- 파이썬 증권 데이터 분석


<util:properties id="egovProperties" location="classpath:/egovframework/props/egov.properties#{systemProperties['spring.profiles.active']}" />

====================================

@Value("#{egovProperties['msg.fail.code']}")
String [] success;
