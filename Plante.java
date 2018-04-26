public class Plante extends Verdure{
    private boolean comestible;
    private int taille;
    
    Plante(boolean comestible,int taille){
        this.comestible = comestible;
        this.taille = taille;
    } 
    Plante(boolean comestible){
        this.comestible = comestible;
        this.taille = (int)(Math.random()*11);
    }

    Plante(){
        this.comestible = false;
        this.taille = (int)(Math.random()*11);
    }
    
    
    public boolean estMange(){
        if(taille > 2){
            taille--;
            return true;
        }
        else{
            // Faire changer de classe devient Verdure ou devient Terre à voir
        
            return false;    
        }
    }
    
}
