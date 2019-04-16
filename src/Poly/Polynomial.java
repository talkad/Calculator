package Poly;
import java.util.Collections;
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
			
			
	public Polynomial add(Polynomial poly) {
		if((poly.isRational && !this.isRational) || (!poly.isRational && this.isRational))
			throw new IllegalArgumentException("cannot add two different objects");
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
	
	public List<PolyTerm> getList(){ return this.list; }

	public boolean getIsRational() {return isRational; }

	
	public String toString() {
		Collections.sort(list);
		Iterator<PolyTerm> it=this.list.iterator();
		String output="";
		PolyTerm current;
		while(it.hasNext()) {
			current=it.next();
			if(current.toString().charAt(0)=='-')
				output+=current.toString();
			else
				output+="+"+current.toString();
			
			counter++;
		}
		if(output.charAt(0)=='+')
			return output.substring(1);
		return output;
	}
}
