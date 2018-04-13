public abstract class Animal{
    protected int x;
    protected int y;
    protected int energie;
    protected int age;//en mois
    protected final char sexe;
    protected Foret f;

////////////////////CONSTRUCTEURS///////////////////////
    public Animal(int x, int y, int age, char sexe){
	this.x = x;// position
	this.y = y;// de l'animal
	this.sexe = sexe ;// 'm' ou 'f' pour les 2 sexes
	energie = 100 ;//énergie de base pour les animaux
	this.age = age;
	this.f = f;
    }

    public Animal(int x, int y){ //Pour les bébés
	this.x = x;
	this.y = y;
	if(Math.random() > 0.5)
	    sexe = 'f';
	else
	    sexe = 'm';
	energie = 100;
	age = 0;
	
    }

    public Animal(){
	x = (int)Math.random()*Constante.tailleX;
	y = (int)Math.random()*Constante.tailleY;
	age = 12;
	energie = (int)Math.random()*50 + 50;
	if(Math.random() > 0.5)
	    sexe = 'f';
	else
	    sexe = 'm';
	   
    }



////////////////////SETTEURS///////////////////////

    public void setX(int x){
	this.x = x;
    }

    public void setY(int y){
	this.y = y;
    }

    public void vieillir(){
	age++;
    }

    
    
////////////////////GETTEURS///////////////////////

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public int getEnergie(){
	return energie;
    }

    public int getAge(){
	return age;
    }

    public char getSexe(){
	return sexe;
    }

    //////////////////////////////////////////////

//public abstract void sentir();
//public abstract double seBattre(Animal a);


    
}
