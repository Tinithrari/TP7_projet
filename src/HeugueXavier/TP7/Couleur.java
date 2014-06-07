package HeugueXavier.TP7;
public enum Couleur {
	Coeur("coeur"),
	Carreau("carreau"),
	Trefle("trefle"),
	Pique("pique");
	
	private String appelation;
	
	private Couleur (String appelation){
		this.appelation = appelation;
	}
	
	public String toString(){
		return appelation;
	}
}
