package Calculator;

public class Scalar {
	
	private int number;
	
	public Scalar(int num) {
		number=num;
	}
	
	public int getNum() { return number; }
	
	public Scalar sum(Scalar s) {
		return new Scalar(number+s.getNum());
	}
	
	public Scalar mul(Scalar s) {
		return new Scalar(number*s.getNum());
	} 
	
	public Scalar pow(Scalar exponent) {
		return new Scalar((int)Math.pow(number, exponent.getNum()));
	} 
	
	public Scalar neg() {
		return new Scalar(number*(-1));
	} 
	
	public boolean equals(Scalar s) {
		return number==s.getNum();
	} 
	
	/*
	 * You can extend this interface / abstract class with reasonable methods
that you find necessary to complete the task (Think about derivate of a
poly term – what is missing?).
	 */
}
