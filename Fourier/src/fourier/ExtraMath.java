/*
 * Developed and debugged by Mark Kofman
 * Moscow Aviation Institute, group 3O-210, 2015
 */
package fourier;


abstract class CMath extends Complex {

    public CMath(double InitRe, double InitIm) {
        super(InitRe, InitIm);
    }
    
    //методы сложения комплексных чисел:
    public static Complex CPlus(Complex arg1, Complex arg2)
            {
                Complex C = new Complex(arg1.GetRe()+arg2.GetRe(),arg1.GetIm()+arg2.GetIm());
                return C;
            }
            
    public static Complex Cplus(Complex arg1, double arg2)
            {
                Complex C = new Complex(arg1.GetRe()+arg2,arg1.GetIm());
                return C;
            }
            
    //методы умножения комплексных чисел:
    public static Complex CMul(Complex arg1, Complex arg2)
            {
                Complex C = new Complex(arg1.GetRe()*arg2.GetRe()-arg1.GetIm()*arg2.GetIm(),arg1.GetRe()*arg2.GetIm()+arg1.GetIm()*arg2.GetRe());
                return C;
            }
            
     public static Complex Cmul(Complex arg1,double arg2)
            {
                Complex C = new Complex(arg1.GetRe()*arg2,arg1.GetIm()*arg2);
                return C;
            }      
     
}

abstract class DMath
{
     public static double fDb(double d, int dz)
            {
            double dd=Math.pow(10,dz);
            return Math.round(d*dd)/dd;
            }
     
     public static int ArrMax(double[] DMas)
     {
         double max;
         max=DMas[0];
         for(int i=1;i<DMas.length;i++)
         {
             if(Math.abs(max)<Math.abs(DMas[i])) max=DMas[i];
         }
         return (int)Math.abs(max)+1;
     }
     
     public static boolean ArrNeg(double[] DMas)
     {
         for(int i=0;i<DMas.length;i++)
             if (DMas[i]<0) return true;
         return false;
     }
}
