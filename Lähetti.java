public class Lähetti extends Nappula{
  public Lähetti(int sijaintiY,int sijaintiX, boolean x){
    super(sijaintiY,sijaintiX,x);
  }
  
  
  public boolean OnkoSiirtoLaillinen(int y, int x){
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
    return false;
  }    
}