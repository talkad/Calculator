package Poly;
import Scalar.Scalar;

public class PolyTerm {
	private Scalar coefficient;
	private int exponent;
	
	public PolyTerm(Scalar coefficient, int exponent) {
		if(exponent<0)
			throw new IllegalArgumentException("input wrong! exponent should be non-negative");
		this.coefficient=coefficient;
		this.exponent=exponent;
	}
	
	public boolean canAdd(PolyTerm pt) {
		if(pt.exponent==this.exponent)
			return true;
		return false;
	}
	
	public PolyTerm add(PolyTerm pt) {
		if(!this.canAdd(pt))
			throw new IllegalArgumentException("cannot add this polyterm");
		Scalar pos=	this.coefficient.add(pt.getCoefficient());
		return new PolyTerm(pos, this.exponent);
	}
	
	public PolyTerm mul(PolyTerm pt) {
		Scalar pos=	this.coefficient.mul(pt.getCoefficient());
		return new PolyTerm(pos, this.exponent+pt.getExponent());
	}
	
	public Scalar evaluate(Scalar scalar) {
		return (scalar.pow(this.exponent)).mul(this.coefficient);
	}
	
	public PolyTerm derivate() {
		Scalar pos=this.coefficient.mul(this.exponent);
		if(this.exponent>0)
			return new PolyTerm(pos,this.exponent-1);
		if(this.exponent>=0)
			return new PolyTerm(pos,this.exponent);
		throw new IllegalArgumentException("the exponent wrong, less than 0");
	}
	
	public boolean equals(PolyTerm pt) {
		return this.equals(pt);
	}
	
	public int getExponent() {
		return this.exponent;
	}
	public void setExponent(int exponent) {
		this.exponent=exponent;
	}
	public Scalar getCoefficient() {
		return this.coefficient;
	}
	public void setCoefficient(Scalar coefficient) {
		this.coefficient=coefficient;
	}
	
	public String toString() {
		if(this.exponent>=1)
			return this.coefficient.toString()+"X^"+this.exponent;
		return this.coefficient.toString();
	}
}
