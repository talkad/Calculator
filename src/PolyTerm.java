import Scalar.RationalScalar;
import Scalar.RealScalar;
import Scalar.Scalar;

public class PolyTerm {
	private Scalar coefficient;
	private int exponent;
	
	public PolyTerm(Scalar coefficient, int exponent) {
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
			throw new IllegalArgumentException("cannot add this poly term");
		if((pt.coefficient instanceof RealScalar) && (this.coefficient instanceof RealScalar)) {
			Scalar pos=new RealScalar(((RealScalar)pt.coefficient).getNum()+((RealScalar)this.coefficient).getNum());
			return new PolyTerm(pos, this.exponent);
		}
		else if((pt.coefficient instanceof RationalScalar) && (this.coefficient instanceof RationalScalar)) {
			Scalar pos=new RationalScalar(((RationalScalar)pt.coefficient).getNumerator(),((RationalScalar)pt.coefficient).getDivisor());
			pos.sum(this.coefficient);
			return new PolyTerm(pos, this.exponent);
		}
		else {
			if(pt.coefficient instanceof RealScalar) {
				double number=(((RealScalar)pt.coefficient).getNum()*((RationalScalar)this.coefficient).getDivisor())+((RationalScalar)this.coefficient).getNumerator();
				number=number/((RationalScalar)this.coefficient).getDivisor();
				Scalar pos=new RealScalar(number);
				return new PolyTerm(pos, this.exponent);
			}
			else {
				double number=(((RealScalar)this.coefficient).getNum()*((RationalScalar)pt.coefficient).getDivisor())+((RationalScalar)pt.coefficient).getNumerator();
				number=number/((RationalScalar)pt.coefficient).getDivisor();
				Scalar pos=new RealScalar(number);
				return new PolyTerm(pos, this.exponent);
			}
		}			
	}
	public PolyTerm mul(PolyTerm pt) {
		if((pt.coefficient instanceof RealScalar) && (this.coefficient instanceof RealScalar)) {
			Scalar pos=new RealScalar(((RealScalar)pt.coefficient).getNum()*((RealScalar)this.coefficient).getNum());
			return new PolyTerm(pos, this.exponent+pt.exponent);
		}
		else if((pt.coefficient instanceof RationalScalar) && (this.coefficient instanceof RationalScalar)) {
			Scalar pos=new RationalScalar(((RationalScalar)pt.coefficient).getNumerator(),((RationalScalar)pt.coefficient).getDivisor());
			pos.mul(this.coefficient);
			return new PolyTerm(pos, this.exponent+pt.exponent);
		}
		else {
			if(pt.coefficient instanceof RealScalar) {
				double number=((RealScalar)pt.coefficient).getNum()*((RationalScalar)this.coefficient).getNumerator();
				number=number/((RationalScalar)this.coefficient).getDivisor();
				Scalar pos=new RealScalar(number);
				return new PolyTerm(pos, this.exponent + pt.exponent);
			}
			else {
				double number=((RealScalar)this.coefficient).getNum()*((RationalScalar)pt.coefficient).getNumerator();
				number=number/((RationalScalar)pt.coefficient).getDivisor();
				Scalar pos=new RealScalar(number);
				return new PolyTerm(pos, this.exponent+pt.exponent);
			}
		}
	}
	public Scalar evaluate(Scalar scalar) {

		if((scalar instanceof RealScalar) && (this.coefficient instanceof RealScalar)) {
			double num=Math.pow(((RealScalar) scalar).getNum(), this.exponent);
			num=num*((RealScalar)this.coefficient).getNum();
			return new RealScalar(num);
		}
		else if((scalar instanceof RationalScalar) && (this.coefficient instanceof RationalScalar)) {
			int numerator=((RationalScalar)scalar).getNumerator();
			int divisor=((RationalScalar)scalar).getDivisor();
			for(int i=0;i<this.exponent;i++) {
				numerator=numerator*((RationalScalar)scalar).getNumerator();
				divisor=divisor*((RationalScalar)scalar).getDivisor();
			}
			RationalScalar pos= new RationalScalar(numerator, divisor);
			pos.mul(this.coefficient);
			return pos;
		}
		else {
			if(scalar instanceof RealScalar) {
				double num=Math.pow(((RealScalar) scalar).getNum(), this.exponent);
				num=num*((RationalScalar)this.coefficient).getNumerator();
				num=num/((RationalScalar)this.coefficient).getDivisor();
				return new RealScalar(num);
			}
			else {
				int numerator=((RationalScalar)scalar).getNumerator();
				int divisor=((RationalScalar)scalar).getDivisor();
				for(int i=0;i<this.exponent;i++) {
					numerator=numerator*((RationalScalar)scalar).getNumerator();
					divisor=divisor*((RationalScalar)scalar).getDivisor();
				}
				RealScalar pos= new RealScalar((numerator*((RealScalar)this.coefficient).getNum())/divisor);
				return pos;
			}
		}
	}
	public PolyTerm derivate() {
		if(this.coefficient instanceof RealScalar)
			return new PolyTerm(new RealScalar(((RealScalar)this.coefficient).getNum()+1), this.exponent-1);
		int numerator=0;
		numerator=((RationalScalar)this.coefficient).getNumerator()-((RationalScalar)this.coefficient).getDivisor();
		return new PolyTerm(new RationalScalar(numerator, ((RationalScalar)this.coefficient).getDivisor()) , this.exponent-1);
	}
	public boolean equals(PolyTerm pt) {
		if((pt.coefficient instanceof RealScalar) && (this.coefficient instanceof RealScalar)) {
			if(((RealScalar)pt.coefficient).getNum()!=((RealScalar)this.coefficient).getNum())
				return false;
			if(pt.exponent!=this.exponent)
				return false;
			return true;
		}
		else if((pt.coefficient instanceof RationalScalar) && (this.coefficient instanceof RationalScalar)) {
			if(((RationalScalar)pt.coefficient).getNumerator()!=((RationalScalar)this.coefficient).getNumerator())
				return false;
			if(((RationalScalar)pt.coefficient).getDivisor()!=((RationalScalar)this.coefficient).getDivisor())
				return false;
			if(pt.exponent!=this.exponent)
				return false;
			return true;
		}
		else {
			if(pt.coefficient instanceof RealScalar) {
				if(((RationalScalar)this.coefficient).getDivisor()!=1 || ((RationalScalar)this.coefficient).getNumerator()!=((RealScalar)pt.coefficient).getNum())
					return false;
				if(pt.exponent!=this.exponent)
					return false;
				return true;
			}
			else {
				if(((RationalScalar)pt.coefficient).getDivisor()!=1 || ((RationalScalar)pt.coefficient).getNumerator()!=((RealScalar)this.coefficient).getNum())
					return false;
				if(pt.exponent!=this.exponent)
					return false;
				return true;
			}
		}
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
		if(this.coefficient instanceof RealScalar)
			return ((RealScalar)this.coefficient).getNum() + "X^" +this.exponent;
		return ((RationalScalar)this.coefficient).getNumerator() +"/"+((RationalScalar)this.coefficient).getDivisor()  + "X^" +this.exponent;

	}
}
