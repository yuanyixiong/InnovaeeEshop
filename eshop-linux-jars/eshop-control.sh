#监控服务
#服务启动顺序：管理服务-->基础服务-->监控服务
start(){
    echo "start project..."

    #spring cloud 断路仪表
    echo "========================start eshop-turbine"
    echo ">>>>>>>>>>>>start eshop-turbine 11006"
    nohup java -jar eshop-turbine.jar >/dev/null 2>&1 &
    echo $! >> control-server.pid

    #spring cloud 链路追踪
    echo "========================start eshop-zipkin"
    echo ">>>>>>>>>>>>start eshop-zipkin 11001"
    nohup java -jar eshop-zipkin.jar >/dev/null 2>&1 &
    echo $! >> control-server.pid

    #spring cloud 路由网关
    echo "========================start eshop-zuul"
    echo ">>>>>>>>>>>>start eshop-zuul 10011"
    nohup java -jar eshop-zuul.jar >/dev/null 2>&1 &
    echo $! >> control-server.pid

    echo "start project end..."
}


stop(){
    echo "stop project..."
    for pid in $(<control-server.pid)
    do
        echo "kill -9 $pid"
        kill -9 $pid
        sleep 1
    done
    rm -rf control-server.pid
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
