package cf.vbnm.chapter10.countwords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class WordStatistic {
	Vector<String>allWord,noSameWord;
	File file=new File("out\\english.txt");
	Scanner sc;
	String regex;
	WordStatistic(){
		allWord=new Vector<>();
		noSameWord=new Vector<>();
		regex="[\\s\\d\\p{Punct}]+";
		try {
			sc=new Scanner(file);
			sc.useDelimiter(regex);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		}
	}
	public void wordStatistic(){
		while (sc.hasNext()){
			String word=sc.next();
			allWord.add(word);
			if(!noSameWord.contains(word))
				noSameWord.add(word);
		}
	}
	void setFileName(String name){
		file=new File(name);
		try {
			sc=new Scanner(file);
			sc.useDelimiter(regex);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		}
	}
	public Vector<String> getAllWord(){
		return allWord;
	}
	public Vector<String> getNoSameWord(){
		return noSameWord;
	}
}
