package cf.vbnm.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JewelAndStone {
	public static void main(String[] args) {
		JewelAndStone jewelAndStone=new JewelAndStone();
		jewelAndStone.numJewelsInStones("aA","aAAjksf");
	}
	/*
	给定字符串J代表石头中宝石的类型，和字符串S代表你拥有的石头。S中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
	J中的字母不重复，J和S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
	*/
	public int numJewelsInStones(String J, String S) {
		Pattern compile = Pattern.compile("[" + J + "]");
		Matcher matcher=compile.matcher(S);
		int i=0;
		while (matcher.find())
			i++;
		System.out.println(i);

		return 0;
	}
}
