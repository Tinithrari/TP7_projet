package HeugueXavier.TP7;
public enum Couleur {
	Coeur("Coeur"),
	Carreau("Carreau"),
	Trefle("Trefle"),
	Pique("Pique");
	
	private String appelation;
	
	private Couleur (String appelation){
		this.appelation = appelation;
	}
	
	public String toString(){
		return appelation;
	}
}
