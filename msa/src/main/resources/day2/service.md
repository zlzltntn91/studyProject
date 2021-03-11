# Service

서비스는 디플로이나 레플리카셋 팟처럼 상위 개념이 아님

서비스는 그냥 항상 돌아가고 있음

- 외부의 연결을 위해 서비스를 정의하고


붙였다, 떼었다 할 수 있음, 뗏다가 다른데 붙이기 가능
  
```yaml
# service.yml
# 웹서버와 노드포트를 연결한다

apiVersion: v1
kind: Service # Service type
metadata: 
  name: hostname-svc-nodeport # 서비스 이름
spec:
  ports:
  - name: web-port
    port: 8080 # 포트는 8080
    targetPort: 80
  selector:
    app: webserver
  type: NodePort 
    # 포트 타입은 세가지가 있음
    # 노드밸런스, 노드포트, 클러스트아이피

```

쿠버네티스 서비스는 클러스트아이피 타입으로 돌아가며 끄면 안된다.
32750번 포트는 외부에 노출되는 포트

노드포트란 모든노드에 같은 포트로 접근 가능 외부접근에 필요
직접 쿠버네이트 클러스터를 구축했기때문에 지금은 로드벨런서를 사용할 수 없음
