package cf.vbnm.chapter9.book.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Computer implements Computable<BigDecimal> {
	private BigDecimal number1, number2;

	public void setNumber1(BigDecimal number1) {
		this.number1 = number1;
	}

	public void setNumber2(BigDecimal number2) {
		this.number2 = number2;
	}


	@Override
	public BigDecimal compute(Operate operate) throws ComputerException {
		if (operate == Operate.Add)
			return number1.add(number2, new MathContext(15, RoundingMode.HALF_UP));
		if (operate == Operate.Subtract)
			return number1.subtract(number2, new MathContext(15, RoundingMode.HALF_UP));
		if (operate == Operate.Multiply)
			return number1.multiply(number2, new MathContext(15, RoundingMode.HALF_UP));
		if (operate == Operate.Divide) {
			if (number2.equals(BigDecimal.ZERO))
				throw new ComputerException();
			return number1.divide(number2, new MathContext(15, RoundingMode.HALF_UP));
		}
		return null;
	}

}

