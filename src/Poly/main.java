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
		
		Polynomial p1=new Polynomial("x^2+x^4+3",false);
		Polynomial p2=new Polynomial("x^2+5",false);

		System.out.println(p2.add(p1));


	}
}
