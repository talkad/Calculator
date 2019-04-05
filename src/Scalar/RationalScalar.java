package Scalar;

public class RationalScalar implements Scalar{

	private int numerator;
	private int divisor;
	
	public RationalScalar(int numerator, int divisor) {
		if (divisor == 0) 
		    throw new IllegalArgumentException("You can't divide by zero");
		this.numerator=numerator;
		this.divisor=divisor;
	}
	
	public int getNumerator() { return numerator; }
	
	public int getDivisor() { return divisor; }
	
	//find the great common divisor and edit the rational scalar respectively
	private void gcd() {
	    int m = numerator;
	    int n = divisor;
	    int r = m%n;
	    while (r != 0) {
			m=n;
	        n=r; 
	        r = m%n;
	    }
	    numerator=numerator/n;
	    divisor=divisor/n;
	}
	
	public Scalar sum(Scalar s) {
		if(!(s instanceof RationalScalar))
			throw new RuntimeException("Not a rational Scalar");
		RationalScalar scalar=(RationalScalar)s;
		numerator=(numerator*scalar.divisor)+(divisor*scalar.numerator);
		divisor=this.divisor*scalar.divisor;
		gcd();
		return this;
	}
	
	public Scalar mul(Scalar s) {
		if(!(s instanceof RationalScalar))
			throw new RuntimeException("Not a rational Scalar");
		RationalScalar scalar=(RationalScalar)s;
		numerator=numerator*scalar.divisor;
		divisor=this.divisor*scalar.divisor;
		gcd();
		return this;	
		} 
	
	public Scalar pow(int exponent) {
		for(int i=0;i<exponent;i++) {
			numerator*=numerator;
			divisor*=divisor;
		}
		gcd();
		return this;
	} 
	
	public Scalar neg() {
		numerator*=(-1);
		return this;
	} 
	
	public boolean equals(Scalar s) {
		if(!(s instanceof RationalScalar))
			throw new RuntimeException("Not a rational Scalar");
		RationalScalar scalar=(RationalScalar)s;
		return numerator==scalar.getNumerator() & divisor==scalar.getDivisor();	
	} 
	
	public String toString() {
		return numerator+"/"+divisor;
	}
}
