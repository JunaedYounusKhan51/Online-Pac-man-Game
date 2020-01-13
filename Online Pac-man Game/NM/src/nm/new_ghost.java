package nm;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
//import nm.NM;
//import static nm.NM.image;


public class new_ghost implements Runnable  {

    Thread t;

    new_ghost() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        int i;
        
        int increase = 8;
       
        boolean decision = true;
        while (true) {
            if (decision) {
                if (NM.pacman.image.getY() < NM.ghostShow2.getY()) {
                    i = 0;
                } else {
                    i = 1;
                }
                decision = false;
            } else {
                if (NM.pacman.image.getX() >  NM.ghostShow2.getX()) {
                    i = 2;
                } else {
                    i = 3;
                }
                decision = true;
            }
           switch (i) {

                case 0:
                    //up

                   

                    NM.ghostShow2.setY(NM.ghostShow2.getY() - increase);
                    //System.out.println(ghostShow2.getX() + " " + ghostShow2.getY());
                    break;
                case 1:
                   
                    
                    NM.ghostShow2.setY(NM.ghostShow2.getY() + increase);
                    //System.out.println(ghostShow2.getX() + " " + ghostShow2.getY());
                    break;
                case 2:
                    //right
                    

                    NM.ghostShow2.setX(NM.ghostShow2.getX() + increase);
                    //System.out.println(ghostShow2.getX() + " " + ghostShow2.getY());
                    break;
                case 3:
                    //left
                    
                    NM.ghostShow2.setX(NM.ghostShow2.getX() - increase);
                    //System.out.println(ghostShow2.getX() + " " + ghostShow2.getY());
                    break;
            }
            //System.out.println("Inte " + ghostShow2.getX() + " " + ghostShow2.getY());

            try {
                if(NM.score<=10)
                {
                    Thread.sleep(100);
                }
                else if(NM.score<=20)
                {
                    Thread.sleep(150);
                }
                else if(NM.score<=30)
                {
                    Thread.sleep(100);
                }
                else
                {
                    Thread.sleep(60);
                }
            } catch (InterruptedException ex) {
                System.out.println("PROB IN AI GHOST THREAD ");
                //Logger.getLogger(GhostMoveRandom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
