쿠버네티스는 모든 작업을 자원이라고 봄 쿠버네티스는 그 자체가 컨테이너로 돌아간다.

```
# kubectl api-resources


쿠버네티스 기본 4가지 자원
service
deployments
replicaset
pod

리소스 설명
# kubectl explain pod | more

보통 다른사람이 만든 yaml 파일을 참조해서 만든다.
```

쿠버네티스는 모든것을 yaml 파일로 저장한다 pod은 컨테이너의 집합, 쿠버네티스의 실행 가능한 가장 작은 단위

```yaml
# - 가 들어간 필드는 복수개로 설정할 수 있다.
apiVersion: v1
kind: Pod
metadata:
  name: my-nginx-pod
spec:
  containers:
    - name: my-nginx-container # 컨테이너 명
      image: nginx:latest # 도커 이미지
      ports:
        - containerPort: 80
          protocol: TCP

```

```
쿠버네티스는 항상 이 상태가 되게끔 만든다

이 상태로 만들어라
# kubectl apply -f nginx-pod.yml
# kubectl create -f nginx-pod.yml 
```

```commandline
history

1  kubectl api-resources
2  kubectl explain pod | pore
3  kubectl explain pod | more
4  docker ps
5  docker ps
6  docker image ls
7  kubectl get namespace
8  kubectl get pods -n
9  kubectl get pods -n kubesystem
10  kubectl get pods -n kube-system
11  kubectl get pods --name kube-system
12  kubectl get pods -name kube-system
13  kubectl get pods --name kube-system
14  kubectl get pods --n kube-system
15  kubectl get pods -n kube-system
16  kubectl get pods --all-namespaces
17  ps aux |grep kube
18  cat nginx-pod.yml
19  kubectl apply -f nginx-pod.yml 
20  # kubectl create -f nginx-pod.yml
21  # kubectl create -f nginx-pod.yml
22  kubectl get nod
23  kubectl get node
24  kubectl get pods
25  # kubectl create -f nginx-pod.yml
26  # kubectl create nginx-pod.yml
27  # kubectl create -f nginx-pod.yml
28  cat nginx-pod.yml 
29  # kubectl create -f nginx-pod.yml
30  kubectl apply -f nginx-pod.yml 
31  # k ubectl create -f nginx-pod.yml
32  kubectl get nodes
33  kubectl get pods
34  kubectl get resources
35  history
```
`팟 제거 비추 # kubectl delete pod my-nginx-pod`
`팟 제거 추추 야믈 파일로 생성된 팟 제거 # kubectl delete -f nginx-pod.yml`
`# kubectl `