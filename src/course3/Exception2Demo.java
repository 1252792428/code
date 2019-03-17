package course3;

public class Exception2Demo {
	static class Annoyance extends Exception {
		
	}

	static class Sneeze extends Annoyance {
	}

	static class Human {
		public static void main(String[] args) throws Exception {
			try {
				try {
					throw new Sneeze();//1.这里抛出Sneeze异常
				} catch (Annoyance a) {//2.可以用其父类接收
					System.out.println("Caught Annoyance");//3.打印
					throw a;//4.抛出异常,其后面的代码不会执行
					//return;
				}
			} catch (Sneeze s) {//注意，这里捕获的是1抛出的异常
				System.out.println("Caught Sneeze");
				return;
			}
			finally {
				System.out.println("Hello World!");
			}
		}
	}

}
