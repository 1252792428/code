package json.study;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Example {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("zs","18");
		map.put("ls","20");
		JSONObject json = new JSONObject(map);
		System.out.println(json);
	}
}
