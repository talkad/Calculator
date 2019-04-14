package Scalar;

public class RealScalar implements Scalar{

	private double num;
	
	public RealScalar(double num) {
		this.num=num;
	}

	public double getNum() { return num; }
		
	
	public Scalar sum(Scalar s) {
		if(!(s instanceof RealScalar))
			throw new RuntimeException("Not a real Scalar");
		RealScalar scalar=(RealScalar)s;
		num=num+scalar.getNum();
		return this;
	}
	
	public Scalar mul(Scalar s) {
		if(!(s instanceof RealScalar))
			throw new RuntimeException("Not a real Scalar");
		RealScalar scalar=(RealScalar)s;
		num=num*scalar.getNum();
		return this;	
		} 
	
	public Scalar pow(int exponent) {
		num=Math.pow(num, exponent);
		return this;
	} 
	
	public Scalar neg() {
		num*=(-1);
		return this;
	} 
	
	public boolean equals(Scalar s) {
		if(!(s instanceof RealScalar))
			throw new RuntimeException("Not a real Scalar");
		RealScalar scalar=(RealScalar)s;
		return num==scalar.getNum();	
	} 
	
	public String toString() {
		return num+"";
	}
}
