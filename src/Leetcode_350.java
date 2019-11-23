import java.util.*;

/**
 * @author zhangboqing
 * @date 2019-11-19
 * 两个数组的交集 II
 */
public class Leetcode_350 {

    /*
       给定两个数组，编写一个函数来计算它们的交集。

    示例 1:

        输入: nums1 = [1,2,2,1], nums2 = [2,2]
        输出: [2,2]
    示例 2:

        输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出: [4,9]
    说明：

        输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
        我们可以不考虑输出结果的顺序。
        进阶:

        如果给定的数组已经排好序呢？你将如何优化你的算法？
        如果 nums1 的大小比 nums2 小很多，哪种方法更优？
        如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

    */

    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            Integer count = map1.get(key);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map1.put(key, count);
        }
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            Integer count = map2.get(key);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map2.put(key, count);
        }
        ArrayList<Integer> results = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entries = map1.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getKey();
            Integer count = entry.getValue();
            Integer count2 = map2.get(key);
            if (count2 == null) {
                continue;
            }
            if (count2 < count) {
                count = count2;
            }
            for (int i = 0; i < count; i++) {
                results.add(key);
            }
        }

        int[] ints = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            ints[i] = results.get(i);
        }
        return ints;
    }

    // 排序+双指针
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> results = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                results.add(nums1[i]);
                i++;
                j++;
                continue;
            }
            if (nums1[i] > nums2[j]) {
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                i++;
                continue;
            }
        }
        int[] ints = new int[results.size()];
        for (int k = 0; k < results.size(); k++) {
            ints[k] = results.get(k);
        }
        return ints;
    }


    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 2, 1};
//        int[] nums2 = {2,2};
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersect = new Leetcode_350().intersect(nums1, nums2);
        for (int i : intersect) {

            System.out.print(i + " ");
        }
    }
}
