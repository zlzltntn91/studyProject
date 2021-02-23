# Maven 설치 방법
### /etc/profile
```commandline
export CATALINA_HOME=/usr/local/apache-tomcat-8.5.63
export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.282.b08-1.el7_9.x86_64/jre
export PATH=$PATH:$JAVA_HOME/bin
export CLASSPATH=:$JAVA_HOME/lib/tools.jar
```

### ~/.bash_profile
```commandline

PATH=$PATH:$HOME/bin:/usr/lib/apache-maven-3.3.9/bin
```
### 설치확인
```commandline
# mvn -v

Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-11T01:41:47+09:00)
Maven home: /usr/lib/apache-maven-3.3.9
Java version: 1.8.0_282, vendor: Red Hat, Inc.
Java home: /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.282.b08-1.el7_9.x86_64/jre
Default locale: ko_KR, platform encoding: UTF-8
OS name: "linux", version: "3.10.0-1160.15.2.el7.x86_64", arch: "amd64", family: "unix"
```
