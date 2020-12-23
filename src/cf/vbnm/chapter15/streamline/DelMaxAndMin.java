package cf.vbnm.chapter15.streamline;

import java.util.*;
public class DelMaxAndMin extends DoThing {
   DoThing nextDoThing ;
   public void setNext(DoThing next) {
      nextDoThing = next;
   }
   public void doThing(double [] a) {
      Arrays.sort(a);
      double [] b = Arrays.copyOfRange(a,0,a.length);
      System.out.print("去掉一个最高分:"+b[b.length-1]+",");
      System.out.println("去掉一个最低分"+b[0]);
      nextDoThing.doThing(b);
   }
}