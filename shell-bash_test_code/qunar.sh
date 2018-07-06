#如何统计所有日志文件(tomcat的accesslog)中，访问次数最多的10个IP，以及对应的次数
cat access_log | awk '{ print $1 }' | sort | uniq -c | sort -n -r | head -n 10