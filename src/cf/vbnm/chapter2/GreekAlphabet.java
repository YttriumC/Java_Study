package cf.vbnm.chapter2;

import org.junit.Test;

public class GreekAlphabet {
    public static void main(String[] args) {
        int startPosition = 0, endPosition = 0;
        char cStart = 'α', cEnd = 'ω';
        /*code 1,2*/
        startPosition = (int) cStart;
        endPosition = (int) cEnd;
        /*code 1,2*/
        System.out.println("希腊字母\'α\'在Unicode表中的顺序位置:" + startPosition);
        System.out.println("希腊字母表:");
        for (int i = cStart; i <= endPosition; i++) {
            /*code 3*/
            System.out.print("  " + (char) i);
            /*code 3*/
            if ((i - startPosition + 1) % 10 == 0)
                System.out.println("  ");
        }
    }

    @Test
    public void afterExperiment() {
        //        float x=0.618; //java: 不兼容的类型: 从double转换到float可能会有损失
//        byte y=128;  //java: 不兼容的类型: 从int转换到byte可能会有损失
        int z = (byte) 128;
        System.out.println(z);  //-128
    }
}
