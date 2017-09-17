package com.company.MutilThread;

/**
 * Created by CC on 2017/3/5.
 * 多线程学习,注意线程与进程的区别
 */
public class Thread1 extends Thread {
    String name ;
    public Thread1(String name){
        this.name = name;
    }
    @Override
    public void run(){
        int i =5;
        while(i-->0) {
            try{

                sleep((int) (Math.random() * 10));
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ":" + i);
//        System.out.println(name+":"+(int)(new Random().nextInt(10))); //同样效果
        }
    }

    public static void main(String[] args) {
        new Thread1("A").start();
        new Thread1("B").start();//ctr+q查看方法注释
    }
}
