# Hamcrest
> Hamcrest는 'match' 규칙을 선언적으로 정의할 수 있는 matcher 객체를 작성하기 위한 프레임 워크이다
> Junit을 사용할 때 Hamcrest 프레임워크를 사용하면 가독성은 물론이고 코드의 조건을 조금 더 손쉽게 확인할 수 있음
> 

### Junit4 assert statements와 Hamcrest matchers를 비교 
```java
assertEquals(expected, actual);                 assertThat(actual, is(equalTo(expected)));
assertNotEquals(expected, actual)               assertThat(actual, is(not(equalTo(expected))));
assertTrue(result instanceof String);           assertThat(result, instanceOf(String.class));
```

## Matchers ([참고](https://www.baeldung.com/tag/hamcrest/))
- anything - 항상 일치하며, 테스트 중인 개체가 어떤 것이든 상관 없는 경우에 유용하다.
- describedAs - 사용자가 직접 테스트 실패에 대한 설명을 추가하는 decorator
- is - 가독성을 높이기 위한 decorator

Logical
- allOf - 모든 matcher가 true를 반환하면 통과 (like Java &&)
- anyOf - 적어도 하나의 matcher가 true를 반환하면 통과 (like Java ||)
- not - 랩핑된 matcher가 false를 반환하면 통과

Object
- equalTo - Object.equals을 사용해 객체가 동일한지 판단한다.
- hasToString - Object.toString 메소드 값과 일치 여부를 판별한다.
- instanceOf, isCompatibleType - 동일 인스턴스인지 타입 비교
- notNullValue, nullValue - Null인지 아닌지 판별
- sameInstance - Object가 완전히 동일한지 비교. equals비교 X 주소비교 (==)

Beans
- hasProperty - JavaBeans properties 테스트, 해당 property를 가지고 있는지 판단

Collections
- hasEntry, hasKey, hasValue - Map요소에 대한 포함여부 판단
- hasItem, hasItems - 특정 요소를 포함한 컬렉션인지 판단
- hasItemInArray - 특정 요소를 포함한 배열인지 판단

Number
- closeTo - 부동 소수점 값이 주어진 값에 가까운지 테스트 (값과 오차를 인자로 받는다)
- greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo - 값 비교, 차례대로 >, >=, <, <=

Text
- equalToIgnoringCase - 대소문자 구분 없이 동일한 문자열인지 판단
- equalToIgnoringWhiteSpace - 문자열 내 모든 공백 제거 후 동일한 문자열인지 판단
- containsString, endsWith, startsWith - 특정 문자열을 포함하는가, 특정 문자열로 종료, 특정 문자열로 시작