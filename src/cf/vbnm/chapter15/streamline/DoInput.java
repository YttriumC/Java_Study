package cf.vbnm.chapter15.streamline;

import java.util.*;
public class DoInput extends DoThing {
   DoThing nextDoThing ;
   public void setNext(DoThing next) {
      nextDoThing = next;
   }
   public void doThing(double [] a) {
      System.out.println("请输入裁判数");
      Scanner read=new Scanner(System.in);
      int count = read.nextInt();
      System.out.println("请输入各个裁判的分数");
      a = new double[count];
      for(int i=0;i<count;i++) {
           a[i]=read.nextDouble();
      }
      nextDoThing.doThing(a);
   }
}