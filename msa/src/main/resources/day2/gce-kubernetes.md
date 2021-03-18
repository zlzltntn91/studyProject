km1, kw1, kw2 : kubernetes master 1, worker 1, 2
Debian 9로 VM 생성, E2의 2C/2G 사양을 선택. asia-northeast-3a 리전
1노드만으로도 작동하나 마스터(km1)과 워커(kw1) 각 하나씩은 생성

어플리케이션은 마스터에 설치할 수 없음
```
(모든 노드에서 작업)
# swapoff -a

# curl -s https://packages.cloud.google.com/apt/doc/apt-key.gpg | apt-key add -

# cat <<EOF > /etc/apt/sources.list.d/kubernetes.list
> deb http://apt.kubernetes.io/ kubernetes-xenial main
> EOF

# apt-get install apt-transport-https ca-certificates wget -y

도커 자동설치 스크립트
# wget -qO- get.docker.com | sh 

도커 설치 확인
# docker ps

# apt-get install -y kubelet kubeadm kubectl kubernetes-cni

(마스터 노드에서 작업)
# ifconfig

쿠버네티스 클러스터 초기화 
--pod-network-cidr : 마스터, 워커 총 3대를 192.168.0.XX 로 시작하는 주소로 설정
쿠버네티스는 모든 이미지를 컨테이너로 돌린다
# kubeadm init --apiserver-advertise-address <eth0의 주소> --pod-network-cidr=192.168.0.0/16

# mkdir -p $HOME/.kube

# sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config

# sudo chown $(id -u):$(id -g) $HOME/.kube/config
 
마지막에 나온 kubeadm join~ 으로 시작하는 코맨드를 복사해서 워커들에서 동일하게 실행

모든 노드들이 정상적으로 join되었는지 확인
# kubectl get nodes

쿠버네티스 네트워크 인터페이스 플러그인을 설치해야 작동함
가장 많이 사용하는 것은 켈리퍼?, 플라넬, 위브넷. 네이티브에 근접한 성능이 나옴

플라넬 설치 (yml, yaml)
# wget https://raw.githubusercontent.com/coreos/flannel/master/Documentation/kube-flannel.yml

Network: 부분을 192.168.0.0/16으로 변경하고 저장, net-conf.json : {} 에 있음 pod 초기화에서 설정한 ip로 지정 
# pico kube-flannel.yml

# kubectl apply -f kube-flannel.yml

모든 네임스페이스의 팟을 다 조회함 (쿠버네티스의 가장 기본 단위는 팟)
core-dns가 두개 모두 Running 상태가 되는지 확인
# kubectl get pods --all-namespace
# kubectl get nodes

# mkdir /work
# cd /work
# pico nginx-pod.yml

apiVersion: v1
kind: Pod
metadata:
  name: my-nginx-pod
spec:
  containers:
  - name: my-nginx-container
    image: nginx:latest
    ports:
    - containerPort: 80
      protocol: TCP

# kubectl apply -f nginx-pod.yml

default pod 조회
# kubectl get pods

출력된 ip를 확인
# kubectl get pods -o wide
or 
# kubectl describe pod my-nginx-pod

접속이 확인되면 정상 설치 완료
# curl <my-nginx-pod의 ip>
```