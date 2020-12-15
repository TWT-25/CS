//Play a Rock Paper Scissors game with the computer!
//When the game ends the program will print how many times the player has won. 

import java.util.*;

public class RPC
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("You will be playing against the computer!");
        System.out.println("1=Rock 2=Paper 3=Scissors");
        System.out.println("Pick 1, 2 or 3? (-1 to exit game): ");
        
        Scanner input = new Scanner(System.in);
        Random computer = new Random();

        while (!input.hasNextInt()) //catch invalid entry (all except int type)
        {
            System.out.println("Invalid entry. Try again.");
            System.out.println("Pick 1, 2 or 3? (-1 to exit game): ");
            input.next();
        }
        
        int a = input.nextInt();
        int count = 0;
        
        while(a!=-1)
        {
            int b = computer.nextInt(3) + 1; //computer played numbers (1=Rock,2=Paper,3=Scissors)
            
            if(a==1)
            {
                if(b==1)
                {
                    System.out.println("You:Rock, Computer:Rock.");
                    System.out.println("It's a tie!");
                }
                else if(b==2)
                {
                    System.out.println("You:Rock, Computer:Paper.");
                    System.out.println("You lost!");
                }
                else if (b==3)
                {
                    System.out.println("You:Rock, Computer:Scissors.");
                    System.out.println("You won!");
                    count++;
                }
            }
            else if(a==2)
            {
                if(b==1)
                {
                    System.out.println("You:Paper, Computer:Rock.");
                    System.out.println("You won!");
                    count++;
                }
                else if(b==2)
                {
                    System.out.println("You:Paper, Computer:Paper.");
                    System.out.println("It's a tie!");
                }
                else if(b==3)
                {
                    System.out.println("You:Paper, Computer:Scissors.");
                    System.out.println("You lost!");
                }
            }
            else if(a==3)
            {
                if(b==1)
                {
                    System.out.println("You:Scissors, Computer:Rock.");
                    System.out.println("You lost!");
                }
                else if(b==2)
                {
                    System.out.println("You:Scissors, Computer:Paper.");
                    System.out.println("You won!");
                    count++;
                }
                else if(b==3)
                {
                    System.out.println("You:Scissors, Computer:Scissors.");
                    System.out.println("It's a tie!");
                }
            }
            else
            {
                System.out.println("Invalid entry. Try again."); //catch invalid entry (all other integers)
            }
            
            System.out.println("Pick 1, 2 or 3? (-1 to exit game): ");
            
            while (!input.hasNextInt()) //catch invalid entry (all except int type)
            {
            System.out.println("Invalid entry. Try again.");
            System.out.println("Pick 1, 2 or 3? (-1 to exit game): ");
            input.next();
            }
            
            a = input.nextInt();  
        }
        
        System.out.println("You won " + count + " time(s)!");
    }
}
