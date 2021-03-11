```yaml
# 레플리카셋의 상위 객념
# 레플리카가 3개
# 엔진엑스의 버전을 명시
# 배포를 하게 되는 단위 기록을 남길 수 있음
# 에러가 생겼을 경우 롤백도 가능

apiVersion: apps/v1
kind: Deployment
metadata:
  name: my-nginx-deployment
spec:
  replicas: 3
  selector:
    matchLabels:
      app: my-nginx
  template:
    metadata:
      name: my-nginx-pod
      labels:
        app: my-nginx
    spec:
      containers:
        - name: nginx
          image: nginx:1.10
          ports:
            - containerPort: 80
   
```
	
```commandline
pico deploy.yml
kubectl apply -f deploy.yml
kubectl get deploy


# 디플로이 로그 기록
kubectl apply -f deploy.yml --record 
# 내용 변경
kubectl set image deployment my-nginx-deployment nginx=nginx1.11 --record

# 롤백을 위해 레플리카 셋이 남아있음
# 기록 조회
kubectl rollout history deployment my-nginx-deployment
# 1번 리비젼으로 롤백 (undo)
kubectl rollout undo deployment my-nginx-deployment --to-revision=1
kubectl get popds
kubectl get replicasets

kubeclt get deploy
```

```yaml
deployment-hostname.yml

apiVersion: apps/v1
kind: Deployment
metadata:
  name: hostname-deployment
spec:
  replicas: 3
  selector:
    matchLabels:
      app: webserver
  template:
    metadata:
      name: my-webserver
      labels:
        app: webserver
    spec:
      containers:
        - name: my-webserver
          image: alicek106/rr-test:echo-hostname
          ports:
            - containerPort: 80

```
