package leetcode13.algorithm.wk03;

/**
 * 70. 爬楼梯
 * @author qkh
 *
 */
public class ClimbStairs {
	// f(n) = f(n-1) + f(n-2);
	public int climbStairs(int n) {
		if(n < 3) {
			return n;
		}
		int f1 = 1, f2 = 2, fn = 0;
		while(n > 2) {
			fn = f1 + f2;
			f1 = f2;
			f2 = fn;
			n--;
		}
		return fn;
    }
	
	public static void main(String[] args) {
		int climbStairs = new ClimbStairs().climbStairs(5);
		System.out.println(climbStairs);
	}
}
