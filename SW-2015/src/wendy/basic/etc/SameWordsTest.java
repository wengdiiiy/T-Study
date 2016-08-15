package wendy.basic.etc;
//package wendy.basic;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//import java.util.Set;
//
//import org.junit.Before;
//import org.junit.Test;
//
//
//public class SameWordsTest {
//	private SameWords sut;
//	
//	@Before
//	public void setUp() {
//		sut = new SameWords();
//	}
//	
//	@Test
//	public void testGetDividedWords() throws Exception {
//		String inputStr = "cfabdabc";
//		
//		List<String> result = sut.getDividedWords(inputStr, 2);
//		
//		for (String partWord : result) {
//			System.out.println(partWord);
//		}
//	}
//	
//	@Test
//	public void testFindSameWords() throws Exception {
//		String inputStr = "abcdefgddddd";
//		String inputStr2 = "cfabdabc";
//		
//		Set<String> result = sut.findSameWord(inputStr, inputStr2);
//		
//		for (String sameWord : result) {
//			System.out.println(sameWord);
//		}
//	}
//	
//	@Test
//	public void testFindSameWordsReverseInput() throws Exception {
//		String inputStr = "abcdefgddddd";
//		String inputStr2 = "cfabdabc";
//		
//		Set<String> result = sut.findSameWord(inputStr2, inputStr);
//		
//		for (String sameWord : result) {
//			System.out.println(sameWord);
//		}
//	}
//}
