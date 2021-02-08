#!/bin/bash
export LANG=ko_KR.UTF-8
echo "Shutdown tomcat now...."
bash /usr/local/tomcat/bin/shutdown.sh
echo "tomcat is now terminated..."
sleep 10
if [ -z "`ps -eaf | grep java | grep /usr/local/tomcat/bin`" ]; then
        echo "Tomcat was terminated successfully."
else
        ps -eaf | grep java | grep /usr/local/tomcat/bin | awk '{print $2}' |
        while read PID
                do
                echo "Killing $PID... "
                kill -9 $PID
                echo "Tomcat is being shutdowned"
                done
fi

echo "tomcat restart now"
bash /usr/local/tomcat/bin/startup.sh
if [ -z "`ps -eaf | grep java | grep /usr/local/tomcat/bin`" ]; then
        echo "Error!!! Cannot start tomcat server."
else
        echo "Tomcat restart succcessfully. "
fi
echo "Job finished"