package course5;

import java.util.Arrays;

/**
 * 实现冒泡排序(依次比较相邻两个数的排序)
 * @author ywb
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {1,7,8,5,9,6,2,3,4};
		sort3(arr);
	}
	
	/**
	 * 冒泡排序一，非优化版
	 * @param arr
	 */
	public static void sort1(int[] arr){
		for(int i = 0; i<arr.length-1; i++){
			for(int j = 0; j<arr.length-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		//System.out.println(arr.toString());//这里的toString返回的是哈希码
		//数组的打印应该选择Arrays.toString(arr);
		System.out.println(Arrays.toString(arr));
	}
	/**
	 * 冒泡排序二，优化版
	 * @param arr
	 */
	public static void sort2(int[] arr){
		for(int i = 0; i<arr.length-1; i++){
			for(int j = 0; j<arr.length-i-1;j++){//与方案一的区别（减少了循环的次数）
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	/**
	 * 冒泡排序3,最终版（考虑了到某次一次交换顺序的情况都没发生的时候，不需要排序了，直接跳出循环）
	 * @param arr
	 */
	public static void sort3(int[] arr){
		boolean isSort = true;
		for(int i = 0; i<arr.length-1; i++){
			isSort = true;
			for(int j = 0; j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					isSort = false;
				}
			}		System.out.println(Arrays.toString(arr));
			if(isSort){
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
