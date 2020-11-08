package cf.vbnm.chapter1.day2;

public class Exam2 {
    public static void main(String[] args) {
        System.out.println("-------------基本类型之间的转换-----------");
        byte aByte = 28;
        char aChar = 'W';//87
        short aShort = 20013;
        int aInt = 6666;
        long aLong = 987654321L;
        float aFloat = 3.1415F;
        double aDouble = 123.456789;
        System.out.println("累加int=" + (aByte + aChar + aShort + aInt));
        System.out.println("累加double=" + (aByte + aChar + aShort + aInt + aFloat + aDouble));
        //高类型向低类型转换
        System.out.println("long强制转换为int：" + (int) aLong);
        //高类型向低类型转换会丢失数据
        System.out.println("long强制转换为short：" + (short) aLong);
        //实数转换为整数将丢失精度
        System.out.println("double强制转换为int：" + (int) aDouble);
        //整数转换为字符类型将获得对应编码的字符
        System.out.println("short强制转换为char：" + (char) aShort);
        System.out.println("int强制转换为char：" + (char) 22269);
        //字符类型转换整型将获得对应字符的编码
        System.out.println("char强制转换为int：" + (int) '中');
        System.out.println("char强制转换为int：" + (int) '国');
        System.out.println("-------------基本类型之间的转换-----------");
    }

}