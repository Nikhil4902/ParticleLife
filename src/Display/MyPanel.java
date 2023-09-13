package Display;

import Particle.*;
import ParameterSettings.Parameters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MyPanel extends JPanel implements ActionListener{


    Timer timer;
    public ArrayList<Particle> particles = Simulation.particles;

    MyPanel(){
        this.setPreferredSize(new Dimension(Parameters.panelWidth, Parameters.panelHeight));
        this.setBackground(Color.black);
        timer = new Timer(Parameters.deltaT,this);
        timer.start();
    }

    public static double getDeltaT(){
        return (double)Parameters.deltaT/1000;
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        for (Particle particle: this.particles) {
            g2D.setPaint(Simulation.colors[particle.getColor()]);
            g2D.fillOval((int) particle.getX(),(int) particle.getY(),Parameters.particleRadius,Parameters.particleRadius);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (Parameters.simulationRunning) {
            Vector2D[] forces = new Vector2D[this.particles.size()];
            for (int i = 0; i < this.particles.size(); i++) {
                Vector2D force = new Vector2D();
                for (Particle particle : this.particles) {
                    force = force.add(this.particles.get(i).getForce(particle));
                }
                forces[i] = force;
            }

            for (int i = 0; i < particles.size(); i++) {
                particles.get(i).update(forces[i]);
            }
        }
        repaint();
    }
}
