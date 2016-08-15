package wendy.basic.fileInput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class EncryptionTest {
	public static void main(String[] args){
		try{
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("/Users/anjeongmin/Documents/Study/T-Study/SW-2015/src/wendy/basic/fileInput/encryptionTest.txt"),"UTF8"));
			
			
		}catch(Exception e){
			System.err.println(e);
			System.exit(1);
		}
	}
}
