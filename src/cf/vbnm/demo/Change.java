package cf.vbnm.demo;

import java.util.Scanner;

public class Change {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String in=sc.next();
		int convert;
		try{
			convert=Integer.parseInt(in,16);
			System.out.println(in+"'s binary: "+Integer.toBinaryString(convert));
		}catch (Exception e){
			System.err.println("This is Not A Number");
		}
	}
}
