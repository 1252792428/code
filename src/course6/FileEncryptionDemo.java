package course6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * 文件拷贝后加密和解密
 * @author ywb
 *
 */
public class FileEncryptionDemo {
	public static int stringToUnicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);  // 取出每一个字符
            unicode.append(Integer.toHexString(c));// 转换为unicode
        }
        String str = unicode.toString();//将StringBuffer转成String
        int x = Integer.parseInt(str);//转成整型
        return x;
	   }
	public static void main(String[] args) throws Exception {
		fileCopyAndEncryption();//文件复制并加密
		fileCopyAndDecrypt();//文件复制并解密
	}
	
	public static void fileCopyAndEncryption() throws Exception{//文件复制并加密
		FileInputStream in = null;
		FileOutputStream out = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请设置密码");
		String str1 = scanner.nextLine();
		int x = stringToUnicode(str1);//将输入的字符串以unicode码赋给int类型的x
		try {
			in = new FileInputStream("E:/eclipse/workspace/java_study/aaa/a.txt");
			out = new FileOutputStream("E:/eclipse/workspace/java_study/aaa/copy1.txt");
			int len;
			while((len = in.read()) != -1){
				out.write(len^x);//在这里异或一个数(一个数异或两次等于原来的数)
			}
		}//文件复制并加密，文件复制并解密
		finally{
			try{
				if(out != null){
					out.close();
				}
			}
			finally{
				if(in != null){
					in.close();
				}
			}
		}
		scanner.close();
	}
	public static void fileCopyAndDecrypt() throws Exception{//文件复制并解密
		FileInputStream in = null;
		FileOutputStream out = null;
		System.out.println("请输入密码");
		while(true){
			Scanner scanner = new Scanner(System.in);
			 String str1 = scanner.nextLine();
			 if(str1.equals("abc1")){//注意   ==号是比较内存地址
					int x = stringToUnicode(str1);
					try {
						in = new FileInputStream("E:/eclipse/workspace/java_study/aaa/copy1.txt");
						out = new FileOutputStream("E:/eclipse/workspace/java_study/aaa/copy2.txt");
						int len;
						while((len = in.read()) != -1){
							out.write(len^x);//在这里异或一个数(一个数异或两次等于原来的数)
						}
						System.out.println("密码正确");
					}
					finally{
						try{
							if(out != null){
								out.close();
							}
						}
						finally{
							if(in != null){
								in.close();
							}
						}
					}
					break;//退出循环
				}
				 else{
					 System.out.println("密码错误，请重新输入");
				 }
			 scanner.close();
		}
		
		
		
		
	}
}
