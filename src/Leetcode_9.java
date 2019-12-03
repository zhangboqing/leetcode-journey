/**
 * @author zhangboqing
 * @date 2019-11-19
 */
public class Leetcode_9 {

    /*
    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

    示例 1:
        输入: 121
        输出: true

    示例 2:
        输入: -121
        输出: false

    解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

    示例 3:
        输入: 10
        输出: false

    解释: 从右向左读, 为 01 。因此它不是一个回文数。
    进阶:

        你能不将整数转为字符串来解决这个问题吗？
     */

    public boolean isPalindrome2(int x) {
        String str = Integer.toString(x);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome3(int x) {

        if (x < 0) {
            return false;
        }
        int count = 0;
        long temp = x;
        while (temp > 0) {
            temp = temp / 10;
            if (temp > 0) {
                count++;
            }
        }
        temp = x;
        long reverseValue = 0;
        for (int i = count; i >= 0; i--) {
            long value = temp % 10;
            reverseValue += value * Math.pow(10,i);
            temp /= 10;
        }

        return x == reverseValue;
    }

    public boolean isPalindrome4(int x) {

        if (x < 0) {
            return false;
        }
        int help = 1;
        int tmp = x;
        while (tmp >= 10) {
            help *= 10;
            tmp /= 10;
        }
        while (x != 0) {
            if (x % 10 != x / help) {
                return false;
            }
            x = x % help / 10;
            help /= 100;
        }
        return true;

    }

    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }


    public static void main(String[] args) {

        System.out.println(new Leetcode_9().isPalindrome(2147483647));
//        System.out.println(new Leetcode_9().isPalindrome(121));
//        System.out.println(new Leetcode_9().isPalindrome(-121));
//        System.out.println(new Leetcode_9().isPalindrome(10));
    }

}
