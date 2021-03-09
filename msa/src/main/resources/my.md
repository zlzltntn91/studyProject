

도서 : 시작하세요 도커/쿠버네티스
센토스는 정책이 이상해져서 안쓴다?

```commandline

ssh -i /Users/soo/Documents/important/kosa-msa-keypair.pem ubuntu@ec2-15-164-214-214.ap-northeast-2.compute.amazonaws.com
sudo su
su (Switch User) 혹은 sudo (SuperUser DO)
```


```리눅스 (Linux)에서 특정 명령을 실행하거나, 특정 파일에 접근하기 위해서
때로는 루트 (root) 권한이 필요한 경우가 있습니다.
이러한 경우에 사용하게 되는 su / su - / sudo 명령어들과 각 명령어들의 차이점,
현재 계정을 확인하는 whoami 명렁어와
계정 전환 후 다시 이전 계정으로 돌아가게 하는 logout / exit 명령어들에 관한 내용입니다.

우선, 일반 사용자 (user)가 루트 (root) 권한을 사용하기 위해서는 
su (Switch User) 혹은 sudo (SuperUser DO) 명령어를 사용하면 됩니다.

1. su (Switch User) 명령어
- Switch User에서 알 수 있듯이, 현재 계정을 로그아웃하지 않고 다른 계정으로 전환하는 명령어 입니다.
su 명령어 예제
su root

su - root
su 명령어 사용 시 옵션
     -c : 쉘을 실행하지 않고, 주어진 명령만을 수행합니다.
     -s : 지정된 셀로 로그인합니다.
     -, -l : 지정한 사용자의 환경 변수를 적용하여 로그인합니다.su 명령어를 실행하게 되면 root 사용자의 비밀번호를 물어봅니다.
여기서 '-' 의 유무의 차이가 있습니다.
su 와 su - 는 둘 다 루트 (root) 계정으로 전환하는 것을 의미하지만,
su는 root 계정의 환경 변수를 가져오지 않고, 현재 계정의 환경 변수를 사용하게 되는 차이점이 있습니다.
su - 하시고 로그인을 하게 되면 기본 /root 디렉토리(directory)로 이동하게 됩니다. (환경 변수를 가져온다는 의미이겠지요.)2. sudo (SuperUser DO) 명령어
- 이 역시 SuperUser DO 에서 알 수 있듯이, 
슈퍼 유저로 무언가를 수행한다는 의미를 가지고 있는 명령어 입니다.
현재 계정에서 단순히 root 의 권한 만을 빌리는 것입니다.
sudo 명령어 예제
sudo [command]
sudo 명렁어를 실행하게 되면 root 권한으로 명령어를 실행하게 됩니다.
즉, 하나의 명령에 대하여 일시적으로 root 권한을 사용하는 것을 말합니다.
실행하기 전 현재 사용자의 비밀번호를 물어봅니다.3. su 와 sudo 의 차이점
su는 계정을 전환하기 위한 것이고,
sudo는 권한을 빌려 명령어를 실행하기 위한 것입니다.

아래는 su 명령어와 관련하여 계정의 전환 확인과 이전 계정으로 돌아가는 명령어입니다.
4. whoami
- 현재 사용자를 확인하는 명령어 입니다.
(su 명령어를 통해 사용자를 전환하고 혹은 logout / exit로 다시 돌아오기를 하며 확인해보세요.)
5. logout / exit
- 전환 전 계정으로 돌아가는 명령어 입니다.
```