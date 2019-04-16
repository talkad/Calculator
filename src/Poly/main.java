package Poly;
import java.util.*;

import Scalar.RationalScalar;
import Scalar.RealScalar;
import Scalar.Scalar;

public class main {
	public static void main(String[]args) {
//		
//		PolyTerm pt=new PolyTerm(new RealScalar(1.2), 0);
//		System.out.println(pt.toString());
//		pt=pt.derivate();
//		System.out.println(pt.toString());
//		pt=pt.derivate();
//		System.out.println(pt.toString());
//
//		PolyTerm ptr=new PolyTerm(new RationalScalar(3,4), 2);
//		System.out.println(ptr.toString());
//		ptr=ptr.derivate();
//		System.out.println(ptr.toString());
//		ptr=ptr.derivate();
//		System.out.println(ptr.toString());
//		ptr=ptr.derivate();
//		System.out.println(ptr.toString());
		
		Polynomial p1=new Polynomial("-x^1+1",false);
		Polynomial p2=new Polynomial("-1/1x^2+3x^4",false);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.add(p2));
		
		Polynomial p3=new Polynomial("x^3+1",false);
		Polynomial p4=new Polynomial("x^2+3x^4",false);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p3.mul(p4));
		
		Scalar scalar=new RealScalar(2);
		System.out.println(p3.evaluate(scalar));
		System.out.println(p4.evaluate(scalar));
		Polynomial p5=new Polynomial("1/2x^2",true);
		Scalar scalar2=new RationalScalar(6,2);
		System.out.println(p5.evaluate(scalar2));
		
		Polynomial p6=new Polynomial("-7x^1+2x^2+x^3+1",false);
		System.out.println(p6.derivate());



	}
}
