package cf.vbnm.demo;

import org.junit.Test;

import java.util.Scanner;


/**
 * @description : 该类是把阿拉伯数字转换成中文大写的类。
 * 汉字大写金额数字，一律用正楷字或行书字书写，如壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、圆（元）、
 * 角、分、零、整（正）等易于辨认、不易涂改的字样。
 * 不得用一、二（两）、三、四、五、六、七、八、九、十、念、毛、另（或０）等字样代替，不得任意自造简化字。
 * <p>
 * 大写金额数字到元或角为止的，在“元”或“角”字之后应写“整”或“正”字；大写金额数字有分的，分字后面不写“整”字。
 * 大写金额数字前未印有人民币字样的，应加填“人民币”三字，“人民币”三字与金额数字之间不得留有空白。
 * <p>
 * 阿拉伯金额数字中间有“０”时，汉字大写金额要写“零”字，如＄１０１．５０，汉字大写金额应写成人民币壹佰零壹圆伍角整。
 * 阿拉伯金额数字中间连续有几个“０”时，汉字大写金额中可以只写一个“零”字，如￥１，００４．５６，汉字大写金额应写成
 * 人民币壹仟零肆圆伍角陆分。阿拉伯金额数字元位是“０”，或数字中间连续有几个“０”，元位也是“０”，但角位不是“０”时，
 * 汉字大写金额可只写一个“零”字，也可不写“零”字，如＄１，３２０．５６，汉字大写金额应写成人民币壹仟叁佰贰拾圆零伍
 * 角陆分，或人民币壹仟叁佰贰拾圆伍角陆分。又如＄１，０００．５６，汉字大写金额应写成人民币壹仟圆零伍角陆分，或人民
 * 币壹仟圆伍角陆分。
 * 摘自《会计人员工作规则》（８４）财会１６号
 */
public class ChineseNumerals {
	static final String[] DIGIT = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
	static final String FEN = "分", JIAO = "角", TEN = "拾", HUNDRED = "佰",
			THOUSAND = "千", TEN_THOUSANDS = "萬", TEN_MILLIONS = "亿", YUAN = "圆", ZHENG = "整";
	static final String[] units = {"仟", "佰", "拾", ""};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();//获得输入
		sc = new Scanner(input);//用Scanner扫描输入
		if (input.contains("."))//是否有'.'
			sc.useDelimiter("\\.");//使用'.'分割字符串,分成整数和小数部分
		String integerPart = sc.nextBigInteger().toString();//整数字符串
		int decimalPart = 0;//小数部分
		try {
			//尝试解析小数部分,没有小数就抛异常,catch掉
			decimalPart = sc.nextInt() * 10;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//小数位数多过的处理
		while (decimalPart > 99)
			decimalPart /= 10;
		//要输出的整数大写
		String chineseIntegerPart = "";
		//以4为单位长度处理整数部分
		for (int i = 0; i < (integerPart.length() + 3) / 4; i++) {
			//如果是偶数次循环,加万
			if (i % 2 == 1)
				chineseIntegerPart = TEN_THOUSANDS + chineseIntegerPart;
			else
				//奇数次循环,加亿
				chineseIntegerPart = TEN_MILLIONS + chineseIntegerPart;
			//4位单元处理,转换大写
			chineseIntegerPart = getChinese(integerPart.substring(
					/*提取4位长度的子串,同时防止越界,倒序提取*/
					Math.max(integerPart.length() - (i + 1) * 4, 0), integerPart.length() - i * 4))
					+ chineseIntegerPart;
		}
		//去掉尾部多出来的'亿'
		chineseIntegerPart = chineseIntegerPart.substring(0, chineseIntegerPart.length() - 1);
//		if (offset != 0) {
//			if (integerPart.length() < 4)
//				switch ((integerPart.length() / 4) % 2) {
//					case 0:
//						chineseIntegerPart = TEN_MILLIONS + chineseIntegerPart;
//						break;
//					case 1:
//						chineseIntegerPart = TEN_THOUSANDS + chineseIntegerPart;
//						break;
//				}
//			chineseIntegerPart = getNumber(integerPart.substring(0, offset)) + chineseIntegerPart;
//		}
		//直接输出
		System.out.print(chineseIntegerPart);
		//小数部分的处理
		if (decimalPart == 0)
			//没有角分
			System.out.println("" + YUAN + ZHENG);
		else if (decimalPart < 10)
			//有分无角
			System.out.println("" + YUAN + DIGIT[decimalPart] + FEN);
		else if (decimalPart % 10 == 0)
			//有角无分
			System.out.println("" + YUAN + DIGIT[decimalPart / 10] + JIAO + ZHENG);
		else
			//有角有分
			System.out.println("" + YUAN + DIGIT[decimalPart / 10] + JIAO + DIGIT[decimalPart % 10] + FEN);

	}

	/**
	 * @param integer 数字转成的字符数组,长度(0,4]
	 * @apiNote 此方法将{@link String} digit转为大写
	 * 不用的想法
	 */
	@Deprecated
	static String getNumber(String integer) {
		String rtn = "";
		boolean zero = integer.charAt(integer.length() - 1) == '0';
		for (int i = integer.length() - 1; i > -1; i--) {
			if (integer.charAt(i) == 0) {
				if (!zero) {
					zero = true;
					rtn += getNumerals('0');
				}
			} else
				rtn += getNumerals(integer.charAt(i)) + units[i];
		}

		return ("".equals(rtn) && integer.length() == 4) ? rtn : getNumerals('0');
	}

	/**
	 * @param integer 输入一个整数片段,length[1,4]
	 *                该方法将输入的4位或以下整数片段转换成大写
	 */
	static String getChinese(String integer) {
		String rtn = "";//返回的字符串
		//先判断是不是需要返回"零",因为0000应该返回空串,只有"0"需要返回"零"
		//而"000","00"是不可能出现的
		if (integer.length() == 1 && integer.charAt(0) == '0')
			return getNumerals('0');
		//zero变量存储上一位是否为零
		boolean zero = false;
		//offset是integer.length()<4时候使用的偏移量
		int offset = 4 - integer.length();
		//一位一位解析
		for (int i = 0; i < integer.length(); i++) {
			//第i位为零,zero置为true,继续下一位
			if (integer.charAt(i) == '0') {
				zero = true;
			} else {
				//第i位不为'0',检查前一位是否为'0',是就加"零",zero置为false,说明这一位不是'0'
				if (zero) rtn += getNumerals('0');
				zero = false;
				//将大写非零数字和单位加到rtn字符串
				rtn += getNumerals(integer.charAt(i)) + units[i + offset];
			}
		}
		return rtn;
	}


	//	/**
//	 * @param digit 数字转成的字符数组
//	 * @param front 是否需要前导零
//	 * @apiNote 此方法将{@link String} digit转为大写,front标识是否需要前导零,
//	 * true为需要,false为不需要
//	 */
//	static String getNumerals(String digit, boolean front) {
//		String rtn = "";
//		//千位
//		if (front && digit.charAt(0) == '0') {//千位为零
//			rtn += getDigital('0');
//		} else if (digit.charAt(0) != '0') {//千位不为零
//			rtn += getDigital(digit.charAt(0));
//			rtn += THOUSAND;
//			//百位为零
//			if (digit.charAt(1) == '0') {
//				rtn += getDigital('0');
//			}
//		}
//		//百位不为零
//		if (digit.charAt(1) != '0') {
//			rtn += getDigital(digit.charAt(1));
//			rtn += HUNDRED;
//			//十位不为零
//			if (digit.charAt(2) == '0')
//				rtn += getDigital('0');
//		}
//		//十位
//		if (digit.charAt(2) != '0') {
//			rtn += getDigital(digit.charAt(2));
//			rtn += TEN;
//		}
//		//个位
//		if (digit.charAt(3) != '0') {
//			rtn += getDigital(digit.charAt(3));
//		}
//		return rtn;
//	}
	static String getNumerals(char digital) {
		return DIGIT[digital - 0x30];
	}

	/**
	 * 测试方法
	 */
	@Test
	public void test() {
		System.out.println(getChinese("1000"));
		System.out.println(getChinese("1001"));
		System.out.println(getChinese("1010"));
		System.out.println(getChinese("1011"));
		System.out.println(getChinese("1100"));
		System.out.println(getChinese("1101"));
		System.out.println(getChinese("1110"));
		System.out.println(getChinese("1111"));
		System.out.println(getChinese("0001"));
		System.out.println(getChinese("101"));
		System.out.println(getChinese("10"));
		System.out.println(getChinese("1"));
		System.out.println(getChinese("0000"));
		System.out.println(getChinese("0"));


	}
}
