package aircraft_game;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 飞机游戏
 * @author ywb
 *
 */
public class AircraftGame extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {//解决窗口闪烁问题
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(500,500);//这是游戏窗口的宽度和高度
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}  
	Image planeImg = GameUtil.getImage("images/plane.jpg");
	Image backImg = GameUtil.getImage("images/bg.jpg");
	public void launchFrame(){
		this.setTitle("打灰机");
		this.setVisible(true);
		this.setSize(500,500);
		this.setLocation(300,300);
		
		this.addWindowListener(new WindowAdapter() {//窗口监听
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//点击关闭按钮时，正常关闭窗口
			}
		});
		PaintThread pt = new PaintThread();
		pt.start();//启动重画窗口的线程
		addKeyListener(new KeyMonitor());//增加键盘的监听 
	}

	Plane plane = new Plane(planeImg,235,400, 10);
	Shell shell = new Shell();
	@Override
	public void paint(Graphics g){
		super.paint(g);//必须要再执行一次
		//Color c = g.getColor();//保存初始颜色
		//g.setColor(Color.BLUE);//修改颜色
		//g.drawLine(100, 100, 300, 300);//画一条线
		//g.drawRect(100, 100, 300, 300);//画矩形
		//g.drawOval(100, 100, 300, 300);//画圆
		//g.drawString("123",100,100);//写入字符串
		g.drawImage(backImg, 0, 0, null);//画背景图
		plane.drawMySelf(g);
		shell.draw(g);
		//g.setColor(c);//恢复初始颜色
		boolean peng = shell.getRect().intersects(plane.getRect());//判断飞机和子弹是否相交
		if(peng){
			plane.live = false;//飞机死掉
		}
	}
	
	public static void main(String[] args) {
		AircraftGame ag = new AircraftGame();
		ag.launchFrame();
	}
	class PaintThread extends Thread{//内部类
		@Override
		public void run(){
			while(true){
				System.out.println("1");
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	class KeyMonitor extends KeyAdapter{//定义键盘监听内部类
		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
		
		
	}
}
