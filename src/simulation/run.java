package simulation;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

public class run extends JFrame implements Runnable// Other implementables
{
	Container con = getContentPane();
	Thread t = new Thread(this);

	// All variables and objects declared here.
	
	ArrayList<Particle> particleList;
	
	public run() {
		con.setLayout(new FlowLayout());
		/*
		 * All variables initialized here All objects instantiated here All
		 * Listeners added here
		 */
		
		
		//list of all particles
		particleList = new ArrayList<Particle>();
		
		//water particle template
		Particle water = new Particle(0, 0, 0, 0, 10, 1);
		
		//add rectangle of particles
		particleList.addAll(ParticleGenerator.particleRectangle(100, 100, 10, 10, 10, water));
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		t.start();
	}

	public void run() { 
		try {
			while (true) {
				t.sleep(1000);// Smaller number == faster, larger == slower
				/*
				 * All motion and collision detection coded here
				 */
				
				//prints x positions of particles
				for (Particle p: particleList){
					System.out.println(p.x);
				}
				
				
				repaint();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics gr) {
		Image i = createImage(getSize().width, getSize().height);
		Graphics2D g = (Graphics2D) i.getGraphics();
		
		//draws all particles
		for (Particle p: particleList){
			p.draw(g);
		}
		
		g.dispose();
		gr.drawImage(i, 0, 20, this);
	}

	public static void main(String[] args) {
		run frame = new run();
		frame.setSize(500, 500);// determines size of screen: Phillips' max is
								// 800, 800
		frame.setVisible(true);
	}

	public void update(Graphics g) {
		paint(g);
	}

}
