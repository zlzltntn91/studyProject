# Docker

```commandline
# sudo su - root
# history -c

# docker ps
# docker -v
# docker run
# docker run -it (iteractive, terminal)
# docker run -it ubuntu:14.04

도커 허브에서 가져온다..

# root@ip-172-31-44-157:~# docker images
REPOSITORY   TAG       IMAGE ID       CREATED        SIZE
centos       7         8652b9f0cb4c   3 months ago   204MB
ubuntu       14.04     df043b4f0cf1   5 months ago   197MB
```

## ubuntu
```commandline
root@ip-172-31-44-157:~# docker run -it ubuntu:14.04
Unable to find image 'ubuntu:14.04' locally
14.04: Pulling from library/ubuntu
2e6e20c8e2e6: Pull complete 
95201152d9ff: Pull complete 
5f63a3b65493: Pull complete 
Digest: sha256:63fce984528cec8714c365919882f8fb64c8a3edf23fdfa0b218a2756125456f
Status: Downloaded newer image for ubuntu:14.04
root@b4558b75e23b:/# 

root@b4558b75e23b:/# cat /etc/
Display all 130 possibilities? (y or n)
root@b4558b75e23b:/# cat /etc/*release
DISTRIB_ID=Ubuntu
DISTRIB_RELEASE=14.04
DISTRIB_CODENAME=trusty
DISTRIB_DESCRIPTION="Ubuntu 14.04.6 LTS"
NAME="Ubuntu"
VERSION="14.04.6 LTS, Trusty Tahr"
ID=ubuntu
ID_LIKE=debian
PRETTY_NAME="Ubuntu 14.04.6 LTS"
VERSION_ID="14.04"
HOME_URL="http://www.ubuntu.com/"
SUPPORT_URL="http://help.ubuntu.com/"
BUG_REPORT_URL="http://bugs.launchpad.net/ubuntu/"
root@b4558b75e23b:/# 
```

## centos
```commandline
root@ip-172-31-44-157:~# docker run -it centos:7
[root@94e95df1d622 /]# cat /etc/*release*
CentOS Linux release 7.9.2009 (Core)
Derived from Red Hat Enterprise Linux 7.8 (Source)
NAME="CentOS Linux"
VERSION="7 (Core)"
ID="centos"
ID_LIKE="rhel fedora"
VERSION_ID="7"
PRETTY_NAME="CentOS Linux 7 (Core)"
ANSI_COLOR="0;31"
CPE_NAME="cpe:/o:centos:centos:7"
HOME_URL="https://www.centos.org/"
BUG_REPORT_URL="https://bugs.centos.org/"

CENTOS_MANTISBT_PROJECT="CentOS-7"
CENTOS_MANTISBT_PROJECT_VERSION="7"
REDHAT_SUPPORT_PRODUCT="centos"
REDHAT_SUPPORT_PRODUCT_VERSION="7"

CentOS Linux release 7.9.2009 (Core)
CentOS Linux release 7.9.2009 (Core)
cpe:/o:centos:centos:7
[root@94e95df1d622 /]#
```

# centos 컨테이너 만들기
```commandline
root@ip-172-31-44-157:~# docker create -it --name mycentos centos:7
583f34aa91ac36575d00f040be881e000da64de9067c0d075cec7f488a98de0e
root@ip-172-31-44-157:~# 
```

docker ps -a
docker start mycentos
history

docker run -it ubuntu:14.04 echo 'hello world'
docker run -it 컨테이너를 붙인다는 뜻
docker image ls 

```commandline
## 쉘이 아니고 echo 'hello world'를 실행했다
root@ip-172-31-44-157:~# docker ps -a
CONTAINER ID   IMAGE          COMMAND                CREATED          STATUS                            PORTS     NAMES
0336db450c0a   ubuntu:14.04   "echo 'hello world'"   6 seconds ago    Exited (0) 5 seconds ago                    magical_rhodes
583f34aa91ac   centos:7       "/bin/bash"            8 minutes ago    Exited (127) About a minute ago             mycentos
94e95df1d622   centos:7       "/bin/bash"            12 minutes ago   Exited (127) 10 minutes ago                 competent_goodall
b4558b75e23b   ubuntu:14.04   "/bin/bash"            15 minutes ago   Exited (0) 13 minutes ago                   condescending_hypatia

## 실행하고 바로 죽음
root@ip-172-31-44-157:~# docker ps -a

CONTAINER ID   IMAGE          COMMAND                CREATED              STATUS                          PORTS     NAMES
0336db450c0a   ubuntu:14.04   "echo 'hello world'"   About a minute ago   Exited (0) About a minute ago             magical_rhodes
583f34aa91ac   centos:7       "/bin/bash"            10 minutes ago       Exited (127) 2 minutes ago                mycentos
94e95df1d622   centos:7       "/bin/bash"            14 minutes ago       Exited (127) 12 minutes ago               competent_goodall
b4558b75e23b   ubuntu:14.04   "/bin/bash"            17 minutes ago       Exited (0) 15 minutes ago                 condescending_hypatia
```
	
```commandline
# docker rename mycentos renmaed
583f34aa91ac   centos:7       "/bin/bash"            11 minutes ago   Exited (127) 4 minutes ago              renamed

# root@ip-172-31-44-157:~# docker run -it --name mycentos centos:7
docker: Error response from daemon: Conflict. The container name "/mycentos" is already in use by container "583f34aa91ac36575d00f040be881e000da64de9067c0d075cec7f488a98de0e". You have to remove (or rename) that container to be able to reuse that name.
See 'docker run --help'.
```

docker rm mycentos 이미지 삭제
docker stop mycentos 실행 중지 
docker rm -f mycentos 실행 중지 없이 강제 삭제
docker container prune 지금 사용하지 않는 컨테이너를 전체 삭제
docker network prune 지금 사용하지 않는 네트워크를 전체 삭제

# 웹서버 돌리
ps aux

# docker run -it --name mywebserver -p 80:80 ubuntu:14.04
ubuntu18 -> ubuntu14 -> apache2 -> http://15.164.214.214/
ctrl pq

휘발성

# 저장
docker run -d --name wordpressdb_hostvolume -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=wordpress -v /home/wordpress_db:/var/lib/mysql mysql:5.7
