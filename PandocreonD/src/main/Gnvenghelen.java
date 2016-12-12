package main;

public class Gnvenghelen extends Divinite{

	
	public void utiliserEffetDivinite(int cible, Partie p){ // Recupère autant de point supp d'origine Néant que de guide sprituel que la cible possède
		this.setPointAction(3, p.listeJoueur.get(cible).guidePossede.size() );
	}
}
