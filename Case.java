import java.util.ArrayList;
import java.awt.*;
public abstract class Case{
    protected Color couleur;
    protected ArrayList<Animal> animaux; 
	protected Terrain terrain;
    
    
    public Case(int cote,Terrain t){
	animaux = new ArrayList<Animal>();
	terrain = t;
    }
    
    public Case(Terrain t){
	this(4,t);
    }
    
    public Case(){
	this(4,new Terre());
    }
    
    
    
    /********************************************/
    
    public void setTerrain(Terrain t){
	this.terrain = terrain;
    }
    
    public void setCouleur(Terrain t){
    	if(t instanceof Eau)
    		couleur = Color.blue;
    	else if(t instanceof Terre)
    		couleur = new Color(63,34,4);//RGB du marron	
    	else if(t instanceof Verdure){
    		if(t instanceof Plante){
    			couleur = new Color(86,130,3);// Vert avocat
    		}
    		else if(t instanceof Arbre){
    			couleur = new Color(0,86,27);// Vert empire
    			}
    			else{
    				couleur = new Color(58,137,35);//RGB d'un vert	
    			}
    		}
    }
    
    public Terrain getTerrain(){
	return terrain;
    }
    
    public void ajouterAnimal(Animal a){
	animaux.add(a);
    }
    
    public void enleverAnimal(Animal a){
	animaux.remove(a);
    }
    public ArrayList<Animal> getAnimaux(){
	return animaux;
    }
    
}
