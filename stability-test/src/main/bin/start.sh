#!/bin/sh

if [ -f $(dirname $0)/../../env.sh ]; then
    source $(dirname $0)/../../env.sh
fi

case "`uname`" in
    Linux)
		bin_abs_path=$(readlink -f $(dirname $0))
		;;
	*)
		bin_abs_path=`cd $(dirname $0); pwd`
		;;
esac
base=${bin_abs_path}/..

appName=restlight-demo

get_pid() {
        STR=$1
        PID=$2
        if [ ! -z "$PID" ]; then
                JAVA_PID=`ps -C java -f --width 1000|grep "$STR"|grep "$PID"|grep -v grep|awk '{print $2}'`
            else 
                JAVA_PID=`ps -C java -f --width 1000|grep "$STR"|grep -v grep|awk '{print $2}'`
        fi
    echo $JAVA_PID;
}

pid=`get_pid "appName=${appName}"`
if [ ! "$pid" = "" ]; then
	echo "${appName} is running."
	exit -1;
fi

if [ "$1" = "debug" ]; then
	DEBUG_PORT=$2
	DEBUG_SUSPEND="n"
	JAVA_DEBUG_OPT="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=$DEBUG_PORT,server=y,suspend=$DEBUG_SUSPEND"
fi

JAVA_OPTS="-Djava.io.tmpdir=$base/tmp -DappName=${appName} -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true -Dfile.encoding=UTF-8 -Djava.security.egd=file:/dev/./urandom"
JAVA_OPTS_MEM="-server -Xms3072m -Xmx3072m -XX:NewSize=1024m -XX:MaxNewSize=1024m -XX:PermSize=256m -XX:MaxPermSize=196m "
JAVA_OPTS_CMS="-XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=75 -XX:+UseCMSInitiatingOccupancyOnly"
JAVA_OPTS_GC="-XX:+PrintTenuringDistribution -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:logs/gc-${appName}.log"

cd $base
if [ ! -d "logs" ]; then
  mkdir logs
fi
java  $JAVA_OPTS $JAVA_OPTS_MEM $JAVA_OPTS_CMS $JAVA_OPTS_GC $JAVA_DEBUG_OPT -classpath 'lib/*:conf' demo.RestlightDemoApplication 1>>logs/server.log 2>&1 &

echo $! > $base/server.pid

echo OK!`cat $base/server.pid`
 
