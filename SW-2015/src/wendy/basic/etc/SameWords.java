package wendy.basic.etc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SameWords {
	public Set<String> findSameWord(String inputStr, String inputStr2) {
		String pivotStr = inputStr;
		String compareStr = inputStr2;
		
		List<String> partWords = new ArrayList<String>();
		
		for (int divideNumber = 2; true; divideNumber++) {
			List<String> words = getDividedWords(pivotStr, divideNumber);
			
			if (words.isEmpty()) {
				break;
			}
			
			partWords.addAll(words);
		}
		
		Set<String> sameWords = new HashSet<String>();
		for (String partWord : partWords) {
			if (compareStr.contains(partWord)) {
				sameWords.add(partWord);
			}
		}
		
		return sameWords;
	}
	
	public List<String> getDividedWords(String word, int endIndex) {
		List<String> words = new ArrayList<String>();
		
		int maxIndex = word.length();
		for (int i = 0; i < maxIndex; i++, endIndex++) {
			// 현재 나눈 문자열의 끝이 최대 길이보다 클 경우 중지
			if (endIndex <= maxIndex) {
				String partWord = word.substring(i, endIndex);
				words.add(partWord);
			}
			
		}
		
		return words;
	}
	

}