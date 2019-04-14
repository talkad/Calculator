import java.util.*;

import Scalar.RationalScalar;
import Scalar.RealScalar;
import Scalar.Scalar;

public class main {
	public static void main(String[]args) {
		PolyTerm pt=new PolyTerm(new RealScalar(1.2), 2);
		PolyTerm ptr=new PolyTerm(new RationalScalar(2, 3), 2);
		Scalar r=ptr.evaluate(new RealScalar(3));
		System.out.println(r.toString());
	}
}
