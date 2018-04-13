public class Arbre extends Plante{
    private boolean estProducteur;
    
    public Arbre(){
        super();
    }
    
    public Arbre(boolean estProducteur){
        super();
        this.estProducteur = estProducteur;
    }
    
    public boolean estMange(){
        if (estProducteur == true){
            return true;
        }
        else{
            return false;
        }
    }
    
    
}
