import java.lang.Math;
import java.util.ArrayList;

public class Loup extends Animal implements Predateur, ATerrestre{
    private int directionX;
    private int directionY;
    private final static int odorat = 5;
    private final static int vitesse = 4;
    
    
    ///////////////CONSTRUCTEURS//////////////////
    
    public Loup(int x, int y, int age, char sexe){
	super(x,y,age,sexe);
	directionX = (int)Math.random();
	directionY = (int)Math.random();
    }
    
    public Loup(int x, int y){
        super(x,y);
	directionX = (int)Math.random();
	directionY = (int)Math.random();
    }
    
    public Loup(){
	super();
	directionX = (int)Math.random();
	directionY = (int)Math.random();
    }
    
    public void marcher(){
	x += directionX;
	y += directionY;
	energie--;
    }

    public boolean estProie(Animal a){
	if(a instanceof Renard)
	    return true;
	if(a instanceof Lapin)
	    return true;

	return false;
    }


    public void sentirAnimal(Foret f){
	ArrayList<Animal> proiesPotentielles = new ArrayList<Animal>() ;
	for(int i = this.getY() + odorat ; i < this.getY() - odorat ; ++i){
	    for(int j = this.getX() - odorat ; i < this.getX() + odorat ; ++j){
		ArrayList<Animal> list = f.foret[i][j].getAnimaux();
		for(Animal a : list){
		    if(estProie(a))
			proiesPotentielles.add(a);
		}
	    }
	}
	if(proiesPotentielles.isEmpty())
	    return;
	
	chasser(plusProche(proiesPotentielles));
		
    }
	
    public Animal plusProche(ArrayList<Animal> list){
	double min_dist=odorat*2;
	int indice = 0;
	int indice_dist_min = 0;
	for(Animal a : list){
	    if (Math.sqrt(Math.pow(a.x,2) + Math.pow(a.y,2))<min_dist){
		min_dist = Math.sqrt(Math.pow(a.x,2) + Math.pow(a.y,2));
		indice_dist_min = indice;
	    }
	    indice ++;
	}
	return list.get(indice_dist_min);
    }

    public void chasser(Animal a){
		this.directionX = Math.min(this.x - a.x,this.vitesse);
		this.directionY = Math.min(this.y - a.y,this.vitesse);
	}
	// Eventuellement en class Predateur
    
    
    
    public double attaquer(){
	return Math.random()*Constante.JetOff + Constante.attaqueLoup;//nombre à revoir
    }    
    
    
    

   /* //Deplacement aléatoire pour l'instant
    public boolean seDeplacer(){
        int deplacement = (int)(Math.random() * 5);
        
        // Loup temp = arraylist.remove du bon objet 
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
