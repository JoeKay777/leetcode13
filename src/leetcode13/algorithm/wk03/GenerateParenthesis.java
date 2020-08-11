package leetcode13.algorithm.wk03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 22. 括号生成
 * 
 * @author qkh
 *
 */
public class GenerateParenthesis {

	List<String> list = new ArrayList<>();
	
	public List<String> generateParenthesis(int n) {
		generate("", n, n);
		return list;
	}

	private void generate(String cur, int left,int right) {
		if(left == 0 && right == 0) {
			list.add(cur);
			return;
		}
		if(left > 0) {
			generate(cur+"(", left-1, right);
		}
		if(left < right) {
			generate(cur+")", left, right -1);
		}
	}
	
	public List<String> generateParenthesis2(int n) {
		List<String> list = new ArrayList<>();
		if(n == 0) {
			list.add("");
			return list;
		}
		for (int l = 0; l < n; l++) {
			int r = n -l -1;
			List<String> lList = generateParenthesis2(l);
			List<String> rList = generateParenthesis2(r);
			for (String lstr : lList) {
				for (String rstr : rList) {
					list.add("("+lstr+")" + rstr); 
				}
			}
			
		}
		return list;
	}

	public static void main(String[] args) {
		List<String> generateParenthesis2 = new GenerateParenthesis().generateParenthesis2(2);
		System.out.println(Arrays.deepToString(generateParenthesis2.toArray()));
	}
}
