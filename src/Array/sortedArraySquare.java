package Array;

import java.util.Arrays;

public class sortedArraySquare {
    public static void main(String[] args) {
        int[] nums = { -4,-1,0,3,10 };
        int[] arr = solution(nums);
        System.out.println(Arrays.toString(arr));
    }

    // 思路，本来排序的数平方后，若原数组的第一个数大于0，那么直接返回每个数的平方
    // 如果存在负数，那么就需要比较首尾两数的大小，将大的排队后面
    public static int[] solution (int[] arr) {
        int left = 0, right = arr.length - 1, i = right;
        int[] rs = new int[arr.length];
        while (left <= right) {
            int squareLeft = arr[left] * arr[left];
            int squareRight = arr[right] * arr[right];
            // 将较大的数放到后面
            if (squareLeft > squareRight) {
                rs[i--] = squareLeft;
                left++;
            } else {
                rs[i--] = squareRight;
                right--;
            }
        }
        return rs;
    }

}
