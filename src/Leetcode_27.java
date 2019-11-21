/**
 * @author zhangboqing
 * @date 2019-11-21
 * 移除元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Leetcode_27 {

    /*
    示例 1:

        给定 nums = [3,2,2,3], val = 3,

        函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

        你不需要考虑数组中超出新长度后面的元素。
    示例 2:

        给定 nums = [0,1,2,2,3,0,4,2], val = 2,

        函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

        注意这五个元素可为任意顺序。

        你不需要考虑数组中超出新长度后面的元素。
    说明:

        为什么返回数值是整数，但输出的答案是数组呢?

        请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

        你可以想象内部操作如下:

        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int len = removeElement(nums, val);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            print(nums[i]);
        }
     */

    // 双指针
    public int removeElement(int[] nums, int val) {

        if (nums == null ) {
            return 0;
        }

        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (val != nums[j]) {
                i++;
                if (j - i >=1) {
                    nums[i] = nums[j];
                }
            }
        }

        if (i == -1) {
            return 0;
        }
        return i+1;
    }

    public static void main(String[] args) {
//        int[] nums = {3,2,2,3};
//        int[] nums = {};
        int[] nums = {0,1,2,2,3,0,4,2};
        int lenght = (new Leetcode_27()).removeElement(nums, 2);
        System.out.println(lenght);
        for (int i = 0; i < lenght; i++) {
            System.out.print(nums[i]+ " ");
        }
    }
}
