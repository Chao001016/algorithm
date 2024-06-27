package Array;

import java.util.Arrays;

/**
 * 移动0
 */
public class removeDuplicate {
    public static void main(String[] args) throws AssertionError {
        int[] nums = {0,1,1,3,3,12};
        int len = remove(nums);
        System.out.println(len);
        System.out.println(Arrays.toString(nums));
    }
    public static int remove (int[] arr) {
        if (arr.length < 2) return arr.length;
        int i = -1, j = 0;
        int num = 0;
        while (j < arr.length) {
            arr[j - num] = arr[j];
            while (++j < arr.length && arr[++i] == arr[j]){
                num++;
            }
        }
        // 返回有效数组长度
        return arr.length - num;
    }


}
