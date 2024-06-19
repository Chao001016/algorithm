package Array;

import java.util.Arrays;

public class minSubArrayLen {
    public static void main(String[] args) {
        int[] nums = { 1,2,-4,1,3 };
        int rs = solution2(4, nums);
        System.out.println(rs);
    }

    // 思路: 动态规划，dp[i][j]为数组第i到第j的累计和。然后遍历二维数组，若找到满足要求的最短长度
    // 递推式，若i = j,dp[i][j] = arr[i]，否则 dp[i][j] = dp[i][j - 1] + dp[j];
    // 细节：i >= j，因此该二维数组是一个下三角
    // 感觉思路没问题，但是超出内存限制了，

    public static int solution (int target, int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        // dp过程
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (dp[i][j - 1] >= target) break;
                else dp[i][j] = dp[i][j - 1] + arr[j];
            }
        }
        // 找到最小的子数组
        int num = arr.length + 1; // 默认为数组长度加一（当然这不可能）
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                // 遇到为0的，说明dp[i][j-1]已满足，无需继续遍历下去
                if (dp[i][j] == 0) break;;
                if (dp[i][j] >= target && (j - i + 1) <= num) {
                    num = j - i + 1;
                }
            }
        }
        // 在寻找的过程中修改过 num 的值，则说明找到过满足条件，直接返回
        if (num < arr.length + 1) return num;
        return 0;
    }

    // 看到另外一种方法:滑动窗口
    // 分析一下为啥动态规划的效率并不是很高的原因：假如我确认的dp[1,4]满足解，我还又必要对dp[1,2],dp[1,3]等等求解吗？
    // 答案肯定是没必要，此时，为了去寻找更优解，我们应该把i，j后移动，若此时还能满足需求，我们继续将i后移动，j保持不变，此时就达到了收缩范围的效果
    public static int solution2 (int target, int[] arr) {
        if (arr.length == 0) return 0;
        int i = 0,j = 0;
        int sum = 0;
        int rs = arr.length + 1;
        // 找到了
        while (j < arr.length) {
            // 当没找到时，那么就一直找；否则保持之前的状态
            sum += arr[j];
            // 找到满足要求的，则需要考虑是否要移动i
            while (sum >= target) {
                rs = Math.min(j - i + 1, rs);
                sum -= arr[i];
                i++;
            }
            j++;
        }
        if (rs == arr.length + 1) return 0;
        return rs;
    }
}
