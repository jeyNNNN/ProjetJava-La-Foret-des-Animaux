public class Arbre extends Plante{
    private boolean estProducteur;


    ////////////////////////////CONSTRUCTEURS////////////////////////////
    public Arbre(){
        super();
    }
    
    public Arbre(boolean estProducteur){
        super();
        this.estProducteur = estProducteur;
    }





    ////////////////////////////UTILITAIRES////////////////////////////
    public boolean estMange(){
        if (estProducteur == true){
            return true;
        }
        else{
            return false;
        }
    }
    
    
}
