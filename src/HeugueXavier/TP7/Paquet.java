package HeugueXavier.TP7;

public class Paquet {
	private Carte[] paquet;
	public static final int MAX = 52;
	private int nombreCarte=0;
	
	/**
	 * Permet de construire un paquet de taille maximale
	 */
	public Paquet() throws Exception{
		this(MAX);
	}
	
	/**
	 * permet de construire un paquet de taille voulu (max 52 cartes)
	 * @param nombreCarte le nombre de carte
	 * @throws Exception Lance une exception si le nombre de carte est incorrecte
	 */
	public Paquet(int nombreCarte) throws Exception{
		if (nombreCarte>MAX || nombreCarte <= 0)
			throw new Exception("Nombre de carte incorrect");
		
		paquet = new Carte[nombreCarte];
	}
	
	/**
	 * Permet de générer des cartes dans un paquet
	 * @throws Exception
	 */
	public void remplir() throws Exception{
		int couleur=1;
		int face=1;
		while(nombreCarte < paquet.length)
		{
			if(face == 14)
			{
				face = 1;
				couleur++;
			}
			paquet[nombreCarte] = new Carte(face,couleur);
			face++;
			nombreCarte++;
		}
	}
	/**
	 * Permet de mélanger le paquet
	 */
	public void melanger(){
		Carte tmp;
		int rand;
		for (int i=0; i<paquet.length; i++)
		{
			rand = (int)(Math.random()*52);
			tmp = paquet[i];
			paquet[i] = paquet[rand];
			paquet[rand] = tmp;
		}
	}
	/**
	 * Permet de piocher une carte
	 * @return une carte
	 * @throws Exception
	 */
	public Carte pioche() throws Exception{
		if (nombreCarte <= 0)
			throw new Exception("Plus de carte");
		nombreCarte--;
		Carte piocher = paquet[nombreCarte];
		paquet[nombreCarte]=null;
		return piocher;
	}
	/**
	 * Permet de savoir si le paquet est vide
	 * @return vrai si le paquet est vide, faux sinon.
	 */
	public boolean estVide(){
		return nombreCarte==0;
	}
	/**
	 * Permet de mettre une carte dans le paquet
	 * @param c une carte
	 */
	public void recevoir(Carte c){
		paquet[nombreCarte] = c;
		nombreCarte++;
	}
	/**
	 * Permet de mettre un nombre donné de carte dans un paquet
	 * @param nb le nombre de carte à mettre
	 * @param p le paquet à remplir
	 * @throws Exception Lance une exception si le nombre entré est supérieur au nombre de carte du paquet actuel
	 */
	public void transvaser(int nb, Paquet p)throws Exception{
		if (nb>nombreCarte)
			throw new Exception("Il n'y a pas assez de carte dans le jeu");
		for (int i = 0; i < nb; i++)
		{
			p.recevoir(paquet[nombreCarte]);
			nombreCarte--;
		}
	}
	/**
	 * Permet de creer un Str ayant le contenu du paquet
	 */
	public String toString(){
		StringBuffer txt = new StringBuffer();
		for (int i=0; i<nombreCarte;i++)
			txt.append(paquet[i].toString());
		return new String(txt);
	}
	/**
	 * Permet de connaitre le nombre de carte présent dans le paquet
	 * @return le nombre de carte dans le paquet.
	 */
	public int getNombreCarte(){
		return nombreCarte;
	}
	/**
	 * permet de retourner une carte
	 * @return retourne une carte du paquet
	 * @param l'index
	 * @throws Exception lancé si index en dehors du champs de carte disponible
	 */
	public Carte getCarte(int i) throws Exception{
		if(i > nombreCarte-1 || i < 0)
			throw new Exception("Index out of Array :" + i + ". Limit : 0 to "+(nombreCarte-1));
		return paquet[i];
	}
	
	public int comptePoint() throws Exception{
		int points=0;
		int nbCarte = getNombreCarte();
		Face tmp;
		for(int i = 0; i < nbCarte; i++)
		{
			points+=pioche().getValeur();
		}
		return points;
	}
}
