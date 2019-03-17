package course3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 创建一个日历表（按照格式输入日期,返回月份）
 * @author ywb
 *
 */
public class CalendarDemo {
	public static void main(String[] args) {
		System.out.println("请输入日期（格式：2018-11-11）");
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();
		try {
			Date d = df.parse(temp);//把字符串转换成日期格式
			calendar.setTime(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int day = calendar.get(Calendar.DATE);//获取输入时的天数
		calendar.set(Calendar.DATE, 1);//设置第一天
		
		int maxDate = calendar.getActualMaximum(Calendar.DATE);//获取月份对应的天数
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		System.out.println(day);
		for(int i = 0; i < calendar.get(Calendar.DAY_OF_WEEK)-1;i++){
			System.out.print("\t");
		}
		
		for(int i = 1; i <= maxDate; i++){
			if(i == day){
				System.out.print("*");
			}
			System.out.print(i+"\t");
			int w = calendar.get(Calendar.DAY_OF_WEEK);
			if(w == Calendar.SATURDAY){
				System.out.println("\n");
			}
			calendar.add(Calendar.DATE,1);
		}
		sc.close();
	}
}
