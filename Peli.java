import java.util.ArrayList;
import java.util.Scanner;
import java.io.*; 

public class Peli{
  //Attribuutit
  public static ArrayList<Nappula> nappulat=new ArrayList<Nappula>(); //Tallennetaan peliss‰ olevat nappulat.
   public static int p1virheet;
   public static int p2virheet;
  //Metodit
  
  //Alustaa nappulat listan shakin alkutilanteen mukaiseksi
  public static void aloitaPeli(){ 
    for(int i=1;i<9;i++){
      nappulat.add(new Sotilas(2,i,false));
    }
    for(int i=1;i<9;i++){
      nappulat.add(new Sotilas(7,i,true));
    }
    nappulat.add(new Torni(1,1,false));
    nappulat.add(new Torni(8,1,true));
    nappulat.add(new Torni(1,8,false));
    nappulat.add(new Torni(8,8,true));
    nappulat.add(new Ratsu(1,2,false));
    nappulat.add(new Ratsu(1,7,false));
    nappulat.add(new Ratsu(8,2,true));
    nappulat.add(new Ratsu(8,7,true));
    nappulat.add(new L‰hetti(1,3,false));
    nappulat.add(new L‰hetti(1,6,false));
    nappulat.add(new L‰hetti(8,3,true));
    nappulat.add(new L‰hetti(8,6,true));
    nappulat.add(new Kuningatar(1,4,false));
    nappulat.add(new Kuningatar(8,4,true));
    nappulat.add(new Kuningas(1,5,false));
    nappulat.add(new Kuningas(8,5,true));
  }
  
  //Siirt‰‰ Nappulan ja heitt‰‰ poikkeuksia
  public static void siirto(int y, int x, int a, int b) throws SallimatonSiirto{
    if(!(a>8 ||a<1 ||y<1 || y>8 || x>8 ||x<1 ||b<1 || b>8)){ 
    if(Nappula.onkoVarattu(y,x)){
      Nappula n=Nappula.annaNappula(y,x);
      if(n.OnkoSiirtoLaillinen(a,b)){
        if(Nappula.onkoVarattu(a,b)){
          Nappula temp=Nappula.annaNappula(a,b);
          temp.sijaintiY=0;
          temp.sijaintiX=0;
        }
        n.sijaintiY=a;
        n.sijaintiX=b;
      }
      else {System.out.println("Siirto ei ole sallittu"); throw new SallimatonSiirto(); }
   }
   else {System.out.println("T‰ss‰ kohdassa ei ole nappulaa"); throw new SallimatonSiirto(); } 
   }
    else {System.out.println("Siirtosi ylitt‰‰ laudan"); throw new SallimatonSiirto();}
 }
    
 
//Tarkistaa onko kuningas uhattuna. parametri true tarkistaa onko valkoinen kuningas uhattuna ja false mustan.
  public static boolean onkoShakki(boolean x){
    Nappula mustaKuningas=null;
    Nappula valkoinenKuningas=null; 
    for(Nappula n:nappulat){
      if(n instanceof Kuningas && !(n.onkoValkoinen)){
        mustaKuningas=n;
      }
      if(n instanceof Kuningas && n.onkoValkoinen){
        valkoinenKuningas=n;
      }
    }
    if(x){
      for(Nappula n:nappulat){
        if(n.OnkoSiirtoLaillinen(valkoinenKuningas.sijaintiY,valkoinenKuningas.sijaintiX)){
          return true;
        }
      }
    return false;
    }
    else{
      for(Nappula n:nappulat){
      if(n.OnkoSiirtoLaillinen(mustaKuningas.sijaintiY,mustaKuningas.sijaintiX)){
        return true;
      }
    }
    return false;
    }
  }
    
//Tulostaa pelin nykyisen tilanteen nappulat listan perusteella
  public static void tulostaLauta(){ 
    String[][] Lauta=new String[9][9];
    Lauta[0][0]="Y|X";
    Lauta[1][0]="1 ";
    Lauta[2][0]="2 ";
    Lauta[3][0]="3 ";
    Lauta[4][0]="4 ";
    Lauta[5][0]="5 ";
    Lauta[6][0]="6 ";
    Lauta[7][0]="7 ";
    Lauta[8][0]="8 ";
    
    Lauta[0][1]="1 ";
    Lauta[0][2]="2 ";
    Lauta[0][3]="3 ";
    Lauta[0][4]="4 ";
    Lauta[0][5]="5 ";
    Lauta[0][6]="6 ";
    Lauta[0][7]="7 ";
    Lauta[0][8]="8 ";
    for(int i=1;i<9;i++){
      for(int j=1;j<9;j++){
        Lauta[i][j]="##";
      }
    }
    for(Nappula x: nappulat){
      if(x instanceof Sotilas && x.onkoValkoinen){
        Lauta[x.sijaintiY][x.sijaintiX]="VS";
      }
      if(x instanceof Sotilas && !(x.onkoValkoinen)){
        Lauta[x.sijaintiY][x.sijaintiX]="MS";
      }
      if(x instanceof L‰hetti && !(x.onkoValkoinen)){
        Lauta[x.sijaintiY][x.sijaintiX]="ML";
      }
      if(x instanceof L‰hetti && (x.onkoValkoinen)){
        Lauta[x.sijaintiY][x.sijaintiX]="VL";
      }
      if(x instanceof Ratsu && !(x.onkoValkoinen)){
        Lauta[x.sijaintiY][x.sijaintiX]="MR";
      }
      if(x instanceof Ratsu && (x.onkoValkoinen)){
        Lauta[x.sijaintiY][x.sijaintiX]="VR";
      }
      if(x instanceof Torni && !(x.onkoValkoinen)){
        Lauta[x.sijaintiY][x.sijaintiX]="MT";
      }
      if(x instanceof Torni && (x.onkoValkoinen)){
        Lauta[x.sijaintiY][x.sijaintiX]="VT";
      }
      if(x instanceof Kuningatar && !(x.onkoValkoinen)){
        Lauta[x.sijaintiY][x.sijaintiX]="Mk";
      }
      if(x instanceof Kuningatar && (x.onkoValkoinen)){
        Lauta[x.sijaintiY][x.sijaintiX]="Vk";
      }
      if(x instanceof Kuningas && !(x.onkoValkoinen)){
        Lauta[x.sijaintiY][x.sijaintiX]="MK";
      }
      if(x instanceof Kuningas && (x.onkoValkoinen)){
        Lauta[x.sijaintiY][x.sijaintiX]="VK";
      }
    }
    for(int i=0;i<9;i++){
      for(int j=0;j<9;j++){
        if(j==8){
          System.out.println(Lauta[i][j]);
        }
        else{
          System.out.print(Lauta[i][j]+" ");
        }
      }
    }
  }
  
  public static void tallennaVoittaja(){
    try{
      File file= new File("v.txt"); 
      if(!file.exists()){
        file.createNewFile();
      }
      PrintWriter pw= new PrintWriter(file);
      if(p1virheet==3){
        pw.println("Pelaaja 2");
      }
      else{
        pw.println("Pelaaja 1");
      }
      pw.close();
    }
    catch(IOException e){
      System.out.println("jotain vikaa");
    }
  }
  
  public static String lataaVoittaja(){
    String voittaja;
    BufferedReader br = null;
    try{
      br= new BufferedReader((new FileReader("v.txt")));
      if((voittaja=br.readLine())!= null){
        return voittaja;
      }
    }
    catch(IOException e){
      System.out.println("jotain vikaa");
    }
    finally{
      try{br.close();}
      catch(IOException e){ System.out.println("Jotain vikaa sulkemisessa");}
    }
    return "Ei edellist‰ voittajaa";
  }
    
  
  
  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    boolean vuoro=true;  //p1:n vuorolla vuoro==true ja p2:n vuorolla vuoro==false
    boolean onkoHavitty=false;
    p1virheet=0;
    p2virheet=0;
    int p;
    aloitaPeli();
    System.out.println("Tervetuloa!");
    System.out.println("P‰‰tt‰k‰‰ mit‰ v‰ri‰ p1 ja p2 pelaavat. Peli ei est‰ toisen nappuloiden siirt‰mist‰, mutta t‰m‰ on tietysti shakin s‰‰ntˆj‰ vastaan."); 
    System.out.println("Peli h‰vit‰‰n, kun pelaaja tekee kolmannen virhesiirron. Peli ei p‰‰ty automaattisesti mattiin, vaan matissa oleva pelaaja on pakotettu tekem‰‰n virhesiirtoja kunnes niiden m‰‰r‰ on 3");
    System.out.println("Tornitus, ohestalyˆnti ja sotilaiden korotus eiv‰t ole k‰ytˆss‰");
    System.out.println("Syˆt‰ ensin x kordinaatti, jonka j‰lkeen y. Ensiksi syˆtet‰‰n liikutettavan nappulan koordinaatit, jonka j‰lkeen syˆtet‰‰n sen ruudun koordinaatit, johon nappula halutaan siirt‰‰");
    System.out.println("Edellisen pelin voitti:" +lataaVoittaja());
    tulostaLauta();
    
    while(!(onkoHavitty)){
      
      //poistaa nappulat listasta viime vuorolla syˆdyn nappulan 
      if(Nappula.onkoVarattu(0,0))
        nappulat.remove(Nappula.annaNappula(0,0));
      
      if(vuoro){ //tarkistaa kumman vuoro
        p=1;
      }
      else{
        p=2;
      }
      
      System.out.println("Pelaaja" +p+"! Anna liikutettavan nappulan x,y koordinaatit");
      int X1=sc.nextInt();
      int Y1=sc.nextInt();
      
      System.out.println("Pelaaja"+p+"! Anna siirron x,y koordinaatit");
      int B1=sc.nextInt();
      int A1=sc.nextInt();
      
      try{siirto(Y1,X1,A1,B1);}
      catch(SallimatonSiirto  e){
        System.out.println("Siirtoa ei voida tehd‰. Kokeile uudelleen");
        continue;
      }
      if(onkoShakki(vuoro)){
        if(vuoro){
          p1virheet++;
          vuoro=!(vuoro);
        }
        else{p2virheet++; vuoro=!(vuoro);}
        System.out.println("Shakki on ratkaistava. Virhesiirtojen m‰‰r‰t: P1:"+p1virheet+ " P2:"+p2virheet);
        
        //palautetaan tilanne, joka oli ennen virhesiirtoa
        (Nappula.annaNappula(A1,B1)).sijaintiY=Y1;
        (Nappula.annaNappula(Y1,B1)).sijaintiX=X1;
        if(Nappula.onkoVarattu(0,0)){
        (Nappula.annaNappula(0,0)).sijaintiY=A1;
        (Nappula.annaNappula(A1,0)).sijaintiX=B1;
        }
        if(p1virheet==3){
          System.out.println("pelaaja 2 voitti");
          onkoHavitty=true;
          tallennaVoittaja();
        }
        if(p2virheet==3){
          System.out.println("pelaaja 1 voitti");
          onkoHavitty=true;
          tallennaVoittaja();
        }
      }
      vuoro=!(vuoro);
      tulostaLauta();
   }
  }
}





  
  
  
  
  
  
  




  