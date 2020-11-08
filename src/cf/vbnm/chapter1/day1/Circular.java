package cf.vbnm.chapter1.day1;

import java.util.Scanner;

public class Circular {
    // 编写Java应用程序，已知圆的半径，输出计算圆的面积和周长并输入
    public static void main(String[] args) {
        double radius;
        System.out.println("请输入圆的半径:");
        Scanner sc = new Scanner(System.in);
        radius = sc.nextDouble();
        System.out.println("圆的面积为:"+radius*radius*Math.PI);
        System.out.println("圆的周长为:"+radius*2*Math.PI);
    }
}
