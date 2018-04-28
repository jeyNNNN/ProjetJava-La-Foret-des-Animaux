import java.lang.Math;
import java.util.ArrayList;

public class Loup extends Animal implements Predateur, ATerrestre{
 
    private final static int odorat = 10;
    private final static int vitesse = 4;

    ////////////////////////////CONSTRUCTEURS////////////////////////////
    
    public Loup(int x, int y, int age, char sexe){
	super(x,y,age,sexe);
    }
    
    public Loup(int x, int y){
        super(x,y);
    }
    
    public Loup(){
	super();
    }

    ////////////////////////////ACTTIONS////////////////////////////

    public void sentirProie(Foret f){
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

    
    public double attaquer(Animal a){
	return Math.random()*Constante.JetOff + Constante.attaqueLoup;//nombre à revoir
    }    




    public Animal seReproduire(Animal a, Foret f){
	boolean nouveau = false;
	Animal bebe;
		
	for(Animal b : f.foret[this.getX()][this.getY()].getAnimaux()){
	    if(naissance(b))
		nouveau = true ;
	    break;
	}
	if (nouveau){
	    bebe = new Loup(this.x, this.y);
	    return bebe;
	}
	else
	    return null;
    }
	


    public void chasser(Animal a,Foret f){
    	System.out.println(a.getClass());
    	
    
		if(a.x > this.x){
			directionX = Math.min(a.x - this.x,vitesse);
		}
		else{
			directionX = Math.max(a.x - this.x,-vitesse);
		}
		
		if(a.y > this.y){
			directionY = Math.min(a.y - this.y,vitesse);
		}
		else{
			directionY = Math.max(a.y - this.y,-vitesse);
		}
    
    	x+= directionX;
    	y+= directionY;
    }


    ////////////////////////////UTILITAIRES////////////////////////////
    
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
    public boolean naissance(Animal a){
	if(a instanceof Loup && a.getSexe() != this.getSexe())	
	    if(Math.random()*100 < Constante.reproduction)
		return true;
	    else 
		return false;
	else 
	    return false;	
    }



    public boolean estProie(Animal a){
	if(a instanceof Renard)
	    return true;
	if(a instanceof Lapin)
	    return true;

	return false;
    }


    
}
