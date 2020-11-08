package cf.vbnm.chapter8.retrieval;

public class FindMess {
	public static void main(String[] args) {
		String mess = "姓名:张三 出生时间:1989.10.16. 个人网站:la.vbnm.cf 身高:185cm,体重:72kg";
		int index = mess.indexOf(":");
		String name = mess.substring(index + 1);
		if (name.startsWith("张")) {
			System.out.println("简历中的姓名:姓\"张\"");
			index = mess.indexOf(":", index + 1);
			String date = mess.substring(index + 1, index + 11);
			System.out.println(date);
			index = mess.indexOf(":", index + 1);
			int heightPosition = mess.indexOf("身高");
			String personNet = mess.substring(index + 1, heightPosition - 1);
			System.out.println(personNet);
			index = mess.indexOf("身高") + 2;
			int cmPosition = mess.indexOf("cm");
			String height = mess.substring(index + 1, cmPosition);
			height = height.trim();
			int h = Integer.parseInt(height);
			if (h >= 180)
				System.out.println("简历中的身高" + height + "大于等于180cm");
			else
				System.out.println("简历中的身高" + height + "小于180cm");
			index = mess.lastIndexOf(":");
			int kgPosition = mess.indexOf("kg");
			String weight = mess.substring(index + 1, kgPosition);
			weight = weight.trim();
			int w = Integer.parseInt(weight);
			if (w >= 75) {
				System.out.println("简历中的体重" + weight + "大于等于75kg");
			} else
				System.out.println("简历中的体重" + weight + "小于75kg");


			String str1 = new String("ABCABC"),
					str2 = null,
					str3 = null,
					str4 = null;
			str2 = str1.replaceAll("A", "First");
			str3 = str2.replaceAll("B", "Second");
			str4 = str3.replaceAll("C", "Third");
			System.out.println(str1);
			System.out.println(str2);
			System.out.println(str3);
			System.out.println(str4);

			System.out.println(Long.toBinaryString(12345));
			System.out.println(Long.toOctalString(12345));
			System.out.println(Long.toHexString(12345));
		}
	}
}
