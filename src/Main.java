import Display.*;
import ParameterSettings.Parameters;
import Particle.*;


public class Main {
    public static void main(String[] args) {

        Particle[] particles = new Particle[Parameters.numParticles];
        Colors[] colors = Parameters.colors;

        for (int i = 0; i < particles.length; i++) {
            particles[i] = new Particle();
            particles[i].setPosition(new Vector2D(Math.random() * Parameters.panelWidth,
                    Math.random() * Parameters.panelHeight));
            particles[i].setVelocity(new Vector2D(Math.random() * 5, Math.random() * 5));
            particles[i].setColor(colors[(int) (Math.random() * Parameters.numTypes)]);
        }


        ForceRelations fr = new ForceRelations(Parameters.forceRelations);
        System.out.println(fr);

        new Simulation(particles);
    }
}