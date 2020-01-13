/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nm;

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
public class GhostMover extends Thread {

	private NM nm;
	private Ghost ghost;
	private PacMan pacman;
        ImageView ImageOfGhost;
        
        /*
	public GhostMover(NM nm, Ghost ghost, PacMan pacman) {
		this.nm = nm;
		this.ghost = ghost;
		this.pacman = pacman;

	}
        */
        
        public GhostMover(NM nm, ImageView image) {
		this.nm = nm;
		//this.ghost = ghost;
		//this.pacman = pacman;
                ImageOfGhost = image;

	}

	public void run() {

		while (ImageOfGhost.getY() < 600) {

			ImageOfGhost.setY(ImageOfGhost.getY() + 1);
			//checkCollision();

			if (ImageOfGhost.getY() == 600) {
				ImageOfGhost.setY(-30) ;

			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			//nm.repaint();

		}
	}

	public void checkCollision() {

		Rectangle pacmanRect = new Rectangle(pacman.getX(), pacman.getY(), 30, 30);
		Rectangle ghostRect = new Rectangle(ghost.getX(), ghost.getY(), 32, 32);

		if (ghostRect.intersects(pacmanRect) == true) {
			pacman.setAlive(false);
			pacman.setY(-300);
			//GameSound.pacmanDied();
		}
	}
}
