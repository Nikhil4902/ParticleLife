package Display;

import ParameterSettings.Parameters;
import Particle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Simulation extends JFrame implements MouseListener, KeyListener, MouseMotionListener {

    public static ArrayList<Particle> particles = new ArrayList<>(Parameters.numParticles);
    public static Color[] colors = Parameters.awtColors;

    private final int numParticlesToAdd = 7;
    private Timer particleTimer;
    private int mouseX, mouseY;

    public MyPanel panel;

    public Simulation(Particle[] particles) {
        Simulation.particles.addAll(Arrays.asList(particles));
        panel = new MyPanel();
        this.addMouseListener(this);
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void addParticles() {
        particleTimer = new Timer(100, e -> {
            for (int i = 0; i < numParticlesToAdd; i++) {
                particles.add(new Particle(new Vector2D(mouseX + Math.random() * 60 - 25, mouseY + Math.random() * 60 - 50),
                        new Vector2D(), Parameters.colors[Parameters.selectedColorIndex]));
            }
        });
        particleTimer.setInitialDelay(50);
        particleTimer.start();
    }

    private void stopAddingParticles() {
        if (particleTimer != null) {
            particleTimer.stop();
            particleTimer = null;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        if (!Parameters.simulationRunning) {
            addParticles();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (!Parameters.simulationRunning) {
            stopAddingParticles();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'e' -> Parameters.simulationRunning = !Parameters.simulationRunning;
            case '1' -> Parameters.selectedColorIndex = 0;
            case '2' -> Parameters.selectedColorIndex = Parameters.numTypes >= 2 ? 1 : 0;
            case '3' -> Parameters.selectedColorIndex = Parameters.numTypes >= 3 ? 2 : 0;
            case '4' -> Parameters.selectedColorIndex = Parameters.numTypes >= 4 ? 3 : 0;
            case '5' -> Parameters.selectedColorIndex = Parameters.numTypes >= 5 ? 4 : 0;
            case '6' -> Parameters.selectedColorIndex = Parameters.numTypes >= 6 ? 5 : 0;
            case '7' -> Parameters.selectedColorIndex = Parameters.numTypes >= 7 ? 6 : 0;
            case '8' -> Parameters.selectedColorIndex = Parameters.numTypes >= 8 ? 7 : 0;

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}
