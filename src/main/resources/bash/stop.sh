pid=`ps -ef | grep tyrael-coupon.jar | grep -v grep | awk '{print $2}'`
if [[ -z "${pid}" ]]
then
  echo application iis already stopped
else
  echo kill ${pid}
  kill -9 ${pid}
fi
