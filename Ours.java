import java.lang.Math;

public class Ours extends Animal implements ATerrestre, Predateur{
    private int directionX;
    private int directionY;
    private final static int odorat = 3;
	private final static int vitesse = 2;
    
    
    ///////////////CONSTRUCTEURS//////////////////
    
    public Ours(int x, int y, int age, char sexe){
	super(x,y,age,sexe);
	directionX = (int)Math.random();
	directionY = (int)Math.random();
    }
    
    public Ours(int x, int y){
        super(x,y);
	directionX = (int)Math.random();
	directionY = (int)Math.random();
    }

    public Ours(){
	super();
	directionX = (int)Math.random();
	directionY = (int)Math.random();
    }


    public void marcher(){
	x += directionX;
	y += directionY;
    }

    public boolean estProie(Animal a){
	if(a instanceof Renard)
	    return true;
	if(a instanceof Lapin)
	    return true;
	if(a instanceof Cerf)
	    return true;
	
	return false;
    }
    
    public double attaquer(){
	return Math.random()*Constante.JetOff + Constante.attaqueOurs;//nombre à revoir
    }    
    
    
/*
    //Deplacement aléatoire pour l'instant
    public boolean seDeplacer(){
        int deplacement = (int)(Math.random() * 5);
        
        // Ours temp = arraylist.remove du bon objet 
        // (avec boucle pour parcourir tous les animaux & les comparer on l'a vue en cours mais je m'en souviens plus)
        
        
        
        // 4 = pas de déplacement
        if(deplacement < 4){
            if(deplacement == 0){
                if(super.x > 0){
                    super.x = super.x - 1;
                    // Changement dans l'arrayList
                }
            }
            else{
                if(deplacement == 1){
                    if(super.x < super.MaForet.getTaille() - 1){
                        super.x = super.x + 1;
                        // Changement dans l'arraylist
                    }
                }
                else{
                    if(deplacement == 2){
                        if(super.y > 0){
                            super.y = super.y - 1;
                            // Changement dans l'arraylist
                        }
                    }
                    else{
                        if(super.y < super.MaForet.getTaille() - 1){
                            super.y = super.y + 1;
                            // Changement dans l'arraylist
                        }
                    }
                }
            }   
        }
        
        // (case)(MaForet.matrice[super.x][super.y]).listeAnimal.add(temp)
        // On ajoute l'animal dans son nouveau foyer de réconfort
        return true;
        
    } 
    
*/
    
}
