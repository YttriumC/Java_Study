package cf.vbnm.chapter2.book;

public class Example2_1 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        char chineseWord = '好', japaneseWold = 'の';
        char you = '\u4f60';
        int position = 20320;
        System.out.println("汉字"+chineseWord+"的位置:"+(int)chineseWord);
        System.out.println("日文"+japaneseWold+"的位置:"+(int)japaneseWold);
        System.out.println(position+"位置上的是:"+(char)position);
        position=21319;
        System.out.println(position+"位置上的字符是:"+(char)position);
        System.out.println("you:"+you);
    }
}
