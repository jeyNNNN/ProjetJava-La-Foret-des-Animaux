public class Foret{
    public Case[][] foret;
    private int longueur;
    private int largeur;

    ////////////////////////////CONSTRUCTEURS////////////////////////////
    public Foret(int longueur, int largeur){
	foret = new Case[longueur][largeur];
	this.longueur = longueur;
	this.largeur = largeur;
    }

    public Foret(){
	foret = new Case[10][10];
	this.longueur = 10;
	this.largeur = 10;
    }


    ////////////////////////////GETTEURS////////////////////////////
    public Case[][] getForet(){
	return foret;
    }
	
    public int getLongueur(){
	return longueur;
    }
	
    public int getLargeur(){
	return largeur;
    }
	
    
    ////////////////////////////UTILITAIRES////////////////////////////
    public void initForet(){
	for(int i=0;i<longueur;i++){
	    for(int j=0;j<largeur;j++){
		foret[i][j]= new Case();
		foret[i][j].initAleaCase();
	    }
	}
    }
	
    public void addAnimal(Animal a){
	foret[a.getX()][a.getY()].ajouterAnimal(a);
    }
	
    public Foret refreshForet(){
	Foret foretStock = this.clone();
	for(int i=0;i<longueur;i++){
	    for(int j=0;j<largeur;j++){
		if (!(foret[i][j].animaux.isEmpty())){
		    for(int k=0;k<foret[i][j].animaux.size();k++){
			foret[i][j].getAnimaux().get(k).marcher();
			if(foret[i][j].getAnimaux().get(k) instanceof Loup){
			    ((Loup)(foret[i][j].getAnimaux().get(k))).sentirProie(this);
			}
						
						
			foretStock.addAnimal(foret[i][j].animaux.get(k));
		    }
		}
	    }
	}
	foretStock.afficherForet();

	return foretStock;
    }
	
    public Foret clone(){
	Foret CloneForet;
	CloneForet = new Foret(this.longueur, this.largeur);
	CloneForet.foret = new Case[longueur][largeur];
		
		
	for(int i=0;i<longueur;i++){
	    for(int j=0;j<largeur;j++){
		CloneForet.foret[i][j] = foret[i][j].clone();
	    }
	}
	return CloneForet;
    }
	
	
    public void afficherForet(){
	System.out.println("_ _ _ _ _ _ _ _ _ _");
	for(int i=0;i<longueur;i++){
	    for(int j=0;j<largeur;j++){
		if (foret[i][j].getTerrain() instanceof Verdure){
		    System.out.print("V : ");
		}
		if (foret[i][j].getTerrain() instanceof Terre){
		    System.out.print("T : ");
		}
		if (foret[i][j].getTerrain() instanceof Eau){
		    System.out.print("E : ");
		}
		foret[i][j].afficherAnimaux();
		
		System.out.print("\t");
	    }
	    System.out.print("\n");
	}
    }

}
