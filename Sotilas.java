public class Sotilas extends Nappula{
  public Sotilas(int sijaintiY,int sijaintiX, boolean x){
    super(sijaintiY,sijaintiX,x);
  }
  
  
  public boolean OnkoSiirtoLaillinen(int y, int x){
    //Toteutetaan siirto valkoisille ja mustille erikseen
    if(this.onkoValkoinen){
      if(!onkoVarattu(y,x)){
        if(this.sijaintiY-1==y && this.sijaintiX==x){
          return true;
        }
        if(this.sijaintiY-2==y && this.sijaintiY==7 && this.sijaintiX==x && !(onkoVarattu(y+1,x))){
          return true;
        }
      }
      if(onkoVarattu(y,x)){
        if(!((annaNappula(y,x)).onkoValkoinen)&& this.sijaintiY-1==y && (this.sijaintiX-1==x || this.sijaintiX+1==x )){
        return true;
        }
      }
      return false;
    }
    else{
      if(!onkoVarattu(y,x)){
        if(this.sijaintiY+1==y && this.sijaintiX==x){
          return true;
        }
        if(this.sijaintiY+2==y && this.sijaintiY==2 && this.sijaintiX==x && !(onkoVarattu(y-1,x))){
          return true;
        }
      }
      if(onkoVarattu(y,x)){
        if((annaNappula(y,x)).onkoValkoinen && this.sijaintiY+1==y && (this.sijaintiX+1==x || this.sijaintiX-1==x )){
        return true;
        }
      }
      return false;
    }
  }
}