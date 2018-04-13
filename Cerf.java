import java.lang.Math;

public class Cerf extends Animal implements Proie, ATerrestre{
    private int directionX;
    private int directionY;
    private final static int odorat = 3;
	private final static int vitesse = 4;
    
///////////////CONSTRUCTEURS//////////////////
    public Cerf(int x, int y, int age, char sexe){
	super(x,y,age,sexe);
	directionX = (int)Math.random();
	directionY = (int)Math.random();
    }

    public Cerf(int x, int y){
        super(x,y);
	directionX = (int)Math.random();
	directionY = (int)Math.random();
    }

    public Cerf(){
	super();
	directionX = (int)Math.random();
	directionY = (int)Math.random();
    }
    
    // Marche sur une base 100, celui qui a le score le plus haut gagne
    public double seDefendre(){
        return Math.random()*Constante.JetDef + Constante.defenseCerf;
        //nombre à revoir
    }    

    public void marcher(){
	x += directionX;
	y += directionY;
    }

     public boolean estPredateur(Animal a){
	if(a instanceof Loup)
	    return true;
	if(a instanceof Ours)
	    return true;
	
	return false;
    }

    
    
    //Deplacement aléatoire pour l'instant
    /*public boolean seDeplacer(){
        int deplacement = (int)(Math.random() * 5);
        
        // Cerf temp = arraylist.remove du bon objet 
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
        
    } */
    

    
}
