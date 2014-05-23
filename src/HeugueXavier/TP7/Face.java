package HeugueXavier.TP7;

public enum Face {
	Deux("2"),
	Trois("3"),
	Quatre("4"),
	Cinq("5"),
	Six("6"),
	Sept("7"),
	Huit("8"),
	Neuf("9"),
	Dix("10"),
	Valet("valet"),
	Dame("Dame"),
	Roi("Roi"),
	As("as");
	
	private String nom;
	
	private Face(String nom){
		this.nom = nom;
	}
	
	public String toString(){
		return nom;
	}
}
