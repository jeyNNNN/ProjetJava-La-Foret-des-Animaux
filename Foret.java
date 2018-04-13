public class Foret{
    public Case[][] foret;
    private int longueur;
    private int largeur;


    public Foret(int longueur, int largeur){
	foret = new Case[longueur][largeur];
	this.longueur = longueur;
	this.largeur = largeur;
    }

    public Foret(){
	foret = new Case[15][15];
	this.longueur = 15;
	this.largeur = 15;
    }

	public Case[][] getForet(){
		return foret;
	}


}
