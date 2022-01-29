public class Kuningatar extends Nappula{
  public Kuningatar(int sijaintiY,int sijaintiX, boolean x){
    super(sijaintiY,sijaintiX,x);
  }
  public boolean OnkoSiirtoLaillinen(int y, int x) {
    
    //Kuningatar liikkuminen on eräänlainen tornin ja lähetin yhdistelmä. Jos siirto on laillinen tornille tai lähetille, niin se on laillinen. Jos se ei ole laillinen jommalle kummalle, niin se ei ole laillinen kuningattarelle.
    
    
    //Onko siirto sallittu tornille?
    
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
      else{return true;}
  }
    
    //Onko siirto sallittu lähetille
    
    
    boolean temp=false;
    for(int i=1;i<10;i++){
      if((this.sijaintiY+i==y && this.sijaintiX+i==x) || (this.sijaintiY-i==y && this.sijaintiX-i==x) || (this.sijaintiY-i==y && this.sijaintiX+i==x) || (this.sijaintiY+i==y && this.sijaintiX-i==x )){
        temp=true; //saa arvon tosi, jos liikekuvio on sallittu
      }
    }
    if(temp){
      int ruudut=Math.abs(this.sijaintiX-x); //ruudut nappulan ja siirtoruudun välissä
      
      //Katsotaan onko nappulan ja siirtoruudun välissä nappuloita
      if(this.sijaintiY<y && this.sijaintiX<x && ruudut>0){
        for(int i=1;i<ruudut;i++){
          if(onkoVarattu(y-i,x-i)){
            return false;
          }
        }
      }
      
      if((this.sijaintiY>y && this.sijaintiX>x) && ruudut>0){
        for(int i=1;i<ruudut;i++){
          if(onkoVarattu(y+i,x+i)){
            return false;
          }
        }
      }
      if(this.sijaintiY>y && this.sijaintiX<x && ruudut>0){
        for(int i=1;i<ruudut;i++){
          if(onkoVarattu(y+i,x-i)){
            return false;
          }
        }
      }
      if(this.sijaintiY<y && this.sijaintiX>x && ruudut>0 ){
        for(int i=1;i<ruudut;i++){
          if(onkoVarattu(y-i,x+i)){
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
      else{return true;}
    }
    
    //Jos koodissa päästään tähän asti, niin kuvio ei ollut sallittu lähetille eikä tornille eli ei myöskään kuningattarelle.
    return false;
    
  }
}