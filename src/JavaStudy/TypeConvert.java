package JavaStudy;

public class TypeConvert {
    public static void main(String[] args) {
        // 一.基本数据类型转化
        // 1.大存储空间无法向小存储空间转换
        // 2.小存储空间向大存储空间转化可以通过强制类型转换
        // 3.浮点数和整性间的转化可能会造成精度丢失

        // 1.long -> int,编译报错,long 无法转化为 int
//        Long l = Long.valueOf(2);
//        int i = (int)l;
        // 2.int -> long,正常转换
//        int i = 2;
//        long l = i;
        // 3.int -> float，可能会有精度损失。
//        int a = 2;
//        float b = (float)a;

        // 二.基本数据类型与String类型的转化
        // 1.基本数据类型转化为String.通过基本数据类型的toString()方法
        // 2.String类型转化为其它基本数据类型，通过基本数据类型的valueOf()方法
//        // 1.long -> String
//        long aa = 12;
//        String aaStr = Long.toString(aa);
//        Boolean cc = false;
//        String ccStr = Boolean.toString(cc);
//        System.out.println(ccStr); // "false"
//        // 2.String转化为基本数据类型
//        String a = "12";
//        int b = Integer.valueOf(a);
//        System.out.println(b);

        // 3.字符串转化为基本数据类型溢出的情况 编译不报错，运行时报错
        String bstr = "127"; // byte 最大数为127
        byte b = Byte.valueOf(bstr);
        System.out.println(b);


    }
}
