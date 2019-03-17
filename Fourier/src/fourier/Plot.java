/*
 * Developed and debugged by Mark Kofman
 * Moscow Aviation Institute, group 3O-210, 2015
 */
package fourier;

import javax.swing.*;
import java.awt.*;

public class Plot extends JPanel{
        protected int Sizex;
        protected int Sizey;
        protected String X;
        protected String Y;
        protected double[] DMas;
        
        Plot(String X,String Y,double[] DMas)
        {
            Sizex=DMas.length*20;
            Sizey=DMath.ArrMax(DMas)*20;
            this.X=X;
            this.Y=Y;
            this.DMas=DMas;
        }
        
         @Override
         public void paint(Graphics g)
            {
                
              if(!DMath.ArrNeg(DMas))
              {
                g.drawLine(30, 20+Sizey, 30, 20); 
                g.drawLine(30, 20+Sizey, 30+Sizex, 20+Sizey); 
                g.drawString(Y, 30, 10); 
                g.drawString(X, 40+Sizex, 20+Sizey);
                
                for(int i=20;i<20+Sizey;i+=20)
                {
                    g.drawLine(28, i, 32, i);
                    if(((20+Sizey-i)/20)<10) g.drawString("  "+(20+Sizey-i)/20, 0, i+5);
                    else g.drawString(""+(20+Sizey-i)/20, 0, i+5);
                }
                
                int r,e;
                for(int i=30;i<=30+Sizex;i+=20)
                {
                    g.drawLine(i, 18+Sizey, i, 22+Sizey);
                    if(i!=30) g.drawString(""+(i-20)/20, i-5, 35+Sizey);
                    if(i!=30+Sizex)
                    {
                        r=(int)DMas[(i-20)/20];
                        e=(int)((DMas[(i-20)/20]-(int)DMas[(i-20)/20])*20);
                        g.drawRect(i, 20+Sizey-r*20-e, 20, r*20+e);
                    }
                }
               }
               else
              {
                  g.drawLine(30, 20+2*Sizey, 30, 20); 
                  g.drawLine(30, 20+Sizey, 30+Sizex, 20+Sizey); 
                  g.drawString(Y, 30, 10); 
                  g.drawString(X, 40+Sizex, 20+Sizey);
                  
                for(int i=20+2*Sizey;i>=20;i-=20)
                {
                    g.drawLine(28, i, 32, i);
                    if (Math.abs((20+Sizey-i)/20)<10) g.drawString("  "+(20+Sizey-i)/20, 0, i+5);
                    else g.drawString("  "+((20+Sizey-i)/20), 0, i+5);
                }
            
                int r,e;
                    for(int i=30;i<=30+Sizex;i+=20)
                    {
                        g.drawLine(i, 18+Sizey, i, 22+Sizey);
                        if(i!=30) g.drawString(""+(i-20)/20, i-5, 35+Sizey);
                        if(i!=30+Sizex)
                        {
                            r=(int)DMas[(i-20)/20];
                            e=(int)((DMas[(i-20)/20]-(int)DMas[(i-20)/20])*20);
                            if(DMas[(i-20)/20]>=0) g.drawRect(i, 20-r*20-e+Sizey, 20, r*20+e);
                            else g.drawRect(i, 20+Sizey, 20, Math.abs(r)*20+Math.abs(e));
                        }
                }
              }
            }
}


