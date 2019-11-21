/**
 * @author zhangboqing
 * @date 2019-11-21
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Leetcode_283 {

    /*
        示例:
            输入: [0,1,0,3,12]
            输出: [1,3,12,0,0]

        说明:
            必须在原数组上操作，不能拷贝额外的数组。
            尽量减少操作次数。
    */

    public void moveZeroes2(int[] nums) {

        if (nums == null) {
            return;
        }

        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (0 != nums[j]) {
                i++;
                if (j - i >= 1) {
                    nums[i] = nums[j];
                }
            }
        }

        int zeroLength = nums.length - i - 1;
        if (zeroLength > 0) {
            for (int j = 0; j < zeroLength; j++) {
                nums[nums.length - 1 - j] = 0;
            }
        }
    }
    public void moveZeroes(int[] nums) {

        if (nums == null) {
            return;
        }

        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (0 != nums[j]) {
                i++;
                if (j - i >= 1) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {0, 1};
//        int[] nums = {1, 0};
//        int[] nums = {};
        (new Leetcode_283()).moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");

        }
    }
}
