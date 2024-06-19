package Array;

import java.util.Arrays;

/**
 * 删除线性表的某个元素
 */
public class removeListElement {
    public static void main(String[] args) {
        int[] a = { 0,1,2,2,3,0,4,2 };
        int n = remove(a, 2);
        System.out.println(n);
        System.out.println(Arrays.toString(a));
    }

    public static int remove (int[] arr, int val) {
        int itv = 0, i = -1, j = -1;
        // find index whose val equals to val
        while (++i < arr.length && arr[i] != val);
        while (i < arr.length && j < arr.length) {
            // find index whose val equals to val again
            j = i;
            while (++j < arr.length && arr[j] != val);
            itv++;
            // put element ahead by itv
            while (++i < j) {
                arr[i - itv] = arr[i];
            }
        }
        return arr.length - itv;
    }
}
