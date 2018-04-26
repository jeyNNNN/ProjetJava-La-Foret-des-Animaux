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
	


    public void chasser(Animal a){
	if(this.x - a.x > 0){
	    directionX = Math.min(this.x - a.x,this.vitesse);
	}
	else{
	    directionX = Math.max(this.x - a.x,this.vitesse);	
	}

	if(this.y- a.y> 0){
	    directionY= Math.min(this.y - a.y,this.vitesse);
	}
	else{
	    directionY = Math.max(this.y - a.y,this.vitesse);	
	}
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
