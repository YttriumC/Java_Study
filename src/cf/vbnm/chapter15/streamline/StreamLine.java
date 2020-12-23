package cf.vbnm.chapter15.streamline;

public class StreamLine {
    private DoThing one,two,three;    
    StreamLine(){       
       one=new DoInput();
       two=new DelMaxAndMin();
       three=new ComputerAver();
       one.setNext(two);
       two.setNext(three);
    }
    public void giveResult(double a[]){ 
       one.doThing(a);
    }
}
