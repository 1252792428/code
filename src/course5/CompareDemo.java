package course5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparable和Comparator
 * @author ywb
 *
 */
public class CompareDemo {
	public static void main(String[] args) {
		Integer i1 = 16;
		Integer i2 = 20;
		System.out.println(i2.compareTo(i1));
		
		
		String str1 = "abc";
		String str2 = "abcde";
		System.out.println(str2.compareTo(str1));//返回长度值差2
		
		str1 = "abc";
		str2 = "ab9";
		System.out.println(str2.compareTo(str1));//返回abc与ab9的unicode码之差为-42
		
		str1 = "abc";
		str2 = "bd";
		System.out.println(str2.compareTo(str1));//返回ab与ad的unicode码之差为2
		
		String[] arr = {"aaa","aac","aab","aa1"};
		String[] arr2 = {"a","aac","aabasd","aa111"};
		sort1(arr);
		sort2(arr2 , new abc());
	}

	public static<T extends Comparable<T>> void sort1(T[] arr){
		boolean isSort = true;
		for(int i = 0; i<arr.length-1; i++){
			isSort = true;
			for(int j = 0; j<arr.length-i-1;j++){
				if(arr[j].compareTo(arr[j+1]) > 0){
					T temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					isSort = false;
				}
			}
			if(isSort){
				break;
			}
		}
		System.out.println("compareTo的默认排序方式排序后"+Arrays.toString(arr));
	}
	
	public static<T extends Comparable<T>> void sort2(T[] arr,Comparator com){
		boolean isSort = true;
		for(int i = 0; i<arr.length-1; i++){
			isSort = true;
			for(int j = 0; j<arr.length-i-1;j++){
				if(com.compare(arr[j],arr[j+1]) > 0){
					T temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					isSort = false;
				}
			}
			if(isSort){
				break;
			}
		}
		System.out.println("根据长度排序"+Arrays.toString(arr));
	}
}
class abc implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {//根据长度排序
		int len1 = o1.length();
		int len2 = o2.length();
		if(len1 > len2){
			return 1;
		}
		if(len1 < len2){
			return -1;
		}
		return 0;
	}
	
}
