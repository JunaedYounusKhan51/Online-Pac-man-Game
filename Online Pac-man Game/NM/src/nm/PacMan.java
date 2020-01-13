/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nm;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class PacMan {

	public int x, y;
	public boolean isAlive;
	public String imagePath;
        public  ImageView image;// = new ImageView(imagePath); ;
        
        //int flag = 0;

	public PacMan(int x, int y, boolean isAlive, String imagePath) {

                
                image = new ImageView(imagePath);
		image.setX(x);
		image.setY(y);
		this.isAlive = isAlive;
		this.imagePath = imagePath;
                
	}
        
        public void set_image(String imagepath)
        {
            
            //this.x = getX();
            //this.y = getY();
            int x_ =(int)image.getX();
            int y_ =(int)image.getY();
            image =new ImageView(imagepath);
            image.setX(x_);
            image.setY(y_);
            this.isAlive = isAlive;
            this.imagePath = imagePath;
        }
       
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

/*	public void draw(Graphics g) {

		ImageIcon pacman = new ImageIcon(imagePath);
		g.drawImage(pacman.getImage(), x, y, null);

	}
*/

}

