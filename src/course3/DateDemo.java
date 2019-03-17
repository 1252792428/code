package course3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试时间类的用法
 * @author ywb
 *
 */
public class DateDemo {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.toLocaleString());
		Date date2 = new Date(123);//传入数字的话返回的是1970年的日期
		System.out.println(date2);
		
		DateFormat df = new SimpleDateFormat("yyyy年-MM月-dd hh:mm:ss");//设置日期格式
		Date d = new Date();
		String str = df.format(d);
		System.out.println(str);
		
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parse = df2.parse("2018-11-11");
			System.out.println(parse.toLocaleString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
