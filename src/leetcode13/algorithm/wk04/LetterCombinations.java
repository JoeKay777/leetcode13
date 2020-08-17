package leetcode13.algorithm.wk04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 
 * @author qkh
 *
 */
public class LetterCombinations {
	Map<Character, List<String>> letterMap = new HashMap<>(8);
	List<Character> digitsList = new ArrayList<>();
	public List<String> letterCombinations(String digits) {
		letterMap.put('2', Arrays.asList("a", "b", "c"));
		letterMap.put('3', Arrays.asList("d", "e", "f"));
		letterMap.put('4', Arrays.asList("g", "h", "i"));
		letterMap.put('5', Arrays.asList("j", "k", "l"));
		letterMap.put('6', Arrays.asList("m", "n", "o"));
		letterMap.put('7', Arrays.asList("p", "q", "r", "s"));
		letterMap.put('8', Arrays.asList("t", "u", "v"));
		letterMap.put('9', Arrays.asList("w", "x", "y", "z"));
		for (int i = 0; i < digits.length(); i++) {
			digitsList.add(digits.charAt(i));
		}
		if(digits.length() == 0) {
			return Collections.emptyList();
		}
		backtrack(0, new StringBuilder());
		return result;
	}

	private List<String> result = new ArrayList<>();

	private void backtrack(int digit, StringBuilder letters) {
		// 满足条件
		if (letters.length() == digitsList.size()) {
			result.add(letters.toString());
			return;
		}
		Character num = digitsList.get(digit);
		List<String> list = letterMap.get(num);
		for (String letter : list) {
			backtrack(digit+1,letters.append(letter));
			letters.delete(letters.length() - 1, letters.length());
		}
		
	}
}
