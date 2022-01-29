public class Ratsu extends Nappula{
  public Ratsu(int sijaintiY,int sijaintiX, boolean x){
    super(sijaintiY,sijaintiX,x);
  }
  public boolean OnkoSiirtoLaillinen(int y, int x){
    if(((this.sijaintiX==x-2 ||this.sijaintiX==x+2) &&(this.sijaintiY==y-1 ||this.sijaintiY==y+1)) || ((this.sijaintiY==y-2 ||this.sijaintiY==y+2) &&(this.sijaintiX==x-1 ||this.sijaintiX==x+1)) ){ //Testaa voiko nappulaa liikuttaa tyhjällä laudalla. Sallii laudan yli siirtymisen, mikä otetaan huomioon Peli luokan siirto metodissa. Tämä siis testaa liikuuko nappula oikeassa kuviossa{
      if(onkoValkoinen){
        if(onkoVarattu(y,x)){
          if(!((annaNappula(y,x)).onkoValkoinen)){
            return true; //jos ruudussa vastustajan nappula
          }
          else{return false;}//jos ruudussa on oma nappula
        }
        else{return true;} //Jos ruutu on tyhjä 
      }
      else{
        if(onkoVarattu(y,x)){
          if((annaNappula(y,x)).onkoValkoinen){
            return true; //jos ruudussa vastustajan nappula
          }
          else{return false;}//jos ruudussa on oma nappula
        }
        else{return true;} //Jos ruutu on tyhjä 
      }
    }
   else{return false;}
  }
}