package Scalar;

public class RealScalar implements Scalar{

	private double num;
	
	public RealScalar(double num) {
		this.num=num;
	}

	public double getNum() { return num; }
		
	
	public Scalar add(Scalar s) {
		double n;
		if(!(s instanceof RealScalar))
			throw new RuntimeException("Not a real Scalar");
		RealScalar scalar=(RealScalar)s;
		n=num+scalar.getNum();
		return new RealScalar(n);
	}
	
	public Scalar mul(Scalar s) {
		double n;
		if(!(s instanceof RealScalar))
			throw new RuntimeException("Not a real Scalar");
		RealScalar scalar=(RealScalar)s;
		n=num*scalar.getNum();
		return new RealScalar(n);
	}
	
	public Scalar mul(int num) {
		return new RealScalar(num*getNum());
	}
	
	public Scalar pow(int exponent) {
		double n;
		n=Math.pow(num, exponent);
		return new RealScalar(n);
	} 
	
	public Scalar neg() {
		double n;
		n=(-1)*getNum();
		return new RealScalar(n);
	} 
	
	public boolean equals(Scalar s) {
		if(!(s instanceof RealScalar))
			throw new RuntimeException("Not a real Scalar");
		RealScalar scalar=(RealScalar)s;
		return num==scalar.getNum();	
	} 
	
	public String toString() {
		String pos=String.valueOf(num);
		String temp=pos.substring(pos.indexOf('.'));
		if(temp.length()!=-1 && temp.length()>4 && pos.length()>4)
			return pos.substring(0, pos.indexOf('.'))+ pos.substring(pos.indexOf('.'), pos.indexOf('.')+4);
		return pos;
	}
}
