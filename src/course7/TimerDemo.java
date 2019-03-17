package course7;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 计时器
 * @author ywb
 *
 */
public class TimerDemo {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		Timer t = new Timer();
		t.schedule(new Clock1(), new Date(117, 12, 5, 12, 40 ,20));//设置任务的启动时间(超过该时间也会启动)
		
		t.schedule(new Clock2(), new Date(117, 12, 5, 12, 40 ,20),5000);//每5秒执行一次
		while(true){
			Thread.sleep(1000);
			System.out.println(new Date());
		}
	}
}

class Clock1 extends TimerTask{
	@Override
	public void run() {
		System.out.println("8点钟了，起床上班了");
	}
	
}
class Clock2 extends TimerTask{
	@Override
	public void run() {
		System.out.println("这是个重复闹钟，不起床就一直响哦");
	}
	
}
