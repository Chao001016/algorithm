package Array;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BSearch {
    public static void main(String[] args) throws AssertionError {
        int[] case1 = { 1,3,7, 5, -1, 0, 2 };
        int rs1 = search(case1, 5);
        System.out.println(rs1);
        assert rs1 == 1 : "case1 error";
    }
    public static int search (int[] arr, int val) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 2);
            // 找到目标值
            if (arr[mid] == val) return mid;
            // 目标值小于中间值
            else if (arr[mid] > val) j = mid - 1;
            // 目标值大于中间值
            else i = mid + 1;
        }
        return -1;
    }
}
