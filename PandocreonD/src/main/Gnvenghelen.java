package main;

public class Gnvenghelen extends Divinite{

	
	public void utiliserEffetDivinite(int cible, Partie p){ // Recup�re autant de point supp d'origine N�ant que de guide sprituel que la cible poss�de
		this.setPointAction(3, p.listeJoueur.get(cible).guidePossede.size() );
	}
}
