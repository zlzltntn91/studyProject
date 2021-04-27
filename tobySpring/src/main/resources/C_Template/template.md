# Template

`일정한 패턴으로 유지되는 특성을 가진 부분`과 `자유롭게 변경되는 성질을 가진 부분`으로 `분리하고 독립`시켜 효과적으로 활용할 수 있도록 하는 방법

핵심은 변하지 않는, 그러나 많은곳에서 중복되는 코드와 로직에 따라 자주 확장되고 변하는 코드를 잘 분리해내는 작업

> 중첩 클래스의 종류
> > 다른 클래스 내부에 정의되는 클래스를 중첩 클래스 (Nested Class)  라고 한다.
> > 독립적으로 오브젝트로 만들어질 수 있는 스태틱클래스와 자신이 정의된 클래스의 오브젝트 안에서만 만들어질 수 있는 내부 클래스로 구분된다.
> 
> 내부 클래스
> > 범위에 따라 세가지로 구분되며 멤버 필드처럼 오브젝트 레빌에 정의되는 맴버 내부 클래스,
> > 메서드 레벨에서 정의 되는 로컬 클래스, 그리고 이름을 갖지 않는 익명 내부 클래스다.
> > 익명 내부 클래스의 경우 선언된 위치에 따라 범위가 다르다.
>
> 익명 내부 클래스
> > 이름을 갖지 않는 클래스, 선언과 오브젝트 생성이 결합된 형태로 만들어짐 

# 탬플릿과 콜백

스프링에서는 전략패턴의 기본 구조에 익명 내부 클래스를 활용한 방식을 템플릿/콜백이라고 부른다.
전략패턴의 컨택스트를 탬플릿이라 하고 익명 내부 클래스로 만들어지는 오브젝트를 콜백이라고 부른다.

> 콜백
> > 실행되는 것을 목적으로 메서드에 전달되는 오브젝트를 말한다.
> > 파라미터로 전달되지만 값의 참조가 아닌 실행을 목적으로 사용되며 자바에서는 메서드 자체를 파라미터로 전달할 방법이 없어서
> > 메서드가 담긴 오브젝트를 전달한다. 그래서 펑셔널 오브젝트라고도 한다.
> 
