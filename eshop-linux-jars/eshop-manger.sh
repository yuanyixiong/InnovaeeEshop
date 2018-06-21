start(){
    echo "start project..."

    #spring cloud 注册中心
    echo "========================start eshop-eureka"
    echo ">>>>>>>>>>>>>start eshop-eureka 9001"
    nohup java -jar eshop-eureka.jar --spring.profiles.active=9001 >/dev/null 2>&1 &
    echo $! >> manager-server.pid

    echo ">>>>>>>>>>>>start eshop-eureka 9002"
    nohup java -jar eshop-eureka.jar --spring.profiles.active=9002 >/dev/null 2>&1 &
    echo $! >> manager-server.pid

    #spring cloud 配置中心
    echo "========================start eshop-config"
    echo ">>>>>>>>>>>>start eshop-config 10001"
    nohup java -jar eshop-config.jar >/dev/null 2>&1 &
    echo $! >> manager-server.pid

    echo "start project end..."
}


stop(){
    echo "stop project..."
    for pid in $(<manager-server.pid)
    do
        echo "kill -9 $pid"
        kill -9 $pid
        sleep 1
    done
    rm -rf manager-server.pid
    echo "stop project end..."
}


restart(){
    stop
    sleep 1
    start
}

echo "User Command: {start|stop|restart}"  
case $1 in
    start)
    start
    ;;
    stop)
    stop
    ;;
    restart)
    restart
    ;;
    *)  echo 'You do not select a Command {start|stop|restart}'
    ;;
esac
exit 1
