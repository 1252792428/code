package course1;
import java.math.BigDecimal;
/**
 * 数据类型
 * @author ywb
 *
 */
public class DateTypeDemo {
	public static void main(String[] args) {
		float f = 0.1f;
		double d = 0.1;
		if(f==d){
			System.out.println("两个数相等");
		}else{
			System.out.println("两个数不相等");
		}
		
		BigDecimal bd = BigDecimal.valueOf(1.0);
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		System.out.println(bd);//0.5  用BigDecimal连减后还是精确的
		
		System.out.println(1.0-0.1-0.1-0.1-0.1-0.1);//0.5000000000000001  不精确
		
		char c = 'a';//使用单引号
		System.out.println(c);
		System.out.println((int)c);//a对应的字符码是97
		System.out.println(1+c);
	}
}
