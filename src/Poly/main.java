package Poly;
import java.util.*;

import Scalar.RationalScalar;
import Scalar.RealScalar;
import Scalar.Scalar;

public class main {
	public static void main(String[]args) {
//		PolyTerm pt=new PolyTerm(new RealScalar(1.2), 0);
//		System.out.println(pt.toString());
//		pt=pt.derivate();
//		System.out.println(pt.toString());
//		pt=pt.derivate();
//		System.out.println(pt.toString());
//
//		PolyTerm ptr=new PolyTerm(new RationalScalar(1,2), 1);
//		System.out.println(ptr.toString());
//		ptr=ptr.derivate();
//		System.out.println(ptr.toString());
//		ptr=ptr.derivate();
//		System.out.println(ptr.toString());
//		ptr=ptr.derivate();
//		System.out.println(ptr.toString());
		
		Polynomial p= new Polynomial("-19/3x^0+7/1x^1-7/2x^5");
		System.out.println(p);
	}
}
