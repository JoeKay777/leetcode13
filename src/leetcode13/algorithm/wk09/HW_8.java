package leetcode13.algorithm.wk09;

/**
 * 8. 字符串转换整数 (atoi)
 */
public class HW_8 {

    public int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        int firstNum = 0;
        boolean negative = false;
        if (chars[firstNum] == '+' || chars[firstNum] == '-') {
            if (chars[firstNum] == '-') {
                negative = true;
            }
            firstNum++;
        }
        int Max = negative ? Integer.MIN_VALUE : -Integer.MAX_VALUE;
        int num = 0;    // 使用负数保存结果及判断越界
        while (firstNum < str.length() && Character.isDigit(chars[firstNum])) {
            int digit = chars[firstNum++] - '0';
            // 判断越界
            if (num < (Max + digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = (num * 10 - digit);
        }
        return negative ? num : -num;
    }

    public static void main(String[] args) {
        new HW_8().myAtoi("   42");
    }
}
