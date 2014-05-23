package HeugueXavier.TP7;

/**
 * Classe contenant le processus de la bataille
 * @author Tinithrari
 *
 */
public class Jeu {
	private Joueur j1;
	private Joueur j2;
	private Paquet jeuDeDepart,enJeu;
	private static final int MAX = 5;
	
	/**
	 * Permet de générer un jeu logique contenant 2 joueur(1 humain, 1 machine)
	 * @param nom Le nom du joueur
	 */
	public Jeu(String nom) throws Exception{
		Joueur j1 = new Joueur(26,nom);
		Joueur j2 = new Joueur(26,"Ordinateur");
	}
	
	private void distribuer() throws Exception{
		jeuDeDepart.transvaser(Paquet.MAX/2,j1.getPaquet());
	}
	/**
	 * Initialise le jeu
	 * @throws Exception
	 */
	public void initialisation() throws Exception{
		try{
		jeuDeDepart.remplir();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.exit(1);
		}
		jeuDeDepart.melanger();
		distribuer();
	}
	/**
	 * Cela permet de lancer le jeu
	 * @throws Exception
	 */
	public void lancerTour() throws Exception{
		enJeu.recevoir(j1.getPaquet().pioche());
		enJeu.recevoir(j2.getPaquet().pioche());
		if (enJeu.getCarte(enJeu.getNombreCarte()-1).estPlusGrande(enJeu.getCarte(enJeu.getNombreCarte()-2)))
			j2.incrementerPoints(enJeu.comptePoint());
		else if (enJeu.getCarte(enJeu.getNombreCarte()-2).estPlusGrande(enJeu.getCarte(enJeu.getNombreCarte()-1)))
			j1.incrementerPoints(enJeu.comptePoint());
	}
}
