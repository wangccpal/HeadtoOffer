package multiThread;

/**
 * Created by CC on 2017/3/5.
 */
public class Thread2 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        int k =10;
        while ( k-->0){
        new Thread(""+k){
            @Override
            public void run() {
//                System.out.println("Thread: "+getName()+"is running");
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        }

//        for(int i=0; i<10; i++){
//            new Thread("" + i){
//                public void run(){
//                    System.out.println("Thread: " + getName() + "running");
//                }
//            }.start();
//        }
    }
}
