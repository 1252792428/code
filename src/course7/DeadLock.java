package course7;

public class DeadLock{
	
    private static Object o1 = new Object(), o2 = new Object();//用作锁的两个对象
    public static void main(String[] args)
    {
        new Thread(() -> {//lambda表达式
            System.out.println("线程1开始执行");
            synchronized (o1){
                try{
                    System.out.println("线程1拿到A锁");
                    Thread.sleep(1000);//线程休眠，让线程2有机会执行
                }catch(Exception e){
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("线程1拿到B锁执行完毕");
                }
            }
        }).start();
        new Thread(() -> {
            System.out.println("线程2开始执行");
            synchronized (o2){
                try{
                    System.out.println("线程2拿到B锁");
                    Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("线程2拿到A锁执行完毕");
                }
            }
        }).start();
        
    }
}
