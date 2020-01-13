/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nm;

import java.awt.Graphics;
import javax.swing.ImageIcon;

import java.awt.Rectangle;
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


/*
                ImageView image_ghost=new ImageView("img/Ghost.png");
                 root.getChildren().add(image_ghost);
       
                image_ghost.setY(100);

                //ghosts[i] = new Ghost(xGhost, yGhost, "img/pacmanup.png");
                xGhost += 75;
                image_ghost.setX(xGhost);
                 //GhostMover gm = new GhostMover(this, image_ghost);
                //gm.start();
            
            */
public class Ghost extends Thread {
	private int x, y;
	private String imagePath;
        public ImageView image_ghost;

	public Ghost(int x, int y, String imagePath) {

                
                image_ghost = new ImageView(imagePath);
		image_ghost.setX(x);
		image_ghost.setY(y);
		this.x = x;
		this.y = y;
		this.imagePath = imagePath;
	}
        
        public void run() {

		while (image_ghost.getY() < 600) {

			image_ghost.setY(image_ghost.getY() + 1);
			//checkCollision();

			if (image_ghost.getY() == 600) {
				image_ghost.setY(-30) ;

			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			//nm.repaint();

		}
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void draw(Graphics g) {

		ImageIcon ghost = new ImageIcon(imagePath);
		g.drawImage(ghost.getImage(), x, y, null);

	}
}
