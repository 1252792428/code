package ball_game;
import java.awt.*;
import javax.swing.*;
/**
 * 一个在图片上运动的方块
 * @author ywb
 *
 */
public class BallGame2 extends JFrame{
	Image background1 = Toolkit.getDefaultToolkit().getImage("images/1.png");
	Image background2 = Toolkit.getDefaultToolkit().getImage("images/2.jpg");
	Image point = Toolkit.getDefaultToolkit().getImage("images/3.jpg");
	
	double x=100.0 ;//设置初始位置
	double y=100.0 ;
	double degree = 3.14/3;
	
	@Override
	public void paint(Graphics graphic){//方法重载（注意，窗口打开和每次窗口改变都会执行此方法）
		//这里会出现懒加载？窗口界面第一次出现的时候并没有显示图片，但是这句话打印了。
		//必须要最小化窗口界面后再次打开，图片才会在窗口中显示(或者改变一下窗口大小)
		graphic.drawImage(background2, 0, 0, null);//先画桌面再画球，那么球在上层
		graphic.drawImage(point,(int)x,(int)y,null);
		System.out.println("窗口中的内容画了一次");
		x = x + 10*Math.cos(degree);
		y = y + 10*Math.sin(degree);
		if(y>540 || y<30){
			degree = -degree;
		}
		if(x>800 || x<0){
			degree = 3.14-degree;
		}
	}
	public void setFrame(){//第一次打开窗口的时候执行
		setSize(800,600);//设置窗口大小
		setLocation(500, 50);//设置窗口位置
		setVisible(true);
		System.out.println("窗口出现了");
		
		//重画窗口（每秒画20次）
		while(true){
			repaint();
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		BallGame2 game = new BallGame2();
		game.setFrame();
		
	}
}
