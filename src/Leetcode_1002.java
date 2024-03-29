import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangboqing
 * @date 2019-11-21
 * 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 */
public class Leetcode_1002 {

   /*
    示例 1：

        输入：["bella","label","roller"]
        输出：["e","l","l"]
    示例 2：

        输入：["cool","lock","cook"]
        输出：["c","o"]

    提示：

        1 <= A.length <= 100
        1 <= A[i].length <= 100
        A[i][j] 是小写字母
   */


    public List<String> commonChars2(String[] A) {

        List<String> charList = new ArrayList<>();
        if (A == null) {
            return charList;
        }
        int length = A.length;
        int[][] charCountArr = new int[length][26];
        for (int i = 0; i < length; i++) {
            String str = A[i];
            int[] ints = charCountArr[i];
            for (int j = 0; j < str.length(); j++) {
                ints[(str.charAt(j) - 97)] = ints[(str.charAt(j) - 97)] + 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            int count = -1;
            for (int j = 0; j < length; j++) {
                if (count == -1) {
                    count = charCountArr[j][i];
                    continue;
                }

                if (charCountArr[j][i] < count) {
                    count = charCountArr[j][i];
                }
            }

            if (count >= 1) {
                while (count-- > 0) {
                    char c = (char) (97 + i);
                    charList.add(String.valueOf(c));
                }
            }
        }
        return charList;
    }

    public List<String> commonChars(String[] A) {

        // 入参检查
        if(A == null || A.length == 0 || A.length == 1) {
            return null;
        }
        // 记录每个字符出现的次数（字符的ASCII码-97的值做数组下标）
        int[] hash = new int[26];
        // 是否第一次维护hash数组
        boolean firstFlag = true;
        // 遍历字符串
        for (String word : A) {
            // 拆分成字符数组
            char[] wordChars = word.toCharArray();
            // 如果是第一次维护hash数组
            if (firstFlag) {
                // 直接记录每个字符出现的个数
                for (char wordChar : wordChars) {
                    hash[wordChar - 97]++;
                }
                // 标志置为否
                firstFlag = false;
                // 如果不是第一次维护，即hash数组中有值时
            }else {
                // 新建临时数组tmpHash来记录当前字符数组每个字符出现的次数
                int[] tmpHash = new int[26];
                for (char wordChar : wordChars) {
                    tmpHash[wordChar - 97]++;
                }

                // 维护hash数组
                for(int i = 0; i < hash.length; ++i) {
                    // 比较hash数组和tmpHash数组
                    // hash记录每次每个字符出现的最小次数
                    if(hash[i] > tmpHash[i]) {
                        hash[i] = tmpHash[i];
                    }
                }
            }
        }
        // 组装返回结果
        List<String> res = new ArrayList<>();
        for(int i = 0; i < hash.length; ++i) {
            if(hash[i] != 0) {
                String tmp = String.valueOf((char)(i + 97));
                for(int j = 0; j < hash[i]; ++j) {
                    res.add(tmp);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

//        String[] A = {"bella","label","roller"};
        String[] A = {"cool","lock","cook"};
        System.out.println((new Leetcode_1002().commonChars(A)));
    }

}
