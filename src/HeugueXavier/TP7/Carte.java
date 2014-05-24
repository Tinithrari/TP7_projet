package HeugueXavier.TP7;

/**
 * Classe représentant une carte logique
 * @author Tinithrari
 *
 */
public class Carte {
	private Face face;
	private Couleur couleur;
	private int valeur;
	
	/**
	 * @param face valeur de la face
	 * @param couleur valeur de la couleur
	 * @throws Exception
	 */
	public Carte(int face, int couleur) throws Exception{
		switch(face){
		case 1:
			this.face = Face.As;
			break;
			
		case 2:
			this.face = Face.Deux;
			break;
			
		case 3:
			this.face = Face.Trois;
			break;
		case 4:
			this.face = Face.Quatre;
			break;
		case 5:
			this.face = Face.Cinq;
			break;
			
		case 6:
			this.face = Face.Six;
			break;
		case 7:
			this.face = Face.Sept;
			break;
		case 8:
			this.face = Face.Huit;
			break;
		case 9:
			this.face = Face.Neuf;
			break;
		case 10:
			this.face = Face.Dix;
			break;
		case 11:
			this.face = Face.Valet;
			break;
		case 12:
			this.face = Face.Dame;
			break;
		case 13:
			this.face = Face.Roi;
			break;
		default:
			throw new Exception("Face incorrecte");
		}
		
		switch (couleur){
		case 1:
			this.couleur = Couleur.Coeur;
			break;
		case 2:
			this.couleur = Couleur.Carreau;
			break;
		case 3:
			this.couleur = Couleur.Trefle;
			break;
		case 4:
			this.couleur = Couleur.Pique;
			break;
		default:
			throw new Exception("Couleur Incorrecte");
		}
		if (face==1)
			this.valeur = 14;
		else
			this.valeur = face;
	}

	/**
	 * Permet d'obtenir la valeur d'une carte
	 * @return face de la carte
	 */
	public Face getFace(){
		return face;
	}
	/**
	 * Permet de savoir si la carte actuel est plus grande que la carte actuel
	 * @param c une carte
	 * @return vrai la carte est plus grande, faux sinon
	 */
	public boolean estPlusGrande(Carte c){
		if (face.compareTo(c.getFace())>0)
			return true;
		return false;
	}
	/**
	 * Permet de savoir si la carte actuel à la même valeur que la carte entrée en paramètre
	 * @param c Une carte
	 * @return Vrai si égales, faux sinon
	 */
	public boolean estEgaleA(Carte c){
		if (face.compareTo(c.getFace())==0)
			return true;
		return false;
	}
	/**
	 * Permet de retourner une chaine de caractère indiquant les valeurs de la carte
	 */
	public String toString(){
		return face+" de "+couleur;
	}
	
	/**
	 * Permet de retourner la valeur de la carte
	 * @return La valeur de la carte (int)
	 */
	
	public int getValeur(){
		return valeur;
	}
	
	public Couleur getCouleur(){
		return couleur;
	}
	
	public boolean equals(Carte c){
		return face==c.getFace() && couleur==c.getCouleur();
	}
}
