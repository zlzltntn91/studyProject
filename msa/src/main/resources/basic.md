# 1일차 문제 

### 서비스를 모놀리식(Monolithic) 구조에서 마이크로서비스 구조(MicroService Architecture)로 변경하는 이유는 무엇인가?

### 서비스 운영에 컨테이너(docker)를 사용하여 얻어지는 장점은 무엇인가?
가볍고 다루기 쉬움, 컨테이너는 어플리케이션을 이미지화. 어떠한 환경에서든 실행이 가능하다.

e.g. centos, ubuntu, window, aws

개발자가 실행할때는 잘됐는데 운영서버가서는 터졌다? 를 방지

### docker swarm과 kubernetes가 별도의 오버레이 네트워크(overlay network)를 구성하는 이유는 무엇인가?
호스트와 관계없이 통신가능, 

### kubernetes에서 ingress를 사용하는 이유는 무엇인가?


### istio가 하는 역할은 무엇인가?


### SOAP과 REST의 차이는 무엇인가?

주로 json을 사용한다.

soap은 사장되는 분위기

### Spring이 아닌 SpringBoot을 사용하여 얻어지는 장점은 무엇인가?


### Saga pattern에 대해서 설명하시오.

분산 트랜잭션, 복수개의 트랜잭션이 겹쳤을때? 전통적인 방식은 투페이지 커밋? 


### Circuit Breaker로 인해 서비스 호출이 실패했다면 서비스 소비자(Consumer)는 어떻게 작동해야 하는가?

### CI(Continuous Integration)/CD(Continuous Delivery) 프로세스에 대해서 상세하게 기술하시오.