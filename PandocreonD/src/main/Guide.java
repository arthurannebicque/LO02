package main;
import java.util.*;

public class Guide extends Carte{
	
	protected ArrayList<Guide> guidePossede;
	protected ArrayList<Croyant> croyantPossede;
	
	public Guide(){
		super();
		guidePossede = new ArrayList<Guide>();
		croyantPossede = new ArrayList<Croyant>();
		
		
	}

	public Guide(String string, int i, int j, int k, int l, int m, int n, int o) {
		super(string,i,j,k,l,m,n,o);
		// TODO Auto-generated constructor stub
	}
}
