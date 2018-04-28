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
		        
		        
		    // Marcher
			foret[i][j].getAnimaux().get(k).marcher();
			
			// Sentir + Chasser + Fuir
			// Une fois tous les prédateurs en place 
			// A la place de instanceof Loup ===> instanceof Predateur
			
			if(foret[i][j].getAnimaux().get(k) instanceof Loup){
			    ((Loup)(foret[i][j].getAnimaux().get(k))).sentirProie(this);
			}
			
			// Manger eventuellement seBattre à rajouter
			mangerList(foret[i][j].getAnimaux());
			foretStock.addAnimal(foret[i][j].animaux.get(k));
		    }
		}
	    }
	}
	foretStock.afficherForet();

	return foretStock;
    }
	
	
	
	// ++ Rajouter seBattre ???
	public void mangerList(ArrayList<Animal> list){
	    for(Animal a : list){
	        for(Animal b : list){
	            
	            // Remplacer Loup par prédateur une fois tout en place
	            if(a instanceof Loup){
	                if(((Loup)(a)).estProie(b)){
	                    
	                    
	                    list.remove(b);
	                    // Rappel de manger sur la list car comme la liste à changer de size, si on ne rappelle pas segmentation fault
	                    // eventuellement créer un attribut rassasié, qui empêche un loup de manger 2 proies ???
	                    mangerList(list);
	                    
	                    // Pour sortir & éviter le segmentation fault
	                    return;
	                }
	            }
	        }
	    }
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
