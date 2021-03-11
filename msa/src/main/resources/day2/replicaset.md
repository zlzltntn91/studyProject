모든서비스가 웹서비스로 이동하고있음 
nginx도 라이브스트리밍 서비스를 지원

```yaml
# replicaset.yml
# 똑같은 팟을 여러개 만드는것이 레플리카셋
# 팟을 세개 만들겠다.
# 어떤 팟을 세개 만들것이냐
apiVersion: apps/v1
kind: ReplicaSet
metadata:
  name: replicaset-nginx
spec:
  replicas: 3
  selector:
    matchLabels:
      app: my-nginx-pods-label
  template:
    metadata:
      name: my-nginx-pod
      labels:
        app: my-nginx-pods-label
    spec:
      containers:
        - name: nginx
          image: nginx:latest
          ports:
            - containerPort: 80
```

```commandline
kubectl apply -f replicaset.yml
kubectl get replicaset
kubectl get pods

렌덤스트링 붙어서 레플리카 생김

NAME                     READY   STATUS    RESTARTS   AGE
my-nginx-pod             1/1     Running   0          139m
replicaset-nginx-6frr9   1/1     Running   0          2m30s
replicaset-nginx-c8dst   1/1     Running   0          2m30s
replicaset-nginx-snpr4   1/1     Running   0          2m30s

이 뒤로 팟을 하나 지우면 다시 생김, 즉 세개를 맞추어 만들어 줌

kubectl delete pod replicaset-nginx-6frr9

kubectl delete -f replicaset.yml 로 레플리카셋 제거 가
```