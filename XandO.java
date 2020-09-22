import java.util.Random;
import java.util.Scanner;


public class XandO {
    static int[][] joc = new int [3][3];
    static Scanner input = new Scanner(System.in);
    static String symbolJucator,symbolComputer;
    static int raspuns;

    public static void main(String[] args) {
        System.out.println("Bine ai venit!");
        System.out.println();
        do{    XsiO();
               System.out.println("Tastati \"1\" pentru a incepe din nou, sau orice alt numar pentru a termina");
               raspuns=input.nextInt();

          }while (raspuns==1);
        System.out.println("Sfarsit de Joc");
       }

    public static void XsiO()
  {   initialise();
     SymbolChoice();
     show();
     while (!endGame(joc))
      {     if(draw())
            { System.out.println("Remiza");
                return;}
              alegereJucator();
                if(draw())
                {System.out.println("Remiza");
                 show();
                return;}
                else
                if(endGame(joc))
                {
                    show();
                    return;
                }
              if(!plasareInteligentaComputer())
                 ComputerChoice();

                show();
      }
     }

     public static void SymbolChoice()
    { System.out.println("Alege X sau O:");
        symbolJucator = input.next();
        symbolJucator=symbolJucator.toUpperCase();
        if(symbolJucator.equals("X")==false && symbolJucator.equals("O")==false)
        {  System.out.println("Ati introdus gresit");
            SymbolChoice();}
        else
            {
        if(symbolJucator.equals("X"))
            symbolComputer="O";
        else
            symbolComputer="X";

            System.out.println("Jucatorul joaca cu " + symbolJucator);
            System.out.println("Computerul joaca cu "+symbolComputer); }
    }

    public static void show() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                if(joc[i][j]==0) // 0 pt O
                {System.out.print('O');
                  System.out.print(" ");}
                 else
                     if(joc[i][j]==10) // 10 pt X
                     {   System.out.print('X');
                         System.out.print(" ");}
                 else
                     {   System.out.print(joc[i][j]);
                         System.out.print(" ");}
                         System.out.println();
        }
    }

    public static void initialise() {
        int count=1;
        for (int i = 0; i < 3; i++)
        { for (int j = 0; j < 3; j++)
            { joc[i][j] = count;
                count++; }
        }
    }

    public static void alegereJucator()
        {   System.out.println();
            System.out.println("Alegeti unde pozitionati "+ symbolJucator);
          int pozitie=input.nextInt();
          if(pozitie<=0 || pozitie>=10 )
          { System.out.println("Ati introdus o pozitie gresita");
            alegereJucator();
           }
           else
           if (suprapunereJucator(pozitie,symbolComputer)==false)
           { System.out.println("Ati introdus o pozitie gresita");
               alegereJucator();
           }
           else
            if (suprapunereJucator(pozitie,symbolJucator)==false)
            { System.out.println("Ati introdus o pozitie gresita");
                alegereJucator();
            }
           else
              plasareJucator(pozitie);
        }

        public static void plasareJucator(int pozitie)
        { if(pozitie==1)
        {if(symbolJucator.equals("X"))
            joc[0][0]=10;
        else
            joc[0][0]=0;}
        else
            if(pozitie==2)
            {if(symbolJucator.equals("X"))
                joc[0][1]=10;
            else
                joc[0][1]=0;}
            else
            if(pozitie==3)
            {if(symbolJucator.equals("X"))
                joc[0][2]=10;
            else
                joc[0][2]=0;}
            else
            if(pozitie==4)
            {if(symbolJucator.equals("X"))
                joc[1][0]=10;
            else
                joc[1][0]=0;}
            else
            if(pozitie==5)
            {if(symbolJucator.equals("X"))
                joc[1][1]=10;
            else
                joc[1][1]=0;}
            else
            if(pozitie==6)
            {if(symbolJucator.equals("X"))
                joc[1][2]=10;
            else
                joc[1][2]=0;}
            else
            if(pozitie==7)
            {if(symbolJucator.equals("X"))
                joc[2][0]=10;
            else
                joc[2][0]=0;}
            else
            if(pozitie==8)
            {if(symbolJucator.equals("X"))
                joc[2][1]=10;
            else
                joc[2][1]=0;}
            else
            if(pozitie==9)
            {if(symbolJucator.equals("X"))
                joc[2][2]=10;
            else
                joc[2][2]=0;}
        }

        public static boolean suprapunereJucator(int pozitie,String symbolComputer)
    {  // se verifica daca nu plasam pe o pozitie aleasa de calculator sau de jucator
        int x=0,y=0;
        if(pozitie==1){x=0;y=0;}
        else if(pozitie==2){x=0;y=1;}
        else
        if(pozitie==3){x=0;y=2;}
        else
        if(pozitie==4){x=1;y=0;}
        else
        if(pozitie==5){x=1;y=1;}
        else
        if(pozitie==6){x=1;y=2;}
        else
        if(pozitie==7){x=2;y=0;}
        else
        if(pozitie==8){x=2;y=1;}
        else
        if(pozitie==9){x=2;y=2;}

        if(symbolComputer.equals("O"))
            if(joc[x][y]==0) // daca se gaseste O
                return false;

        if(symbolComputer.equals("X")) // daca se gaseste X
            return joc[x][y] != 10;
        return true;
    }

    public static void ComputerChoice() {
        Random rand= new Random();
        int x = rand.nextInt(3);// intre 0 si 3
        int y = rand.nextInt(3);
        if(joc[x][y]!=10 && joc[x][y]!=0)
        {

            ComputerPlacement(x,y);
        }
        else
            ComputerChoice();
    }

    public static void ComputerPlacement(int x, int y)
    {  System.out.println("Alege Computerul...");
        if(symbolComputer.equals("X"))
        joc[x][y]=10;
    else
        joc[x][y]=0;

        if(x==0 && y==0)
            System.out.println("Computerul a ales 1");
        else
        if(x==0 && y==1)
            System.out.println("Computerul a ales 2");
        else
        if(x==0 && y==2)
            System.out.println("Computerul a ales 3");
        else
        if(x==1 && y==0)
            System.out.println("Computerul a ales 4");
        else
        if(x==1 && y==1)
            System.out.println("Computerul a ales 5");
        else
        if(x==1 && y==2)
            System.out.println("Computerul a ales 6");
        else
        if(x==2 && y==0)
            System.out.println("Computerul a ales 7");
        else
        if(x==2 && y==1)
            System.out.println("Computerul a ales 8");
        else
        if(x==2 && y==2)
            System.out.println("Computerul a ales 9");
    }

      public static boolean endGame(int[][] joc)
     {   for(int i=0;i<3;i++) //linie
         { if(joc[i][0]==joc[i][1] && joc[i][1]==joc[i][2])
            {  // avem castigator
              if((symbolJucator.equals("X") && joc[i][0]==10) || (symbolJucator.equals("O") && joc[i][0]==0))
               {System.out.println("Ai castigat! Felicitari");
               return true;}
                  else
              {System.out.println("Computerul a castigat!");

              return true;
              }
            }
          else // coloana
         {if(joc[0][i]==joc[1][i] && joc[1][i]==joc[2][i])
            // avem castigator
              if((symbolJucator.equals("X") && joc[0][i]==10) || (symbolJucator.equals("O") && joc[0][i]==0))
              {System.out.println("Ai castigat! Felicitari");
                  return true;}
              else
              {System.out.println("Computerul a castigat!");
                  return true;
              }

         }
     }
      //diagonala principala
          if(joc[0][0]==joc[1][1] && joc[1][1]==joc[2][2])
          {  // avem castigator
              if((symbolJucator.equals("X") && joc[0][0]==10) || (symbolJucator.equals("O") && joc[0][0]==0))
              {System.out.println("Ai castigat! Felicitari");
                  return true;}
              else
              {System.out.println("Computerul a castigat!");
                  return true;
               }
          }
         if(joc[0][2]==joc[1][1] && joc[1][1]==joc[2][0])
         {  // avem castigator
             if((symbolJucator.equals("X") && joc[0][2]==10) || (symbolJucator.equals("O") && joc[0][2]==0))
             {System.out.println("Ai castigat! Felicitari");
                 return true;}
             else
             {System.out.println("Computerul a castigat!");
                 return true;
             }
         }
          return false;
      }

      public static boolean draw()
    {
        return isGameComplete() && !endGame(joc);
    }

    public static boolean isGameComplete()
    { for(int i=0;i<3;i++)
        for(int j=0;j<3;j++)
            if(joc[i][j]<10 && joc[i][j]!=0 && joc[i][j]!=10) // daca avem pozitii necompletate
                return false;
    return true;
    }

    public static boolean plasareInteligentaComputer()
    { // prima data cauta daca poate castiga
        if(symbolComputer.equals("O"))
           {
               if(winO())
              return true;
        else
            return blockX();
          }
          else
              {
                  if(blockX())
                  return true;
              else
                  return winO();
              }
     }

    public static boolean winO()
    {int nrl=0,nro=0,pozi=0,pozj=0;
        for (int i=0;i<3;i++)
    { // linie
        pozi=pozj=nrl=nro=0;
        for (int j=0;j<3;j++)
        {
            if (joc[i][j] == 0)
                nro++;
            else
            if(joc[i][j]!=10 && joc[i][j]!=0)
            {   nrl++;
                pozi=i;
                pozj=j;
            }
        }
        if (nro==2 && nrl==1) // o 2 o sau o o 3 sau 1 o o
        {
            ComputerPlacement(pozi,pozj);
            return true;
        }
    }
        pozi=pozj=nrl=nro=0;
        for (int j=0;j<3;j++)
        { // coloana
            pozi=pozj=nrl=nro=0;
            for (int i=0;i<3;i++)
            {
                if (joc[i][j] == 0)
                    nro++;
                else
                if(joc[i][j]!=10 && joc[i][j]!=0)
                {   nrl++;
                    pozi=i;
                    pozj=j;
                }
            }
            // o     2     o
            // 4 sau o sau o
            // o     o     7
            if ( nro==2 && nrl==1)
            {
                ComputerPlacement(pozi,pozj);
                return true;
            }
        }
        pozi=pozj=nrl=nro=0;
        // diagonala principala
        for (int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++)
            { if (i == j)
                {
                     if (joc[i][j] == 0)
                        nro++;
                    else
                     if(joc[i][j]!=10 && joc[i][j]!=0)
                        { nrl++;
                        pozi = i;
                        pozj = j; }
                }
            }
            if (nro==2 && nrl==1)
            { ComputerPlacement(pozi,pozj);
                return true;
            }
        }
        pozi=pozj=nrl=nro=0;
        // diagonala secundara
        for (int i=0;i<3;i++)
        { for (int j = 0; j < 3; j++)
            { if (i+j==2) {
                    if (joc[i][j] == 0)
                        nro++;
                    else
                    if(joc[i][j]!=10 && joc[i][j]!=0){
                        nrl++;
                        pozi = i;
                        pozj = j; }
                }
            }
            if ( nro==2 && nrl==1)
            { ComputerPlacement(pozi,pozj);
                return true;
            }
          }
        return false;
    }

    public static boolean blockX()
    {int nrl,nrx,pozi,pozj;
        for (int i=0;i<3;i++)
        { // linie
            pozi=pozj=nrl=nrx=0;
            for (int j=0;j<3;j++)
            {
                if (joc[i][j] == 10)
                    nrx++;
                else
                if(joc[i][j]!=10 && joc[i][j]!=0)
                {   nrl++;
                    pozi=i;
                    pozj=j;
                }
            }
            if (nrx==2 && nrl==1) // x 2 x sau x x 3 sau 1 x x
            {
                ComputerPlacement(pozi,pozj);
                return true;
            }
        }
        for (int j=0;j<3;j++)
        { // coloana
            pozi=pozj=nrl=nrx=0;
            for (int i=0;i<3;i++)
            {
                if (joc[i][j] == 10)
                    nrx++;
                else
                if(joc[i][j]!=10 && joc[i][j]!=0)
                {   nrl++;
                    pozi=i;
                    pozj=j;
                }
            // x     2     x
            // 4 sau x sau x
            // x     x     7
            }
            if (nrx==2  && nrl==1)
            {
                ComputerPlacement(pozi,pozj);
                return true;
            }
        }
        pozi=pozj=nrl=nrx=0;
        // diagonala principala
        for (int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++)
            {
                if (i == j)
                { if (joc[i][j] == 10)
                        nrx++;
                    else
                    if(joc[i][j]!=10 && joc[i][j]!=0)
                    {
                        nrl++;
                        pozi = i;
                        pozj = j; }
                }
            }
            if (nrx==2 && nrl==1)
            { ComputerPlacement(pozi,pozj);
                return true;
            }
        }
        pozi=pozj=nrl=nrx=0;
        // diagonala secundara
        for (int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                if (i+j==2)
                {
                    if (joc[i][j] == 10)
                        nrx++;
                    else
                    if(joc[i][j]!=10 && joc[i][j]!=0)
                    {
                        nrl++;
                        pozi = i;
                        pozj = j; }
                }
            }
            if (nrx==2 && nrl==1)
            { ComputerPlacement(pozi,pozj);
                return true;
            }
        }
        return false;
    }

}