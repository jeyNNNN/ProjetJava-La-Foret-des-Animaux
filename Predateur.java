public interface Predateur{
    public abstract boolean estProie(Animal a);
    public abstract double attaquer(Animal a);
    public abstract void chasser(Animal a);
    public abstract void sentirProie(Foret f);
}
