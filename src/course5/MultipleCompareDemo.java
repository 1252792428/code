package course5;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 根据多个条件排序
 * @author ywb
 *
 */
public class MultipleCompareDemo implements Comparable<MultipleCompareDemo>{
	private String title;//标题
	private int hits;//点击数
	private Date time;//时间
	
	public MultipleCompareDemo() {
		super();
	}
	
	public MultipleCompareDemo(String title, int hits, Date time) {
		super();
		this.title = title;
		this.hits = hits;
		this.time = time;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("标题-").append(this.title);
		sb.append("点击量-").append(this.hits);
		sb.append("时间-").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.time)).append("\n");
		return sb.toString();
	}

	
	@Override
	public int compareTo(MultipleCompareDemo o) {
		int result = 0;
		result = this.time.compareTo(o.time);//先按时间排
		if(result == 0){
			result = this.hits - o.hits;//再按点击量排
			if(0 == result){
				result = this.title.compareTo(o.title);//再按名称排
			}
		};
		return result;
	}
	
	
	public static void main(String[] args) {
		List<MultipleCompareDemo> list = new ArrayList<MultipleCompareDemo>();
		list.add(new MultipleCompareDemo("标题111",100,new Date()));
		list.add(new MultipleCompareDemo("标题222",99,new Date()));
		list.add(new MultipleCompareDemo("标题111",99,new Date(System.currentTimeMillis()-1000*60*60)));
		list.add(new MultipleCompareDemo("标题222",100,new Date(System.currentTimeMillis()+1000*60*60)));
		list.add(new MultipleCompareDemo("标题333",100,new Date(System.currentTimeMillis()+1000*60*60)));
		
		Collections.sort(list);//Collections里的sort方法继承Comparable接口，因此重写的compareTo方法会被调用
		System.out.println(list);
	}
}
