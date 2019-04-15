package Poly;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Polynomial {
	
	private List<PolyTerm> list;
	
	public Polynomial(String polynom) {
		this.list=new LinkedList<>();
		String currentPoly="";
		for(int i=0;i<polynom.length();i++)
		{
			if((polynom.charAt(i)=='+' || polynom.charAt(i)=='-') &&  i!=0) {
				currentPoly=polynom.substring(0, i);
				PolyTerm poly=new PolyTerm(currentPoly);
				list.add(poly);
				int end=polynom.length();
				polynom=polynom.substring(i,end);
				i=0;
			}
			else if(i==polynom.length()-1){
				currentPoly=polynom.substring(0, i+1);
				PolyTerm poly=new PolyTerm(currentPoly);
				list.add(poly);
			}
		}					
	}
		
	public Polynomial add(Polynomial poly) {
		Polynomial pos=new Polynomial("");
		Iterator<PolyTerm> it1=this.list.iterator();
		Iterator<PolyTerm> it2=poly.list.iterator();
		while(it2.hasNext()) {
			PolyTerm current2=it2.next();
			boolean found=false;
			while(it1.hasNext() && !found) {
				PolyTerm current1=it1.next();
				if(current1.canAdd(current2)) {
					pos.list.add(current1.add(current2));
					found=true;
				}	
			}
			if(!found)
				pos.list.add(current2);
		}
		return pos;
	}
	
	public String toString() {
		return list.toString();
	}
}
