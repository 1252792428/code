package aircraft_game;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {
	private GameUtil(){//工具类最好将构造器私有化
		
	}
	/**
	 * 返回指定路径文件的图片
	 * @param path
	 * @return
	 */
	public static Image getImage(String path){
		BufferedImage bi = null;
		try {
			URL u = GameUtil.class.getClassLoader().getResource(path);
			//必须是src下的目录吗？不是的话会报错
			bi = ImageIO.read(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bi;
	}
}
