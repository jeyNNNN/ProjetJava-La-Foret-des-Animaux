import java.lang.Math;
import java.util.ArrayList;

public class Cerf extends Animal implements Proie, ATerrestre{
    private int directionX;
    private int directionY;
    private final static int odorat = 3;
    private final static int vitesse = 4;
    
    ////////////////////////////CONSTRUCTEURS////////////////////////////
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
    
    ////////////////////////////ACTIONSS////////////////////////////
    
    public double seDefendre(){
        return Math.random()*Constante.JetDef + Constante.defenseCerf;
        //nombre à revoir
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
	    bebe = new Cerf(this.x, this.y);
	    return bebe;
	}
	else
	    return null;
    }
    
    public void sentirPredateur(Foret f){
	ArrayList<Animal> predateursPotentielles = new ArrayList<Animal>() ;
	for(int i = this.getY() + odorat ; i < this.getY() - odorat ; ++i){
	    for(int j = this.getX() - odorat ; i < this.getX() + odorat ; ++j){
		ArrayList<Animal> list = f.foret[i][j].getAnimaux();
		for(Animal a : list){
		    if(estPredateur(a))
			predateursPotentielles.add(a);
		}
	    }
	}
	if(predateursPotentielles.isEmpty())
	    return;
	
	fuir(plusProche(predateursPotentielles));
    }

    
    public void fuir(Animal a){
	if(this.x - a.x > 0){
	    directionX = -1*Math.min(this.x - a.x,this.vitesse);
	}
	else{
	    directionX = -1*Math.max(this.x - a.x,this.vitesse);	
	}
	
	if(this.y- a.y> 0){
	    directionY= -1*Math.min(this.y - a.y,this.vitesse);
	}
	else{
	    directionY = -1*Math.max(this.y - a.y,this.vitesse);	
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
    
    
    public boolean estPredateur(Animal a){
	if(a instanceof Loup)
	    return true;
	if(a instanceof Ours)
	    return true;
	
	return false;
    }
    
    public boolean naissance(Animal a){
	if(a instanceof Cerf && a.getSexe() != this.getSexe())	
	    if(Math.random()*100 < Constante.reproduction)
		return true;
	    else 
		return false;
	else 
	    return false;	
    }
    
}
