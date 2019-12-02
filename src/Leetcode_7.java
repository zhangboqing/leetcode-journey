/**
 * @author zhangboqing
 * @date 2019-11-19
 */
public class Leetcode_7 {

    /*
    给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

       示例 1:
        输入: 123
        输出: 321

       示例 2:
        输入: -123
        输出: -321

       示例 3:
        输入: 120
        输出: 21

       注意:

          假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

          解法一：思维：将int整数转化为字符串，再转化为char[]数组进行倒叙遍历
          解法二：将int整数对10进行取模取余
     */


    public int reverse2(int x) {

        boolean isMinus = false;
        StringBuilder sb = new StringBuilder();
        char[] chars = String.valueOf(x).toCharArray();
        if (chars[0] == '-') {
            isMinus = true;
        }
        int startIndex = 0;
        if (isMinus) {
            sb.append(chars[0]);
            startIndex = 1;
        }

        for (int i = chars.length - 1; i >= startIndex; i--) {
            sb.append(chars[i]);
        }
        long result = 0;
        String resultStr = sb.toString();
        result = Long.parseLong(resultStr);
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0L;
        }

        return (int)result;
    }

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int k = x % 10;
            result = result * 10 + k;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_7().reverse(123));
        System.out.println(new Leetcode_7().reverse(-123));
        System.out.println(new Leetcode_7().reverse(120));
        System.out.println(new Leetcode_7().reverse(1534236469));
        System.out.println(new Leetcode_7().reverse(-2147483648));
    }
}
