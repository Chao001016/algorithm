package Array;

public class BackSpaceCompare {
    public static void main(String[] args) {
        Boolean rs = compare("ab#c", "ad#c");
        Boolean rs2 = compare("ab##", "c#d#");
        Boolean rs3 = compare("a#c", "b");
        Boolean rs4 = compare("xywrrmp", "xywrrmu#p");
        System.out.println(rs);
        System.out.println(rs2);
        System.out.println(rs3);
        System.out.println(rs4);
    }
    public static boolean compare (String a, String b) {
        int i = a.length();
        int j = b.length();
        while (i >= 0 && j>=0) {
            // 搜找a中待比较的位置
            i = findCompareIndex(a, i);
            // 搜索b中待比较的位置
            j = findCompareIndex(b, j);
            // 若i越界但是b不越界，或i不越界,j越界 或 两个字符不相等，则匹配失败
            if (i < 0 && j < 0) return true;
            if ((i >= 0 && j < 0) || (j >= 0 && i < 0) || a.charAt(i) != b.charAt(j)) return false;
        }
        return true;
    }

    public static int findCompareIndex (String a, int i) {
        int num = 0;
        // 一个#可以抵消一个非#字符，若不存在#且当前字符为非#字符,那么当前字符就是带比较字符
        while (--i >=0 && (a.charAt(i) == '#' || num > 0)){
            if (a.charAt(i) == '#') {
                num++;
            } else { // 非#符号抵消一个#字符
                num--;
            }
        }
        return i;
    }
}
