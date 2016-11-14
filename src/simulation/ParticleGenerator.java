package simulation;

import java.util.ArrayList;

public class ParticleGenerator {
	
	//generates and returns an ArrayList of particles in a rectangular grid
	public static ArrayList<Particle> particleRectangle(double startX, double startY, double columnsOfParticles, double rowsOfParticles, double spacing, Particle template){
		
		ArrayList<Particle> newParticleList = new ArrayList<Particle>();
		
		for (int x = 0; x < columnsOfParticles; x ++){
			for (int y = 0; y < rowsOfParticles; y ++){
				double pX = startX + x*spacing;
				double pY = startY + y*spacing;
				
				System.out.println(pX + " " + pY);
				
				try {
					Particle newParticle = (Particle)template.clone();
					newParticle.x = pX;
					newParticle.y = pY;
					newParticleList.add(newParticle);
					
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return newParticleList;
		
	}
	
}
