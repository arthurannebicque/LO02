package main;

public class Gorpa extends Divinite{

	public void utiliserEffetDivinite(int cible, Partie p){ // Prends les pts action d'un joueur et les rajoute aux notres
		for (int i = 1; i<=3;i++){
			this.setPointAction(i, p.listeJoueur.get(cible).nombrePointAction[i]);
			p.listeJoueur.get(cible).nombrePointAction[i] =0;
		}
	}
	
}
