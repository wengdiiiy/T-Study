package wendy.problem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner scanner = new Scanner(new FileInputStream(new File("../test.txt")));
		
		System.out.println(scanner.nextInt());
	}
}
