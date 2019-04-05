package Scalar;

public interface Scalar {
		
	public Scalar sum(Scalar s);
	public Scalar mul(Scalar s);
	public Scalar pow(int exponent);
	public Scalar neg();	
	public boolean equals(Scalar s);
	public String toString();
	
	/*
	 * You can extend this interface / abstract class with reasonable methods
that you find necessary to complete the task (Think about derivate of a
poly term – what is missing?).
	 */
}
