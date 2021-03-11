# Day2

k8s

nginx : 아파치를 대체하는 차세대 웹서버

gke : google kubernetes engine
gce : google compute engine


커널이 뭐임 ?
컨테이너는 일시적이지만 볼륨을 사용한다면 저장 가능하다.
ctrl + p + q ? 

1. 현재 구동중인 컨테이너를 이미지를 만드는 방법
2. f로

```commandline
docker commit -a 'soo' -m 'initial repo' commit_test commit_test:first
soo라는 사람이 intial repo라는 메세지로 commit_test 이미지를 처음 커밋하고 레포지토리명은 commit_test, 테그는 first
```

이미지를 만들면
레이어가 쌓이네, 도커는 레이어드 파일 시스템
지린다..

docker -> docker swarm -> kubernetes