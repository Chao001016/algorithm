package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class FruitBaskets {
    public static void main(String[] args) {
        int count = solution2(new int[]{ 3,3,3,1,2,1,1,2,3,3,4 });
//        int count = solution2(new int[]{ 0,0,1,1 });
//        int count = solution2(new int[]{ 0,1,6,6,4,4,6});
        System.out.println(count);
    }
    public static int totalFruit(int[] fruits) {
        if (fruits.length <= 2) return fruits.length;
        int[] bascketStack = new int[]{ 0,1 }; // 存储每种水果出现的最早的位置
        int count = 2, i = 0, j = 2;
        while (j < fruits.length) {
            // 拿旧类型的水果
            while (j < fruits.length && canTake(bascketStack, fruits, j)) {
                count = Math.max((j - i + 1), count);
                updateOrder(bascketStack, fruits, j);
                j++;
            }
            // 加新种类的水果不会使篮子装的水果数量变大
            if (j < fruits.length) i = addNewType(bascketStack, fruits, j++);
        }
        return count;
    }
    // 加了新的水果种类后，i需要往后移
    public static int addNewType (int[] bascketStack, int[] fruit ,int j){
        updateOrder(bascketStack, fruit, j);
        return bascketStack[0];
    }
    public static boolean canTake (int[] bascketStack, int[] fruits, int j) {
        return (fruits[bascketStack[0]] == fruits[j] || fruits[bascketStack[1]] == fruits[j]) ||
                (fruits[bascketStack[0]] == fruits[bascketStack[1]]);
    }


    // 更新序号
    public static void updateOrder (int[] bascketStack, int[] fruit ,int j) {
        if (fruit[j] != fruit[bascketStack[1]]) {
            bascketStack[0] = bascketStack[1];
            bascketStack[1] = j;
        }
    }

    // 题解2，这里通过Map的方式来移动i,
    public static int solution2 (int[] fruits) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int i = 0, j = 0, answer = 0;
        while (j < fruits.length) {
            cnt.put(fruits[j], cnt.getOrDefault(fruits[j], 0) + 1);
            // i前移
            while(cnt.size() > 2) {
                cnt.put(fruits[i], cnt.get(fruits[i]) - 1);
                if (cnt.get(fruits[i]) == 0) { cnt.remove(fruits[i]); }
                i++;
            }
            answer = Math.max(answer, j - i + 1);
            j++;
        }
        return answer;
    }
}

