package HeugueXavier.TP7;

public class Joueur {
	private String nom;
	private Paquet paquet;
	private int nbPoints = 0;
	
	/**
	 * Permet de créer un joueur
	 * @param nbnombre de carte dans le paquet
	 * @param nom Le nom du joueur
	 * @throws Exception
	 */
	public Joueur(int nb, String nom){
		this.nom = nom;
		try{
			paquet = new Paquet(nb);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.exit(1);
		}
	}
	/**
	 * Permet de récupérer le paquet
	 * @return le paquet du joueur
	 */
	public Paquet getPaquet(){
		return paquet;
	}
	
	/**
	 * Permet de récupérer le nom du joueur
	 * @return le nom du joueur
	 */
	public String getNom(){
		return nom;
	}
	/**
	 * Permet de récupérer le nombre de points du joueur
	 * @return le nombre du points du joueur
	 */
	public int getNbPoints(){
		return nbPoints;
	}
	
	public void incrementerPoints(int i){
		nbPoints+=i;
	}
}
