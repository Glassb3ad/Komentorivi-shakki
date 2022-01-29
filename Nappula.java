import java.io.Serializable;
public abstract class Nappula implements Serializable{
  public int sijaintiX;
  public int sijaintiY;
  public boolean onkoValkoinen; 
  
  public Nappula(int sijaintiY,int sijaintiX, boolean x){
    this.sijaintiX=sijaintiX;
    this.sijaintiY=sijaintiY;
    this.onkoValkoinen=x;
  }
  

  //Antaa ruudussa olevan Nappula olion
  public static Nappula annaNappula(int y, int x){ 
    for(Nappula n:Peli.nappulat){
      if (n.sijaintiY==y && n.sijaintiX==x){
        return n;
      }
    }
      return null;
  }
  
  

//Palauttaa true, jos ruutu on varattu
  public static boolean onkoVarattu(int y, int x){
    for(Nappula n:Peli.nappulat){
      if (n.sijaintiY==y && n.sijaintiX==x){
        return true;
      }
    }
    return false;
  }

  abstract public boolean OnkoSiirtoLaillinen(int y, int x);
}




























