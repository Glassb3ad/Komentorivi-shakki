public class Torni extends Nappula{
  public Torni(int sijaintiY,int sijaintiX, boolean x){
    super(sijaintiY,sijaintiX,x);
  }
  public boolean OnkoSiirtoLaillinen(int y, int x){
    if(this.sijaintiX==x || this.sijaintiY==y){  //Tarkistaa onko x,y nappulan liikkumiskuvion sisällä
      
      //tarkastetaan onko nappulan sijainnin ja x,y:n välillä nappuloita
      if(x>this.sijaintiX){ 
        for(int i=x-1;i>this.sijaintiX;i--){
          if(onkoVarattu(y,i)){
            return false;
          }
        }
      }
      
      if(x<this.sijaintiX ){
        for(int i=x+1;i<this.sijaintiX;i++){
          if(onkoVarattu(y,i)){
            return false;
          }
        }
      }
      
      if(y<this.sijaintiY){
        for(int i=y+1;i<this.sijaintiY;i++){
          if(onkoVarattu(i,x)){
            return false;
          }
        }
      }
      
      if(y>this.sijaintiY){ 
        for(int i=y-1;i>this.sijaintiY;i--){
          if(onkoVarattu(i,x)){
            return false;
          }
        }
      }
      
      if (onkoVarattu(y,x)){
        if((this.onkoValkoinen && !((annaNappula(y,x)).onkoValkoinen)) || (!(this.onkoValkoinen) && (annaNappula(y,x)).onkoValkoinen)){
          return true;
        }
        else{return false;}
      }
      
     return true;
  }
    else{return false;}
  }
}
