package wendy.algorithm;

public class test {
	public static void main(String[] args) {
		String str1 = "Hello World";
		String str2 = "Hello World";
		String str3 = new String("Hello World");

		System.out.println("1¹ø : " + str1 == str2);
		System.out.println("2¹ø : " + str1 == str3);
		System.out.println("3¹ø : " + str1.equals(str3));
	}

}
