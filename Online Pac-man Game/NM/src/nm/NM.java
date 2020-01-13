/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nm;

import com.sun.javafx.geom.Rectangle;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class NM extends Application {
    //static int flag=0;
    //static ImageView fireimage=new ImageView("img/fires.jpg");
    //public static ImageView iMage;
    //int is_bomb_set =0;
    public static Group root;
    
    
    ///////////
    Ghost[] ghosts = new Ghost[8];
    Ghost[] ghosts1 = new Ghost[8];
    
    //////////
    //pacman object
    public static PacMan pacman;
    
    ///new background image
    public static ImageView background_image;
    
    
    //ghost image
    public ImageView image_ghost1;
    public ImageView image_ghost2;
    public ImageView image_ghost3;
    public ImageView image_ghost4;
    public ImageView image_ghost5;
    public ImageView image_ghost6;
    public ImageView image_ghost7;
    public ImageView image_ghost8;
    
    ////////
    ////intelligent ghost
    public static ImageView ghostShow2;
    ///////
    
    ////
    public ImageView game_over;// = new ImageView("img/game_over.jpg");
    
    ///
    
    public ImageView winner;
    //////home
    public ImageView home;
    
   
    
    //score image array
    public ImageView[] points1 = new ImageView[20];
    public ImageView[] points2 = new ImageView[20];
    public ImageView[] points3 = new ImageView[20];
    public ImageView[] points4 = new ImageView[20];
    public ImageView[] points5 = new ImageView[20];
    public ImageView[] points6 = new ImageView[20];
    public ImageView[] points7 = new ImageView[20];
    public ImageView[] points8 = new ImageView[20];
    
    //points1[i] is an image now
    ///////////////////////////////////////
    
    
    ////score display on screen
    
    public Text score_show = new Text();
    
    
    ////second display
    public Text second_show = new Text();
    
    
    ////second survival variable
    public static int seconds = 0;
    
    ////score variable
    public static int score =0;
    
    
    ///////
    boolean decision = true;
    
    ////////
    
    int increase = 2;
    int increase_2 = 6;
    int increase_white = 4;
    int increase_google = 12;
    int increase_google_2 = 15;
    
    ////
    int flag = 0;
    
    static int fire_flag = 1;
    ////////
    
    /////SOUND
    MediaPlayer point_sound;
            

Timer myTimer = new Timer();

/*
TimerTask task1 = new TimerTask(){
	

	public void run(){
        
            Random rand1 = new Random();
            
            int r = rand1.nextInt(4);
            
            if(r == 0)
            {
                image_ghost5.setX(image_ghost5.getX()+10);
                
            }
            
            if(r == 1)
            {
                image_ghost5.setX(image_ghost5.getX()-10);
                
            }
            
            if(r == 2)
            {
                image_ghost5.setY(image_ghost5.getY()+10);
                
            }
            
            if(r == 3)
            {
                image_ghost5.setY(image_ghost5.getX()-10);
                
            }
            


};

*/
TimerTask task = new TimerTask(){
	

	public void run(){

            /*
		seconds++;
		///sout(seconds);	
                System.out.println("second passed:  "+ seconds);
            */
            
            ///random
            
            /////score display code
            score_show.setText("Score: " + score+ "   Survived: "+ seconds +" sec" );
            score_show.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 15));
            score_show.setY(30);
            score_show.setX(640);
            score_show.setFill(Color.WHITE);
            //score_show.setOpacity(100);
            //////////////////////
            
            
            Random rand = new Random();
            
            seconds++;////just for test-fun
            
            
            
            /////////test for path finder ghost////
            
            Random rand1 = new Random();
            
            int r = rand1.nextInt(15);
            
            if(fire_flag == 1)
            {
                image_ghost6.setX(5700);

                    image_ghost6.setY(0);

                    
            }
            
            fire_flag++;
            
            
//                if(fire_flag == 1)
//                {
//                    image_ghost6.setX(570);
//
//                    image_ghost6.setY(0);
//
//                    fire_flag = 2;
//
//                }
//                else if(fire_flag == 2)
//                {
//                    fire_flag = 3;
//                }
//                
//                else if(fire_flag == 3 )
//                {
//                    fire_flag = 4;
//                }
//                
//                else if(fire_flag == 4 )
//                {
//                    fire_flag = 0;
//                }
    //          
                
                 if(fire_flag == 11 || fire_flag == 12 || fire_flag == 13 || fire_flag == 14)
                {

                    image_ghost6.setX(10);

                    image_ghost6.setY(5);

                   
                }
    
    
                if(fire_flag == 15 || fire_flag == 16 || fire_flag == 17 || fire_flag == 18)
                {

                    image_ghost6.setX(0);

                    image_ghost6.setY(470);

                   
                }
               
                else if(fire_flag == 19  || fire_flag == 20 || fire_flag == 21 || fire_flag == 21)
                {

                    image_ghost6.setX(555);

                    image_ghost6.setY(0);

                   
                }
                
               
                else if(fire_flag == 22)
                {

                    image_ghost6.setX(555);

                    image_ghost6.setY(0);

                    fire_flag = 4 ;
                }
            
            if(score<=20)
            {    
                if(image_ghost5.getY()<=560 && image_ghost5.getX()<=570)
                {
                    if(r == 0||r==4||r==6||r==7||r==14)
                    {
                        image_ghost5.setX(image_ghost5.getX()+increase_white);

                    }

                    else if(r == 1)
                    {
                        image_ghost5.setX(image_ghost5.getX()-increase_white);

                    }

                    else if(r == 2||r==5||r==8||r==9||r==10||r==11||r==12||r==13)
                    {
                        image_ghost5.setY(image_ghost5.getY()+increase_white);

                    }

                    else if(r == 3)
                    {
                        image_ghost5.setY(image_ghost5.getX()-increase_white);

                    }

                }   

                else
                {
                    if(r == 0||r==4||r==6||r==14)
                    {
                        image_ghost5.setX(0);
                        image_ghost5.setY(0);
                    }
                    else if(r == 1||r==7||r==8||r==9)
                    {
                        image_ghost5.setX(0);
                        image_ghost5.setY(560);

                    }

                    else if(r == 2||r==5||r==10)
                    {
                        image_ghost5.setX(570);
                        image_ghost5.setY(560);

                    }

                    else if(r == 3||r==11||r==12||r==13)
                    {
                        image_ghost5.setX(570);
                        image_ghost5.setY(0);

                    }

                }

                //////////////////

//                if(image_ghost6.getY()<=560 && image_ghost6.getX()<=570)
//                {
//                    //if(r == 0||r==4||r==6||r==7||r==14)
//                    if(r == 1)
//                    {
//                        image_ghost6.setX(image_ghost6.getX()+10);
//
//                    }
//
//                    //if(r == 1)
//                    else if(r == 0||r==4||r==6||r==7||r==14)
//                    {
//                        image_ghost6.setX(image_ghost6.getX()-10);
//
//                    }
//
//                    //if(r == 2||r==5||r==8||r==9||r==10||r==11||r==12||r==13)
//                    else if(r == 3)
//                    {
//                        image_ghost6.setY(image_ghost6.getY()+10);
//
//                    }
//
//                    //if(r == 3)
//                    else if(r == 2||r==5||r==8||r==9||r==10||r==11||r==12||r==13)
//                    {
//                        image_ghost6.setY(image_ghost6.getX()-10);
//
//                    }
//
//                }   
//
//                else
//                {
//                    //if(r == 0||r==4||r==6||r==14)
//                    if(r == 1||r==7||r==8||r==9)
//                    {
//                        image_ghost6.setX(0);
//                        image_ghost6.setY(0);
//                    }
//
//                    //if(r == 1||r==7||r==8||r==9)
//                    else if(r == 2||r==5||r==10)
//                    {
//                        image_ghost6.setX(0);
//                        image_ghost6.setY(560);
//
//                    }
//
//                    //if(r == 2||r==5||r==10)
//                    else if(r == 3||r==11||r==12||r==13)
//                    {
//                        image_ghost6.setX(570);
//                        image_ghost6.setY(560);
//
//                    }
//
//                    //if(r == 3||r==11||r==12||r==13)
//                    else if(r == 0||r==4||r==6||r==14)
//                    {
//                        image_ghost6.setX(570);
//                        image_ghost6.setY(0);
//
//                    }
//
//                }



                //////////////////////////




                //////second display code
                /*
                score_show.setText("Survived: " + seconds);
                score_show.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 20));
                score_show.setY(30);
                score_show.setX(500);
                score_show.setFill(Color.WHITE);
                score_show.setOpacity(100);
                */

                ///////////////



                //codes for ghost that changes path randomly....red ghost

                if(image_ghost1.getX()<=570)
                {
                    image_ghost1.setX(image_ghost1.getX()+increase);
                }
                else
                {
                    int y = rand.nextInt(500);
                    image_ghost1.setX(0);
                    image_ghost1.setY(y);
                }
                //image_ghost1.setY(image_ghost1.getX()+10);

                 //image_ghost2.setX(image_ghost1.getX()+10);
                 if(image_ghost2.getY()<=560)
                 {    
                    image_ghost2.setY(image_ghost1.getX()+increase);
                 }

                 else
                 {
                     int x = rand.nextInt(400);
                     image_ghost2.setX(x);
                     image_ghost2.setY(0);


                 }


                 //codes for ghost that doesn't change path....blue ghost

                if(image_ghost3.getX()<=570)
                {
                    image_ghost3.setX(image_ghost3.getX()+increase);
                }
                else
                {
                   // int y = rand.nextInt(500);
                    image_ghost3.setX(0);
                    //image_ghost1.setY(y);
                }

                 if(image_ghost4.getY()<=560)
                {
                    image_ghost4.setY(image_ghost4.getY()+increase);
                }
                else
                {
                    //int y = rand.nextInt(500);
                    image_ghost4.setY(0);
                    //image_ghost1.setY(y);
                }
                 
                 
                ///////////////
                int i;
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

                   

                    NM.ghostShow2.setY(NM.ghostShow2.getY() - increase_google);
                    //System.out.println(ghostShow2.getX() + " " + ghostShow2.getY());
                    break;
                case 1:
                   
                    
                    NM.ghostShow2.setY(NM.ghostShow2.getY() + increase_google);
                    //System.out.println(ghostShow2.getX() + " " + ghostShow2.getY());
                    break;
                case 2:
                    //right
                    

                    NM.ghostShow2.setX(NM.ghostShow2.getX() + increase_google);
                    //System.out.println(ghostShow2.getX() + " " + ghostShow2.getY());
                    break;
                case 3:
                    //left
                    
                    NM.ghostShow2.setX(NM.ghostShow2.getX() - increase_google);
                    //System.out.println(ghostShow2.getX() + " " + ghostShow2.getY());
                    break;
            }
                ////////
                 
             
            }
            //
            else if( score>20)
            {
            
                if(image_ghost5.getY()<=560 && image_ghost5.getX()<=570)
                {
                    if(r == 0||r==4||r==6||r==7||r==14)
                    {
                        image_ghost5.setX(image_ghost5.getX()+increase_2);

                    }

                    else if(r == 1)
                    {
                        image_ghost5.setX(image_ghost5.getX()-increase_2);

                    }

                    else if(r == 2||r==5||r==8||r==9||r==10||r==11||r==12||r==13)
                    {
                        image_ghost5.setY(image_ghost5.getY()+increase_2);

                    }

                    else if(r == 3)
                    {
                        image_ghost5.setY(image_ghost5.getX()-increase_2);

                    }

                }   

                else
                {
                    if(r == 0||r==4||r==6||r==14)
                    {
                        image_ghost5.setX(0);
                        image_ghost5.setY(0);
                    }
                    else if(r == 1||r==7||r==8||r==9)
                    {
                        image_ghost5.setX(0);
                        image_ghost5.setY(560);

                    }

                    else if(r == 2||r==5||r==10)
                    {
                        image_ghost5.setX(570);
                        image_ghost5.setY(560);

                    }

                    else if(r == 3||r==11||r==12||r==13)
                    {
                        image_ghost5.setX(570);
                        image_ghost5.setY(0);

                    }

                }

                //////////////////

//                if(image_ghost6.getY()<=560 && image_ghost6.getX()<=570)
//                {
//                    //if(r == 0||r==4||r==6||r==7||r==14)
//                    if(r == 1)
//                    {
//                        image_ghost6.setX(image_ghost6.getX()+20);
//
//                    }
//
//                    //if(r == 1)
//                    else if(r == 0||r==4||r==6||r==7||r==14)
//                    {
//                        image_ghost6.setX(image_ghost6.getX()-20);
//
//                    }
//
//                    //if(r == 2||r==5||r==8||r==9||r==10||r==11||r==12||r==13)
//                    else if(r == 3)
//                    {
//                        image_ghost6.setY(image_ghost6.getY()+20);
//
//                    }
//
//                    //if(r == 3)
//                    else if(r == 2||r==5||r==8||r==9||r==10||r==11||r==12||r==13)
//                    {
//                        image_ghost6.setY(image_ghost6.getX()-20);
//
//                    }
//
//                }   
//
//                else
//                {
//                    //if(r == 0||r==4||r==6||r==14)
//                    if(r == 1||r==7||r==8||r==9)
//                    {
//                        image_ghost6.setX(0);
//                        image_ghost6.setY(0);
//                    }
//
//                    //if(r == 1||r==7||r==8||r==9)
//                    else if(r == 2||r==5||r==10)
//                    {
//                        image_ghost6.setX(0);
//                        image_ghost6.setY(560);
//
//                    }
//
//                    //if(r == 2||r==5||r==10)
//                    else if(r == 3||r==11||r==12||r==13)
//                    {
//                        image_ghost6.setX(570);
//                        image_ghost6.setY(560);
//
//                    }
//
//                    //if(r == 3||r==11||r==12||r==13)
//                    else if(r == 0||r==4||r==6||r==14)
//                    {
//                        image_ghost6.setX(570);
//                        image_ghost6.setY(0);
//
//                    }
//
//                }



                //////////////////////////




                //////second display code
                /*
                score_show.setText("Survived: " + seconds);
                score_show.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 20));
                score_show.setY(30);
                score_show.setX(500);
                score_show.setFill(Color.WHITE);
                score_show.setOpacity(100);
                */

                ///////////////



                //codes for ghost that changes path randomly....red ghost

                if(image_ghost1.getX()<=570)
                {
                    image_ghost1.setX(image_ghost1.getX()+increase_2);
                }
                else
                {
                    int y = rand.nextInt(500);
                    image_ghost1.setX(0);
                    image_ghost1.setY(y);
                }
                //image_ghost1.setY(image_ghost1.getX()+10);

                 //image_ghost2.setX(image_ghost1.getX()+10);
                 if(image_ghost2.getY()<=560)
                 {    
                    image_ghost2.setY(image_ghost1.getX()+increase_2);
                 }

                 else
                 {
                     int x = rand.nextInt(400);
                     image_ghost2.setX(x);
                     image_ghost2.setY(0);


                 }


                 //codes for ghost that doesn't change path....blue ghost

                if(image_ghost3.getX()<=570)
                {
                    image_ghost3.setX(image_ghost3.getX()+increase_2);
                }
                else
                {
                   // int y = rand.nextInt(500);
                    image_ghost3.setX(0);
                    //image_ghost1.setY(y);
                }

                 if(image_ghost4.getY()<=560)
                {
                    image_ghost4.setY(image_ghost4.getY()+increase_2);
                }
                else
                {
                    //int y = rand.nextInt(500);
                    image_ghost4.setY(0);
                    //image_ghost1.setY(y);
                }
                 
                 ////////////////
                 
                 int i;
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

                   

                    NM.ghostShow2.setY(NM.ghostShow2.getY() - increase_google_2);
                    //System.out.println(ghostShow2.getX() + " " + ghostShow2.getY());
                    break;
                case 1:
                   
                    
                    NM.ghostShow2.setY(NM.ghostShow2.getY() + increase_google_2);
                    //System.out.println(ghostShow2.getX() + " " + ghostShow2.getY());
                    break;
                case 2:
                    //right
                    

                    NM.ghostShow2.setX(NM.ghostShow2.getX() + increase_google_2);
                    //System.out.println(ghostShow2.getX() + " " + ghostShow2.getY());
                    break;
                case 3:
                    //left
                    
                    NM.ghostShow2.setX(NM.ghostShow2.getX() - increase_google_2);
                    //System.out.println(ghostShow2.getX() + " " + ghostShow2.getY());
                    break;
            }
            
            }
             
             
             /////codes for checking collision between ghost and pacman
             
            Rectangle2D pacman_rect  = new Rectangle2D(pacman.image.getX(), pacman.image.getY(), 30, 30);

            Rectangle2D ghost_rect1  = new Rectangle2D(image_ghost1.getX(), image_ghost1.getY(), 30, 30);
            Rectangle2D ghost_rect2  = new Rectangle2D(image_ghost2.getX(), image_ghost2.getY(), 30, 30);
            Rectangle2D ghost_rect3  = new Rectangle2D(image_ghost3.getX(), image_ghost3.getY(), 30, 30);
            Rectangle2D ghost_rect4  = new Rectangle2D(image_ghost4.getX(), image_ghost4.getY(), 30, 30);
            Rectangle2D ghost_rect5  = new Rectangle2D(image_ghost5.getX(), image_ghost5.getY(), 30, 30);
            Rectangle2D ghost_rect6  = new Rectangle2D(image_ghost6.getX(), image_ghost6.getY(), 50, 60);

            Rectangle2D ghost_rect7  = new Rectangle2D(ghostShow2.getX(), ghostShow2.getY(), 34, 34);
           




           if (ghost_rect1.intersects(pacman_rect) == true) {
                          
//                           System.out.println("DIED");
//                           System.out.println(seconds+ "seconds survived");
//                           pacman.image.setY(-300);
//                           
//                          System.exit(0);//just temporary game-over 
                             System.out.println("DIED");
                           System.out.println(seconds+ "seconds survived");
                           pacman.image.setY(-300);
                           
                           
                           ///////////////
                           image_ghost1.setX(10000);
                           
                           image_ghost2.setX(4000);
                           image_ghost3.setX(-2000);
                           image_ghost4.setX(4000);
                           image_ghost5.setX(4500);
                           image_ghost6.setX(4900);
                           ghostShow2.setX(10000);
                           image_ghost1.setX(22222);
                           home.setY(-300);
                           
                           for(int i = 0; i < points1.length; i++)
                           {
                               points1[i].setX(5000);
                               points3[i].setX(5000);
                               points5[i].setX(5000);
                               points7[i].setX(5000);
                               
                               
                           }
                           
                           game_over.setX(0);
                           game_over.setY(0);
                           
                           
                           
                           //score_show.setX(300);
                           //score_show.setY(200); 
                           flag = 1;
                           myTimer.cancel();
                           
                          
           }


           else if (ghost_rect2.intersects(pacman_rect) == true) {
                          
//                           System.out.println("DIED");
//                           System.out.println(seconds+ "seconds survived");
//                           pacman.image.setY(-300);
//                           
//                           System.exit(0);//just temporary game-over
                             System.out.println("DIED");
                           System.out.println(seconds+ "seconds survived");
                           pacman.image.setY(-300);
                           
                           
                           ///////////////
                           image_ghost1.setX(10000);
                           
                           image_ghost2.setX(4000);
                           image_ghost3.setX(-2000);
                           image_ghost4.setX(4000);
                           image_ghost5.setX(4500);
                           image_ghost6.setX(4900);
                           ghostShow2.setX(10000);
                           image_ghost1.setX(22222);
                           home.setY(-300);
                           
                           for(int i = 0; i < points1.length; i++)
                           {
                               points1[i].setX(5000);
                               points3[i].setX(5000);
                               points5[i].setX(5000);
                               points7[i].setX(5000);
                               
                               
                           }
                           
                           game_over.setX(0);
                           game_over.setY(0);
                           
                           
                           
                           //score_show.setX(300);
                           //score_show.setY(200); 
                           flag = 1;
                           myTimer.cancel();

           }

           else if (ghost_rect3.intersects(pacman_rect) == true) {
                           
//                           System.out.println("DIED");
//                           System.out.println(seconds+ "seconds survived");
//                           pacman.image.setY(-300);
//                           
//                          System.exit(0);//just temporary game-over
                             System.out.println("DIED");
                           System.out.println(seconds+ "seconds survived");
                           pacman.image.setY(-300);
                           
                           
                           ///////////////
                           image_ghost1.setX(10000);
                           
                           image_ghost2.setX(4000);
                           image_ghost3.setX(-2000);
                           image_ghost4.setX(4000);
                           image_ghost5.setX(4500);
                           image_ghost6.setX(4900);
                           ghostShow2.setX(10000);
                           image_ghost1.setX(22222);
                           home.setY(-300);
                           
                           for(int i = 0; i < points1.length; i++)
                           {
                               points1[i].setX(5000);
                               points3[i].setX(5000);
                               points5[i].setX(5000);
                               points7[i].setX(5000);
                               
                               
                           }
                           
                           game_over.setX(0);
                           game_over.setY(0);
                           
                           
                           
                           //score_show.setX(300);
                           //score_show.setY(200); 
                           flag = 1;
                           myTimer.cancel();
                           
           }
           
           else if (ghost_rect4.intersects(pacman_rect) == true) {
			
//                        System.out.println("DIED");
//                        System.out.println(seconds+ "seconds survived");
//			pacman.image.setY(-300);
//                        
//                        System.exit(0);//just temporary game-over
                           System.out.println("DIED");
                           System.out.println(seconds+ "seconds survived");
                           pacman.image.setY(-300);
                           
                           
                           ///////////////
                           image_ghost1.setX(10000);
                           
                           image_ghost2.setX(4000);
                           image_ghost3.setX(-2000);
                           image_ghost4.setX(4000);
                           image_ghost5.setX(4500);
                           image_ghost6.setX(4900);
                           ghostShow2.setX(10000);
                           image_ghost1.setX(22222);
                           home.setY(-300);
                           
                           for(int i = 0; i < points1.length; i++)
                           {
                               points1[i].setX(5000);
                               points3[i].setX(5000);
                               points5[i].setX(5000);
                               points7[i].setX(5000);
                               
                               
                           }
                           
                           game_over.setX(0);
                           game_over.setY(0);
                           
                           
                           
                           //score_show.setX(300);
                           //score_show.setY(200); 
                           flag = 1;
                           myTimer.cancel();
			
            }
           
           else if (ghost_rect5.intersects(pacman_rect) == true) {
                           
//                           System.out.println("DIED");
//                           System.out.println(seconds+ "seconds survived");
//                           pacman.image.setY(-300);
//                           
//                           System.exit(0);//just temporary game-over 
                              System.out.println("DIED");
                           System.out.println(seconds+ "seconds survived");
                           pacman.image.setY(-300);
                           
                           
                           ///////////////
                           image_ghost1.setX(10000);
                           
                           image_ghost2.setX(4000);
                           image_ghost3.setX(-2000);
                           image_ghost4.setX(4000);
                           image_ghost5.setX(4500);
                           image_ghost6.setX(4900);
                           ghostShow2.setX(10000);
                           image_ghost1.setX(22222);
                           home.setY(-300);
                           
                           for(int i = 0; i < points1.length; i++)
                           {
                               points1[i].setX(5000);
                               points3[i].setX(5000);
                               points5[i].setX(5000);
                               points7[i].setX(5000);
                               
                               
                           }
                           
                           game_over.setX(0);
                           game_over.setY(0);
                           
                           
                           
                           //score_show.setX(300);
                           //score_show.setY(200); 
                           flag = 1;
                           myTimer.cancel();
                           
                           
           }
           
           else if (ghost_rect6.intersects(pacman_rect) == true) {
//                           //pacman.setAlive(false);
//                           System.out.println("DIED");
//                           System.out.println(seconds+ "seconds survived");
//                           pacman.image.setY(-300);
//                           
//                          System.exit(0);//just temporary game-over 

                             System.out.println("DIED");
                           System.out.println(seconds+ "seconds survived");
                           pacman.image.setY(-300);
                           
                           
                           ///////////////
                           image_ghost1.setX(10000);
                           
                           image_ghost2.setX(4000);
                           image_ghost3.setX(-2000);
                           image_ghost4.setX(4000);
                           image_ghost5.setX(4500);
                           image_ghost6.setX(4900);
                           ghostShow2.setX(10000);
                           image_ghost1.setX(22222);
                           home.setY(-300);
                           
                           for(int i = 0; i < points1.length; i++)
                           {
                               points1[i].setX(5000);
                               points3[i].setX(5000);
                               points5[i].setX(5000);
                               points7[i].setX(5000);
                               
                               
                           }
                           
                           game_over.setX(0);
                           game_over.setY(0);
                           
                           
                           
                           //score_show.setX(300);
                           //score_show.setY(200); 
                           flag = 1;
                           myTimer.cancel();
                           
                           
           }
           
           else if (ghost_rect7.intersects(pacman_rect) == true) {
                          
                           System.out.println("DIED");
                           System.out.println(seconds+ "seconds survived");
                           pacman.image.setY(-300);
                           
                           
                           ///////////////
                           image_ghost1.setX(10000);
                           
                           image_ghost2.setX(4000);
                           image_ghost3.setX(-2000);
                           image_ghost4.setX(4000);
                           image_ghost5.setX(4500);
                           image_ghost6.setX(4900);
                           ghostShow2.setX(10000);
                           image_ghost1.setX(22222);
                           
                           home.setY(-300);
                           
                           for(int i = 0; i < points1.length; i++)
                           {
                               points1[i].setX(5000);
                               points3[i].setX(5000);
                               points5[i].setX(5000);
                               points7[i].setX(5000);
                               
                               
                           }
                           
                           game_over.setX(0);
                           game_over.setY(0);
                           
                           
                           
                           //score_show.setX(300);
                           //score_show.setY(200); 
                           flag = 1;
                           myTimer.cancel();
                           
                           
                           
                         // System.exit(0);//just temporary game-over 
                           
                          
           }
           
           
          ////////////score system by poins(try)
           //////first row
            for (int i = 0; i < points1.length; i++) 
            {
                Rectangle2D point_rect  = new Rectangle2D(points1[i].getX(), points1[i].getY(), 8, 8);
                
                if (point_rect.intersects(pacman_rect) == true) 
                {
                           //pacman.setAlive(false);
                          points1[i].setX(2000);
                          score++;
                          
                          
                           
                          //System.exit(0);//just temporary game-over 
                           
                           
                }
         
            }//for ends
            
            
//            /////second
//            for (int i = 0; i < points2.length; i++) 
//            {
//                Rectangle2D point_rect  = new Rectangle2D(points2[i].getX(), points2[i].getY(), 8, 8);
//                
//                if (point_rect.intersects(pacman_rect) == true) 
//                {
//                           //pacman.setAlive(false);
//                          points2[i].setX(2000);
//                          score++;
//                          
//                          
//                           
//                          //System.exit(0);//just temporary game-over 
//                           
//                           
//                }
//         
//            }
//            ////second ends
            
            
            ////third
            for (int i = 0; i < points3.length; i++) 
            {
                Rectangle2D point_rect  = new Rectangle2D(points3[i].getX(), points3[i].getY(), 8, 8);
                
                if (point_rect.intersects(pacman_rect) == true) 
                {
                           //pacman.setAlive(false);
                          points3[i].setX(2000);
                          score++;
                          
                          
                           
                          //System.exit(0);//just temporary game-over 
                           
                           
                }
         
            }
            //third ends
            
//            ////4th row
//            for (int i = 0; i < points4.length; i++) 
//            {
//                Rectangle2D point_rect  = new Rectangle2D(points4[i].getX(), points4[i].getY(), 8, 8);
//                
//                if (point_rect.intersects(pacman_rect) == true) 
//                {
//                           //pacman.setAlive(false);
//                          points4[i].setX(2000);
//                          score++;
//                          
//                          
//                           
//                          //System.exit(0);//just temporary game-over 
//                           
//                           
//                }
//         
//            }
//            ////fourth ends
            
            
            ////5th 
            
            for (int i = 0; i < points5.length; i++) 
            {
                Rectangle2D point_rect  = new Rectangle2D(points5[i].getX(), points5[i].getY(), 8, 8);
                
                if (point_rect.intersects(pacman_rect) == true) 
                {
                           //pacman.setAlive(false);
                          points5[i].setX(2000);
                          score++;
                          
                          
                           
                          //System.exit(0);//just temporary game-over 
                           
                           
                }
         
            }
            
            ////5th ends
            
//            ////6th
//            
//            for (int i = 0; i < points6.length; i++) 
//            {
//                Rectangle2D point_rect  = new Rectangle2D(points6[i].getX(), points6[i].getY(), 8, 8);
//                
//                if (point_rect.intersects(pacman_rect) == true) 
//                {
//                           //pacman.setAlive(false);
//                          points6[i].setX(2000);
//                          score++;
//                          
//                          
//                           
//                          //System.exit(0);//just temporary game-over 
//                           
//                           
//                }
//         
//            }
//            ///6th ends
            
            ///7th
            for (int i = 0; i < points7.length; i++) 
            {
                Rectangle2D point_rect  = new Rectangle2D(points7[i].getX(), points7[i].getY(), 8, 8);
                
                if (point_rect.intersects(pacman_rect) == true) 
                {
                           //pacman.setAlive(false);
                          points7[i].setX(2000);
                          score++;
                          
                          
                          
                           
                          //System.exit(0);//just temporary game-over 
                           
                           
                }
         
            }
            //7th ends
            
            
//            ////8th
//            
//            for (int i = 0; i < points8.length; i++) 
//            {
//                Rectangle2D point_rect  = new Rectangle2D(points8[i].getX(), points8[i].getY(), 8, 8);
//                
//                if (point_rect.intersects(pacman_rect) == true) 
//                {
//                           //pacman.setAlive(false);
//                          points8[i].setX(2000);
//                          score++;
//                          
//                         
//                          
//                          
//                           
//                          //System.exit(0);//just temporary game-over 
//                           
//                           
//                }
//         
//            }
//            
//            ///8th ends
            
            ////////////////////
           
           ////////////////////////
            if(score>=20)
            {
                Rectangle2D home_rect  = new Rectangle2D(home.getX(), home.getY(), 40, 40);
                
                if (home_rect.intersects(pacman_rect) == true) 
                {
                           //pacman.setAlive(false);
                          //points7[i].setX(2000);
                          //score++;
                           System.out.println("REACHED HOME");
                           System.out.println(seconds+ "seconds survived");
                           pacman.image.setY(-300);
                           
                           
                           ///////////////
                           image_ghost1.setX(10000);
                           
                           image_ghost2.setX(4000);
                           image_ghost3.setX(-2000);
                           image_ghost4.setX(4000);
                           image_ghost5.setX(4500);
                           image_ghost6.setX(4900);
                           ghostShow2.setX(10000);
                           image_ghost1.setX(22222);
                           
                           home.setY(-300);
                           
                           for(int i = 0; i < points1.length; i++)
                           {
                               points1[i].setX(5000);
                               points3[i].setX(5000);
                               points5[i].setX(5000);
                               points7[i].setX(5000);
                               
                               
                           }
                           
                           winner.setX(0);
                           winner.setY(0);
                           
                           
                           
                           //score_show.setX(300);
                           //score_show.setY(200); 
                           flag = 1;
                           myTimer.cancel();
                          
                          
                          
                           
                          //System.exit(0);//just temporary game-over 
                           
                           
                }
            
            
            }
            
            ///////////////////
            
          

        }
        
        


};


    
    
    ////
    
    
    
   
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        pacman = new PacMan(250,250,true,"img/pacman.png");
        
        //ImageView image=new ImageView("img/pacman.png");
        // iMage=new ImageView("img/Bomb.png");
         
         background_image=new ImageView("img/game_background_1.jpg");
         
         
         
         background_image.setX(0);
         background_image.setY(0);
         
       // image.setX(200);
        //image.setY(100);
      // image.setX(00);
      // image.setY(00);
     Parent Root=FXMLLoader.load(getClass().getResource("/nm/background.fxml"));
        root=new Group();
        root.getChildren().add(Root);
        root.getChildren().add(background_image);
        
        root.getChildren().add(pacman.image);
        //root.getChildren().add(pacman.setImagePath());
       // StackPane root = new StackPane();
       // root.getChildren().aiiiiiiiiiiidd(btn);
        
       //Scene scene = new Scene(root,600,600);//300, 250);//old (okay)
       
       Scene scene = new Scene(root,850,638);
        
        primaryStage.setTitle("Pac-Man!");
        primaryStage.setScene(scene);
        
        
        ////score show codes
        
        root.getChildren().add(score_show);
        
        game_over = new ImageView("img/rip.png");
        
        root.getChildren().add(game_over);
        game_over.setX(3000);
        game_over.setY(3000);
        
        
        
        
        
        ////////////////////////
        //////new key try
        /*
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent keyEvent) {
            System.out.println("hello");

            
            
            if(keyEvent.getCode().toString() == "UP"){
                
                root.getChildren().remove(pacman.image);
                    pacman.set_image("img/pacmanup.png");
                    //root.getChildren().remove(pacman.image);
                    root.getChildren().add(pacman.image);
                    if(pacman.image.getY()>=5 && pacman.image.getY()<=600)
                    {    
                        //image="img/pacman.png";
                        //image.set
                        //pacman.set_image("img/pacmanup.png");
                        pacman.image.setY(pacman.image.getY()-10);
                        System.out.println(pacman.image.getX()+" "+pacman.image.getY());
                    }
                    
            }
            
            if(keyEvent.getCode().toString() == "DOWN"){
                
                root.getChildren().remove(pacman.image);
                    pacman.set_image("img/pacmandown.png");
                    root.getChildren().add(pacman.image);
                    if(pacman.image.getY()>=0 && pacman.image.getY()<=550)
                    {
                        //pacman.set_image("img/pacmandown.png");
                        pacman.image.setY(pacman.image.getY()+10);
                        System.out.println(pacman.image.getX()+" "+pacman.image.getY());
                    }
            }
            

            if(keyEvent.getCode().toString() == "LEFT"){
                root.getChildren().remove(pacman.image);
                    pacman.set_image("img/pacmanleft.png");
                    root.getChildren().add(pacman.image);
                    if(pacman.image.getX() > 0 && pacman.image.getX() <= 570)
                    {
                        
                        pacman.image.setX(pacman.image.getX()-10);
                        System.out.println(pacman.image.getX()+" "+pacman.image.getY());
                    }
            }
            
            if(keyEvent.getCode().toString() == "RIGHT"){
                
                root.getChildren().remove(pacman.image);
                    pacman.set_image("img/pacman.png");
                    root.getChildren().add(pacman.image);
                    if(pacman.image.getX() >= 0 && pacman.image.getX() < 570)
                    {  
                        //pacman.set_image("img/pacman.png");
                        pacman.image.setX(pacman.image.getX()+10);
                        System.out.println(pacman.image.getX()+" "+pacman.image.getY());
                    }
            }
        };
        
        */
        ////////////////////////
        
        
        
        /////old key(was okay)
        
         scene.setOnKeyPressed((KeyEvent event) -> {
            double x=pacman.image.getX();
            double y=pacman.image.getY();
            switch(event.getCode().toString()){
                
                
                case "UP":
                  
                    root.getChildren().remove(pacman.image);
                    pacman.set_image("img/pacmanup.png");
                    //root.getChildren().remove(pacman.image);
                    root.getChildren().add(pacman.image);
                    if(pacman.image.getY()>=5 && pacman.image.getY()<=600)
                    {    
                        //image="img/pacman.png";
                        //image.set
                        //pacman.set_image("img/pacmanup.png");
                        pacman.image.setY(pacman.image.getY()-10);
                        System.out.println(pacman.image.getX()+" "+pacman.image.getY());
                    }
                    
                    break;
                
                case "DOWN":
                                        
                    root.getChildren().remove(pacman.image);
                    pacman.set_image("img/pacmandown.png");
                    root.getChildren().add(pacman.image);
                    if(pacman.image.getY()>=0 && pacman.image.getY()<=560)
                    {
                        //pacman.set_image("img/pacmandown.png");
                        pacman.image.setY(pacman.image.getY()+10);
                        System.out.println(pacman.image.getX()+" "+pacman.image.getY());
                    }
                    
                    break;
                
                case "RIGHT":
                    
                    root.getChildren().remove(pacman.image);
                    pacman.set_image("img/pacman.png");
                    root.getChildren().add(pacman.image);
                    if(pacman.image.getX() >= 0 && pacman.image.getX() <= 570)
                    {  
                        //pacman.set_image("img/pacman.png");
                        pacman.image.setX(pacman.image.getX()+10);
                        System.out.println(pacman.image.getX()+" "+pacman.image.getY());
                    }
                    break;
                    
                case "LEFT":
                    
                    root.getChildren().remove(pacman.image);
                    pacman.set_image("img/pacmanleft.png");
                    root.getChildren().add(pacman.image);
                    if(pacman.image.getX() > 0 )
                    {
                        
                        pacman.image.setX(pacman.image.getX()-10);
                        System.out.println(pacman.image.getX()+" "+pacman.image.getY());
                    }
                    
                    break;
                    
                    
                case "R":
                    
                    if(flag == 1)
                    {
                        
                        flag = 0;
                        
                          
                        //NM.main();
//                        root.getChildren().remove(pacman.image);
//                        pacman.set_image("img/pacmanleft.png");
//                        root.getChildren().add(pacman.image);
//                        if(pacman.image.getX() > 0 )
//                        {
//
//                            pacman.image.setX(pacman.image.getX()-10);
//                            System.out.println(pacman.image.getX()+" "+pacman.image.getY());
//                        }
                    }
                    break;    
             
            }
            
        });
        
     
         
         //////////////
         image_ghost1=new ImageView("img/Ghost.png"); //changes path randomly(red ghost)
         
         image_ghost2=new ImageView("img/Ghost.png");//changes path randomly(red ghost)
         /////////////////
         image_ghost3=new ImageView("img/ghost_1.png");//doesn't change path(blue ghost)
         
         image_ghost4=new ImageView("img/ghost_1.png");//doesn't change path(blue ghost)
         
         //////////////
         image_ghost5=new ImageView("img/ghost_2.png");///path follower(white ghost)
         
         image_ghost6=new ImageView("img/fire_ghost_2.png");///fire ghost yellow
         
         //////
         
         ///home
         home = new ImageView("img/home.png");
         
         //////////
         
         winner = new ImageView("img/home_win.png");
         
         
         ////////
         ///new intelligent ghost
         ghostShow2 = new ImageView("img/ghost_new.png");
         /////////////
         
         
         /////////////sound
         
         //Media point_file = new Media("sounds/beep5.mp3");
         
         //pushing ghost images to the root
         root.getChildren().add(image_ghost1);
         root.getChildren().add(image_ghost2);
         root.getChildren().add(image_ghost3);
         root.getChildren().add(image_ghost4);
        
         root.getChildren().add(image_ghost5);
         root.getChildren().add(image_ghost6);
         
         
         root.getChildren().add(ghostShow2);
         
         root.getChildren().add(home);
         
         root.getChildren().add(winner);
         
         winner.setX(1000);
         winner.setY(1000);
         
         
         
         //setting the starting point of the ghost
         image_ghost1.setX(15);
         
         image_ghost1.setY(40);
         
         image_ghost2.setX(300);
         
         image_ghost2.setY(100);
         
         image_ghost3.setX(150);
         
         image_ghost3.setY(200);
         
         image_ghost4.setX(400);
         
         image_ghost4.setY(300);
         
         image_ghost5.setX(0);
         
         image_ghost5.setY(0);
         
         
         home.setX(560);
         home.setY(540);
         
         
         
//         image_ghost6.setX(570);
//         
//         image_ghost6.setY(0);
         
         /////
         ghostShow2.setX(120);
         ghostShow2.setY(120);
         
         
         //////////////////////////ghost image ends here/////
         
         
         
         
         
         ///////point image starts/////////
      
      
         ///first point row
         int xPoint = 10, yPoint = 15;
         for (int i = 0; i < points1.length; i++) 
         {
                points1[i] = new ImageView("img/point.png"); 
                
                points1[i].setX(xPoint);
                points1[i].setY(yPoint);
                
                root.getChildren().add(points1[i]);
                
                            //points1[i] = new Point(xPoint, yPoint, "images//point.png");
                 xPoint += 31;
         
         }
         
         
         /////second point row
         ///*
         
         int y_diff = 80;
         
         
         int xPoint2 = 10;
         int yPoint2 = yPoint+ y_diff;
         
//         for (int i = 0; i < points2.length; i++) 
//         {
//                points2[i] = new ImageView("img/point.png"); 
//                
//                points2[i].setX(xPoint2);
//                points2[i].setY(yPoint2);
//                
//                root.getChildren().add(points2[i]);
//                
//                            //points1[i] = new Point(xPoint, yPoint, "images//point.png");
//                 xPoint2 += 31;
//         
//         }
         
         //*/
         ///second point  row ends
          //////////
          
          
          //////third point
         int xPoint3 = 10;
         int yPoint3 = yPoint2+y_diff;
         
         for (int i = 0; i < points3.length; i++) 
         {
                points3[i] = new ImageView("img/point.png"); 
                
                points3[i].setX(xPoint3);
                points3[i].setY(yPoint3);
                
                root.getChildren().add(points3[i]);
                
                            //points1[i] = new Point(xPoint, yPoint, "images//point.png");
                 xPoint3 += 31;
         
         }
         ////third point ends
         
         
         
         ///////fourth point
         int xPoint4 = 10;
         int yPoint4 = yPoint3+y_diff;
         
//         for (int i = 0; i < points4.length; i++) 
//         {
//                points4[i] = new ImageView("img/point.png"); 
//                
//                points4[i].setX(xPoint4);
//                points4[i].setY(yPoint4);
//                
//                root.getChildren().add(points4[i]);
//                
//                            //points1[i] = new Point(xPoint, yPoint, "images//point.png");
//                 xPoint4 += 31;
//         
//         }
         
         /////////fourth point ends
         
         
         ////////fifth point
         
         int xPoint5 = 10;
         int yPoint5 = yPoint4+y_diff;
         
         for (int i = 0; i < points5.length; i++) 
         {
                points5[i] = new ImageView("img/point.png"); 
                
                points5[i].setX(xPoint5);
                points5[i].setY(yPoint5);
                
                root.getChildren().add(points5[i]);
                
                            //points1[i] = new Point(xPoint, yPoint, "images//point.png");
                 xPoint5 += 31;
         
         }
         
         //////fifth point ends
         
         ////////sixth point
         
         int xPoint6 = 10;
         int yPoint6 = yPoint5+y_diff;
         
//         for (int i = 0; i < points6.length; i++) 
//         {
//                points6[i] = new ImageView("img/point.png"); 
//                
//                points6[i].setX(xPoint6);
//                points6[i].setY(yPoint6);
//                
//                root.getChildren().add(points6[i]);
//                
//                            //points1[i] = new Point(xPoint, yPoint, "images//point.png");
//                 xPoint6 += 31;
//         
//         }
         
         //////////sixth point ends
         
         /////seven point
         int xPoint7 = 10;
         int yPoint7 = yPoint6+y_diff;
         
         for (int i = 0; i < points7.length; i++) 
         {
                points7[i] = new ImageView("img/point.png"); 
                
                points7[i].setX(xPoint7);
                points7[i].setY(yPoint7);
                
                root.getChildren().add(points7[i]);
                
                            //points1[i] = new Point(xPoint, yPoint, "images//point.png");
                 xPoint7 += 31;
         
         }
         
         
         ///////seven point ends
         
         
         ///////eight point 
         
         int xPoint8 = 10;
         int yPoint8 = yPoint7+y_diff;
         
//         for (int i = 0; i < points8.length; i++) 
//         {
//                points8[i] = new ImageView("img/point.png"); 
//                
//                points8[i].setX(xPoint8);
//                points8[i].setY(yPoint8);
//                
//                root.getChildren().add(points8[i]);
//                
//                            //points1[i] = new Point(xPoint, yPoint, "images//point.png");
//                 xPoint8 += 31;
//         
//         }
//         
         
         /////eight point ends
         
   

        //new code try for ghost moving
         
        
        //new new_ghost();
//        if(flag == 1)
//         {
//            game_over.setX(250);
//            game_over.setY(250);
//         }
        
         
         myTimer.scheduleAtFixedRate(task,10,100);
         
         
         
         //if(flag)
         
   
        
                    
         primaryStage.show();
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
////////
   
///////////
    
    
}
