package multiThread;

/**
 * Created by CC on 2017/3/5.
 */
public class ThreadImpRun implements Runnable{
    String name ;
    public ThreadImpRun(String name){
        this.name = name;
    }
    @Override
    public void run() {
        int i =5;
        while(i-->0) {
            try{

                Thread.sleep((int) (Math.random() * 10));//主要的区别在这儿，因为它是实现了thread而没有继承，所以不能直接用
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
