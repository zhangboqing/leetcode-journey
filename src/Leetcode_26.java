/**
 * @author zhangboqing
 * @date 2019-11-20
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */

public class Leetcode_26 {
    /*
      示例 1:

        给定数组 nums = [1,1,2],

        函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

        你不需要考虑数组中超出新长度后面的元素。
      示例 2:

        给定 nums = [0,0,1,1,1,2,2,3,3,4],

        函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

        你不需要考虑数组中超出新长度后面的元素。
        说明:

     为什么返回数值是整数，但输出的答案是数组呢?

        请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

        你可以想象内部操作如下:

        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = removeDuplicates(nums);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            print(nums[i]);
        }
     */
    // 原地删除重复元素、已排序的
    public int removeDuplicates2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }

        int rightIndex = length - 1;
        int leftIndex = 0;
        int waitMoveIndex = -1;
        Integer curValue = null;
        for (int i = 0; i <= rightIndex; i++) {
            if (curValue == null) {
                curValue = nums[i];
                continue;
            }

            boolean isNeedMoved = false;
            if (curValue == nums[i]) {
                if (waitMoveIndex == -1) {
                    waitMoveIndex = i;
                }
                leftIndex = i + 1;

            } else {
                isNeedMoved = true;

            }

            if ((i+1) > rightIndex || isNeedMoved) {
                if (waitMoveIndex != -1) {
                    int len = leftIndex - waitMoveIndex;
                    // stat move
                    for (int j = leftIndex; j <= rightIndex; j++) {
                        nums[j - len] = nums[j];
                    }
                    waitMoveIndex = -1;
                    rightIndex -= len;
                    i = i - len -1;
                    curValue = null;
                } else {
                    curValue = nums[i];
                }
            }

        }
        return rightIndex + 1;
    }
    // 原地删除重复元素、已排序的
    public int removeDuplicates3(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }

        int rightIndex = length - 1;
        Integer curValue = null;
        for (int i = 0; i <= rightIndex; i++) {
            if (curValue == null) {
                curValue = nums[i];
                continue;
            }

            boolean isMoved = false;
            if (curValue == nums[i]) {
                for (int j = i; j < rightIndex; j++) {
                    nums[j] = nums[j+1];
                }
                rightIndex -= 1;
                isMoved = true;
            }

            if (curValue == nums[i] && isMoved) {
                i--;
            } else {
                curValue = nums[i];
            }

        }
        return rightIndex + 1;
    }

    // 双指针
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }

        int i = 0;
        for (int j = 1; j < length; j++) {
            if (nums[i] != nums[j] ) {
                nums[i+1] = nums[j];
                i++;
            }
        }

        return i+1;

    }

    public static void main(String[] args) {
        int[] nums = {1,2};
//        int[] nums = {1,1};
//        int[] nums = {1,1,2};
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int lenght = (new Leetcode_26()).removeDuplicates(nums);
        System.out.println(lenght);
        for (int i = 0; i < lenght; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
