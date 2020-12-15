
/*
This program draws a rocket based on the global constant SUBHEIGHT.
As SUBHEIGHT changes, the rocket size scales with SUBHEIGHT.
*/

public class DrawRocket
{
    //class constant
    public static final int SUBHEIGHT=3;
    
    //main method
    public static void main(String[] args)
    {
        drawFire();
        drawBar();
        drawBody1();
        drawBody2();
        drawBar();
        drawBody2();
        drawBody1();
        drawBar();
        drawFire();
    }
    
    //draw the tip and bottom "fire" of rocket
    public static void drawFire()
    {
        for(int Line=1; Line<=(2*SUBHEIGHT)-1; Line++)
        {
          for(int i=1; i<=(2*SUBHEIGHT)-Line; i++)
          {
              System.out.print(" ");
          }
          
          for(int j=1; j<=Line; j++)
          {
              System.out.print("/");
          }
          
          System.out.print("**");
          
          for(int k=1; k<=Line; k++)
          {
              System.out.print("\\");
          }
          
          System.out.println();
        }
    }
    
    //draw the line with +, = and * which form the "bar" of the rocket
    public static void drawBar()
    {
        System.out.print("+");
        
        for(int i=1; i<=2*SUBHEIGHT; i++)
        {
            System.out.print("=*");
        }
        
        System.out.println("+");
    }
    
    //draw first part of the body with similar pattern (Body1)
    public static void drawBody1()
    {                
        for(int Line=1; Line<=SUBHEIGHT; Line++)
        {
            System.out.print("|");
            
            for(int i=1; i<=SUBHEIGHT-Line; i++)
            {
                System.out.print(".");
            }
            
            for(int j=1; j<=Line; j++)
            {
                System.out.print("/\\");
            }
            
            for(int k=1; k<=2*(SUBHEIGHT-Line); k++)
            {
                System.out.print(".");
            }
            
            for(int l=1; l<=Line; l++)
            {
                System.out.print("/\\");
            }
            
             for(int m=1; m<=SUBHEIGHT-Line; m++)
            {
                System.out.print(".");
            }
            
            System.out.println("|");
        }
    }
    
    //draw the other part of body with similar pattern (Body2)
    public static void drawBody2()
    {
        for(int Line=1; Line<=SUBHEIGHT; Line++)
        {
           System.out.print("|");
           
           for(int i=1; i<=Line-1; i++)
           {
               System.out.print(".");
           }
           
           for(int j=0; j<=SUBHEIGHT-Line; j++)
           {
               System.out.print("\\/");
           }
           
           for(int k=1; k<=(Line-1)*2; k++)
           {
               System.out.print(".");
           }
           
           for(int l=0; l<=SUBHEIGHT-Line; l++)
           {
               System.out.print("\\/");
           }
           
            for(int m=1; m<=Line-1; m++)
           {
               System.out.print(".");
           }
           
           System.out.println("|");
        }
    }
}
