package main;

import java.util.ArrayList;

public class Effet14 implements Effet {//id = 50 Sacrifie un Guide Spirituel, si lui ou sa Divinité ne croit pas au Dogme Chaos. Les capacités spéciales sont jouées normalement.




	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		boolean boucle =true;
		int n = 0;
		int i =0;
		while (boucle && n<listejoueur.size()){
			if (listejoueur.get(n) != listejoueur.get(j)){
				while (boucle && i<listejoueur.get(n).guidePossede.size()){
					if ((listejoueur.get(n).Divinite.natureCarte1 !=2 || listejoueur.get(n).Divinite.natureCarte2 != 2 || listejoueur.get(n).Divinite.natureCarte3 != 2)|| (listejoueur.get(n).guidePossede).get(i).natureCarte1 != 2 || listejoueur.get(n).guidePossede.get(i).natureCarte2 != 2 || listejoueur.get(n).guidePossede.get(i).natureCarte3 !=2){
						//listejoueur.get(n).guidePossede.get(i).utiliserDivinite();
						for (int c = 0; c<= listejoueur.get(n).guidePossede.get(0).croyantPossede.size();c++){
							table.add(listejoueur.get(n).guidePossede.get(0).croyantPossede.get(c));
							listejoueur.get(n).guidePossede.get(0).croyantPossede.remove(c);
						}
						boucle = false;
					}
					i++;
					}
				n++;
				}
				
				
			}
			
			
			
		}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}
		
	}
	
	


