package course1;
/**
 * 转义符
 * @author ywb
 *
 */
public class TransformSignDemo {
	public static void main(String[] args) {
		System.out.println("abc"+"\b"+"efg");
		System.out.println("abc"+"\r"+"efg");
		//System.out.println("abcdefg"+");
		//System.out.println("abcdefg"+""");如上，不不使用转义符就会报错
		System.out.println("abcdefg"+"\"");
		System.out.println("abcdefg"+"\'");
		System.out.println("abcdefg"+"\\");
	}
}
