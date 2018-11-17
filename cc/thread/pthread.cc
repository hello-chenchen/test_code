// #include <iostream>
// 必须的头文件
#include <pthread.h>
#include <unistd.h>
#include <stdio.h>
 
using namespace std;
 
#define NUM_THREADS 5

int _global_num = 0;
pthread_mutex_t mutex;

// 线程的运行函数
void* say_hello(void* args)
{
    pthread_mutex_lock(&mutex);
    _global_num += *((int*)args);
    printf("args: %d _global_num：%d origin _global_num: %d \n",
    *((int*)args), _global_num, _global_num - *((int*)args));
    pthread_mutex_unlock(&mutex);
    return 0;
}
 
int main()
{
    // 定义线程的 id 变量，多个变量使用数组
    pthread_t tids[NUM_THREADS];
    pthread_mutex_init(&mutex, NULL);

    // pthread_mutex_lock(&mutex);
    for(int i = 0; i < NUM_THREADS; ++i)
    {
        //参数依次是：创建的线程id，线程参数，调用的函数，传入的函数参数
        int ret = pthread_create(&tids[i], NULL, say_hello, &i);
        if (ret != 0)
        {
        // cout << "pthread_create error: error_code=" << ret << endl;
        }
    }
    // pthread_mutex_unlock(&mutex);


    //等各个线程退出后，进程才结束，否则进程强制结束了，线程可能还没反应过来；
    pthread_exit(NULL);
}