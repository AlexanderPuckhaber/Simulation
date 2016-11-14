package simulation;

import java.awt.Graphics2D;

public class Particle implements Cloneable{
	
	//variables
	public double x, y, xV, yV, radius, mass;
	
	//constructor
	public Particle(double x, double y, double xVelocity, double yVelocity, double radius, double mass){
		
		this.x = x;
		this.y = y;
		this.xV = xVelocity;
		this.yV = yVelocity;
		this.radius = radius;
		this.mass = mass;
		
	}
	
	//method to clone this object
	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	
	//draw method
	public void draw(Graphics2D g){
		g.drawOval((int)x, (int)y, (int)radius, (int)radius);
	}
}
