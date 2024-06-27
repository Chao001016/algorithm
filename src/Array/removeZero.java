package Array;

import java.util.Arrays;

/**
 * 移动0
 */
public class removeZero {
    public static void main(String[] args) throws AssertionError {
        int[] nums = {0,1,0,3,12};
        int len = remove(nums, 0);
        for (int i = len; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
    public static int remove (int[] arr, int val) {
        int i = -1;
        // 找第一个等于目标的索引
        while (++i < arr.length && arr[i] != val);
        int j = i;
        int num = 0;
        while (j < arr.length) {
            // 找到第二个等于目标的索引
            while (++j < arr.length && arr[j] != val);
            num++;
            while (++i < j) {
                arr[i - num] = arr[i];
            }
        }
        return arr.length - num;
    }
}
