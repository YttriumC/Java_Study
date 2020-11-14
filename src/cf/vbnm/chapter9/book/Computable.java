package cf.vbnm.chapter9.book;

public interface Computable<E extends Number>  {
	E compute(Operate operate) throws ComputerException;
}
