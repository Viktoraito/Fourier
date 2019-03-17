/*
 * Developed and debugged by Mark Kofman
 * Moscow Aviation Institute, group 3O-210, 2015
 */
package fourier;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.AdjustmentListener;
class Complex
{
    protected double Re;
    protected double Im;
            Complex(double InitRe, double InitIm)
            {
                Re=InitRe;
                Im=InitIm;
            }
            protected double GetRe()
            {
                return Re;
            }
            protected double GetIm()
            {
                return Im;
            }
 
            //метод вывода алгебраической формы комплексного числа:
            public void Print() 
            {
                if(Im<0)
                    System.out.println(DMath.fDb(Re,5)+""+DMath.fDb(Im,5)+"*i");
                else {
                    System.out.println(DMath.fDb(Re,5)+"+"+DMath.fDb(Im,5)+"*i");
        }
            }
          
            public double Amp()
            {
                double A=Math.sqrt(Re*Re+Im*Im);
                return A;                
            }
            
            public double Fi()
            {
                double F=Math.atan2(Re, Im);
                return F;
            }
}

abstract class Func
         {
             private static Complex f1(double D,int N,int n,int k)
             {
                //arg=exp[-2*Math.PI*i*k*n/N]
                Complex arg = new Complex(Math.cos(-2*Math.PI*k*n/N),Math.sin(-2*Math.PI*k*n/N));
                arg=CMath.Cmul(arg, D);
                return arg;
            }
             
             public static Complex f2(double[] arr,int k)
            {
              Complex x = new Complex(0,0);
              for(int n = 0; n < arr.length; n++)
              {
                  x=CMath.CPlus(x, f1(arr[n],arr.length,n,k));
              }
              x=CMath.Cmul(x, 1/Math.sqrt(arr.length));
              return x;
            }           
         }

public class Fourier{

    public static void main(String[] args) {
   
    //Создание массивов arr1 и arr2 с действительными и комплексными числами;
    //A и F с амплитудами и фазами:
    Scanner scanner = new Scanner(System.in);
    
    try {
            System.out.println("Input numer of values:");
            int size = scanner.nextInt();
            double[] arr1 = new double[size];
            Complex[] arr2 = new Complex[size];
            double[] A = new double[size];
            double[] F = new double[size];
            double D;
            
            System.out.println("Would you like to input values by yourself?\n"
            + "'Y' or 'y' for Yes, any other alpha-numeric key for No:");
            String Q=scanner.next();
        //сюда можно бы вставить очистку экрана
            
    if (Q.charAt(0)=='y' || Q.charAt(0)=='Y')
    {
        for(int i = 0; i < arr1.length; i++){
         arr1[i]=scanner.nextDouble();
         System.out.println("x["+(i+1)+"]="+DMath.fDb(arr1[i],5));
        }
    } 
    else{
    Random rand = new Random();
            
            for(int i = 0; i < arr1.length; i++){
                D=(double)rand.nextInt(10)*rand.nextDouble();
                arr1[i] = D;
                System.out.println("x["+(i+1)+"]="+DMath.fDb(arr1[i],5));
            }
        }
             
            System.out.println("\n");
            for(int k=0;k < arr2.length;k++)
            {
               arr2[k]=Func.f2(arr1, k);
               System.out.print("y["+(k+1)+"]=");arr2[k].Print();
               A[k]=arr2[k].Amp();
               F[k]=arr2[k].Fi();
            }
            System.out.println("\n");
            for(int i=0;i < A.length;i++) System.out.println("A["+(i+1)+"]="+DMath.fDb(A[i],5));
            System.out.println("\n");
            for(int i=0;i < F.length;i++) System.out.println("F["+(i+1)+"]="+DMath.fDb(F[i],5)); 
            
            JFrame framex = new JFrame("Input values:");
           {
            Scrollbar horizSB;
            //AdjustmentListener horiz;
               int wight = 640, height = 480;
               horizSB=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,wight);
               horizSB.setPreferredSize(new Dimension(50,20));
            framex.setLayout(new GridLayout(2,1));
            framex.add(new Plot("Numb","X",arr1));
            framex.add(horizSB);
            framex.setSize(640, 480);
            //horizSB.addAdjustmentListener(horiz);
            
            framex.setVisible(true);
            framex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
           }
            
           
           
        }
    catch (InputMismatchException e)
        {
            System.err.println(e.getMessage() + "\nНа первый запрос следует ввести число;\n"
                    + "на второй - любой символ; на последующие - действительные числа.\n"
                    + "десятичным разделителем для действительного числа является ЗАПЯТАЯ");
        }
        
    
}}
