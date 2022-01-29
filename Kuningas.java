public class Kuningas extends Nappula{
  public Kuningas(int sijaintiY,int sijaintiX, boolean x){
    super(sijaintiY,sijaintiX,x);
  }
  public boolean OnkoSiirtoLaillinen(int y, int x){
    if(Math.abs(this.sijaintiX-x)<=1 && Math.abs(this.sijaintiY-y)<=1){ //testaa onko kuvio sallittu
      if (onkoVarattu(y,x)){
        if((this.onkoValkoinen && !((annaNappula(y,x)).onkoValkoinen)) || (!(this.onkoValkoinen) && (annaNappula(y,x)).onkoValkoinen)){
          return true;
        }
        else{return false;}
      }
      else{return true;}
    }
   return false;
   }
}