package Poly;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Polynomial {
	
	private List<PolyTerm> list;
	private boolean isRational; //true- it is a rational scalar. real scalar otherwise.
	
	public Polynomial(String polynom, boolean isRational) {
		this.isRational=isRational;
		this.list=new LinkedList<>();
		String currentPoly="";
		for(int i=0;i<polynom.length();i++)
		{
			if((polynom.charAt(i)=='+' || polynom.charAt(i)=='-') &&  i!=0) {
				currentPoly=polynom.substring(0, i);
				PolyTerm poly=new PolyTerm(currentPoly,isRational);
				list.add(poly);
				int end=polynom.length();
				polynom=polynom.substring(i,end);
				i=0;
			}
			else if(i==polynom.length()-1){
				currentPoly=polynom.substring(0, i);
				currentPoly=polynom.substring(0, i+1);
				PolyTerm poly=new PolyTerm(currentPoly,isRational);
				list.add(poly);
			}
		}					
	}
	
	public Polynomial(Polynomial poly) { //copy constructor
		this.list=new LinkedList<>();
		this.isRational=poly.isRational;
		Iterator<PolyTerm> it=poly.list.iterator();
		while(it.hasNext()) 
			list.add(it.next());
	}
			
		
	public boolean getIsRational() {return isRational; }
	
	public Polynomial add(Polynomial poly) { //still not working for all the cases
		Polynomial pos=new Polynomial(this);
		Iterator<PolyTerm> it1;		
		Iterator<PolyTerm> it2=poly.list.iterator();
		while(it2.hasNext()) {
			boolean found=false;
			PolyTerm current2=it2.next();
			it1=pos.list.iterator();	
			while(it1.hasNext() && !found) {
				PolyTerm current1=it1.next();
				if(current1.canAdd(current2)) {
					pos.list.remove(current1);
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
		Iterator<PolyTerm> it=this.list.iterator();
		String output="";
		PolyTerm term;
		int count=0;
		while(it.hasNext()) {
			term=it.next();
			if(count>0 && term.toString().charAt(0)!='-')
				output+="+";
			output+=term;
			count++;
		}
		return output;
	}
}
