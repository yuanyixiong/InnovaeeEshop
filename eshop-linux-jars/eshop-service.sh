#基础服务
#服务启动顺序：管理服务-->基础服务-->监控服务
start(){
    echo "start project..."

    #spring cloud [产品资源]服务
    echo "========================start service-product"
    echo ">>>>>>>>>>>>start service-product 10031"
    nohup java -jar service-product.jar --spring.profiles.active=10031 >/dev/null 2>&1 &
    echo $! >> service-server.pid

    echo ">>>>>>>>>>>>start service-product 10032"
    nohup java -jar service-product.jar --spring.profiles.active=10032 >/dev/null 2>&1 &
    echo $! >> service-server.pid

    #spring cloud [菜单资源]服务
    echo "========================start service-resource"
    echo ">>>>>>>>>>>>start service-resource 10033"
    nohup java -jar service-resource.jar --spring.profiles.active=10033 >/dev/null 2>&1 &
    echo $! >> service-server.pid

    echo ">>>>>>>>>>>>start service-resource 10034"
    nohup java -jar service-resource.jar --spring.profiles.active=10034 >/dev/null 2>&1 &
    echo $! >> service-server.pid

    #spring cloud [广告轮播图]服务
    echo "========================start service-slideshow"
    echo ">>>>>>>>>>>>start service-slideshow 10035"
    nohup java -jar service-slideshow.jar --spring.profiles.active=10035 >/dev/null 2>&1 &
    echo $! >> service-server.pid

    echo ">>>>>>>>>>>>start service-slideshow 10036"
    nohup java -jar service-slideshow.jar --spring.profiles.active=10036 >/dev/null 2>&1 &
    echo $! >> service-server.pid

    #spring cloud [产品类型]服务
    echo "========================start service-type"
    echo ">>>>>>>>>>>>start service-type 10037"
    nohup java -jar service-type.jar --spring.profiles.active=10037 >/dev/null 2>&1 &
    echo $! >> service-server.pid

    echo ">>>>>>>>>>>>start service-type 10038"
    nohup java -jar service-type.jar --spring.profiles.active=10038 >/dev/null 2>&1 &
    echo $! >> service-server.pid

    #spring cloud [首页]
    echo "========================start service-home"
    echo ">>>>>>>>>>>>start service-home 10020"
    nohup java -jar service-home.jar --spring.profiles.active=10020 >/dev/null 2>&1 &
    echo $! >> service-server.pid

    echo ">>>>>>>>>>>>start service-home 10021"
    nohup java -jar service-home.jar --spring.profiles.active=10021 >/dev/null 2>&1 &
    echo $! >> service-server.pid

    echo ">>>>>>>>>>>>start service-home 10022"
    nohup java -jar service-home.jar --spring.profiles.active=10022 >/dev/null 2>&1 &
    echo $! >> service-server.pid

    echo "start project end..."
}


stop(){
    echo "stop project..."
    for pid in $(<service-server.pid)
    do
        echo "kill -9 $pid"
        kill -9 $pid
        sleep 1
    done
    rm -rf service-server.pid
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
