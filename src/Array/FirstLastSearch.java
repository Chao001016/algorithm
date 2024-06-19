package Array;

import java.util.Arrays;

/**
 * 查找排序数组中某个元素第一次出现和最后一次出现的位置
 */
public class FirstLastSearch {
    public static void main(String[] args) throws AssertionError {
        int[] case1 = { 1,2,3 };
        int[] rs1 = search(case1, 2);
        System.out.println(Arrays.toString(rs1));
    }
    public static int[] search (int[] arr, int val) {
        // 不在范围内
        if (arr.length == 0 || val < arr[0] || val > arr[arr.length - 1]) return new int[]{-1, -1};
        // 在范围内
        // 找左边界
        int left = BSerachBorder(arr, 0, arr.length - 1, val - 1,"leftBorder");
        System.out.println(left);
        // 找右边界
        int right = BSerachBorder(arr, 0, arr.length - 1, val + 1,"rightBorder") - 1;
        System.out.println(right);
        // 范围内没找到
        if (arr[left] != val || arr[right] != val) return new int[]{-1, -1};
        return new int[]{left, right};
    }

    public static int BSerachBorder (int[] nums, int left, int right, int target, String type) {
        int mid = 0;
        // 不在范围内
        if (target > nums[right]) return right + 1;
        if (target < nums[left]) return left;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                // 若找到了
                if (type == "leftBorder") {
                    return BSerachBorder(nums, mid + 1, right, target, type);
                } else {
                    return BSerachBorder(nums, left, mid - 1, target, type);
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
