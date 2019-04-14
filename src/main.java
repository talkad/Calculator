import java.util.*;

import Scalar.RationalScalar;
import Scalar.RealScalar;
import Scalar.Scalar;

public class main {
	public static void main(String[]args) {
		PolyTerm pt=new PolyTerm(new RealScalar(1.2), 2);
		Scalar r=new RealScalar(172.242111);
		System.out.println(r.toString());
		PolyTerm ptr= pt.add(new PolyTerm(r,2));
		System.out.println(ptr.toString());
		ptr=pt.mul(new PolyTerm(r,2));
		System.out.println(ptr.toString());

		
	}
}
