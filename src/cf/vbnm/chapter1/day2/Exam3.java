package cf.vbnm.chapter1.day2;

public class Exam3 {
    public  static void main(String[] args) {
        System.out.println("----------------------");
        //浮点数精度
        System.out.println("float类型精度：" + 3.14159265358F);
        System.out.println("doule类型精度：" + 3.14159265358D);
        //浮点数计算结果与浮点数常量进行对比
        double x = 3;
        double y = 2.6;
        System.out.println(x - y);
        System.out.println((0.4 == (x - y)));
        //计算2的5次方
        System.out.println(2 << 5);
        //整数常量默认为int类型，实数常量默认为double类型
        short s = 1;
//         s=s+2;//--------------(1)该行语句出现错误提示
//         float f=3.14;//-------(2)该行语句出现错误提示
        double d = 3.14;
        //输出除法运算结果
        int div1 = 10 / 2;
//         int div2=10/2.0;//------(3)该行语句出现错误提示
        //复合赋值运算符
        short money1 = 25000;
        int money2 = 90000;
        money1 += money2;
        System.out.println(money1);
        //非复合赋值运算符
        short money3 = 25000;
        int money4 = 90000;
        //money3=money3+money4;//-----(4)该行语句出现错误提示
        System.out.println(money3);
        //字符处理,把unicode编码转换为字符
        String zgm = "\u4e2d\t\u56fd\t\u68a6";
        System.out.println(zgm);
        //转义字符的应用
        System.out.println("输出反斜杠[\\]");
        System.out.println("[\\n]为换行：中国梦\n中国力量");
        System.out.println("[\\115]" + '\115');
        System.out.println("----------------------");
    }

}