package Array;

/**
 * 在有序数组中插入某个元素，若查找成功则返回其索引号，否则返回待插入位置。
 */
public class SearchInsert {
    public static void main(String[] args) throws AssertionError {
        int[] case1 = { 1 };
        int rs1 = searchInsert(case1, 1);
        System.out.println(rs1);
    }
    public static int searchInsert(int[] nums, int target) {
        // 不在范围内，插入头部或者尾部
        if (nums.length == 0 || target < nums[0]) return 0;
        if (target > nums[nums.length -1 ]) return nums.length;
        int i = 0, j = nums.length - 1;
        // 在范围内，二分搜索插入位置
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        // 当未找到相同元素时，如何确定元素的插入位置。当 a < target < b 时，这里可以分三种情况讨论
        // 1. i指向a,j指向b,则mid指向a.循环终止后，i指向b,j指向a。i的位置为待插入位置
        // 2. i，j,mid都指向a,循环结束时，i指向b,j指向a。i为待插入位置
        // 3. i，j,mid都指向b,循环结束时，i指向b,j指向a。i为待插入位置
        return i;
    }
}
