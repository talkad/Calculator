package Poly;
import Scalar.RationalScalar;
import Scalar.RealScalar;
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
	
	public PolyTerm(String polyterm) {
		if(polyterm==null)
			throw new IllegalArgumentException("polyterm cannot be null");
		String coefficient="";
		int index=0;
		while(index<polyterm.length() && polyterm.charAt(index)!='x' ) {
			coefficient+=polyterm.charAt(index);
			index++;
		}
		
		int exp_index=polyterm.indexOf('^');
		if(exp_index!=-1) {
			String exponent=polyterm.substring(exp_index+1, polyterm.length());
			this.exponent=Integer.parseInt(exponent);
		}
		else
			this.exponent=0;
		if(coefficient.contains("/")) {
			String numerator="", divisor="";
			index=0;
			while(coefficient.charAt(index)!='/')
			{
				numerator+=coefficient.charAt(index);
				index++;
			}
			index++;
			while(index!=coefficient.length()) {
				divisor+=coefficient.charAt(index);
				index++;
			}
			this.coefficient=new RationalScalar(Integer.parseInt(numerator), Integer.parseInt(divisor));
		}
	else {
			this.coefficient=new RealScalar(Double.parseDouble(coefficient));
		}
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
