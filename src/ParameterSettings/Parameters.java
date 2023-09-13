package ParameterSettings;

import Particle.Colors;

import java.awt.*;

public class Parameters {
    public static final Colors[] colors = new Colors[]{Colors.RED,Colors.GREEN,Colors.BLUE,Colors.CYAN,Colors.MAGENTA,Colors.YELLOW,Colors.ORANGE,Colors.WHITE};
    public static final Color[] awtColors = new Color[]{Color.RED,Color.GREEN,Color.BLUE,Color.CYAN,Color.MAGENTA,Color.YELLOW,Color.ORANGE,Color.WHITE};
    public static boolean simulationRunning = true;
    public static int selectedColorIndex = 0;

    public static final int particleRadius = 3;
    public static final double particleShieldRadius = 30;
    public static final double particleMaxInfluenceRadius = 100;

    public static final int deltaT = 10;

    public static final int panelWidth = 1400;
    public static final int panelHeight = 750;

    public static final double frictionHalfLife = 15;

    public static int numParticles = 1250;
    public static int numTypes = 7;

    public static final int forceScalingFactor = 4000;
    public static final double[][] forceRelations = {{0.7,    0.1,    0.001,    0.0001,    0.0,    0.0,    0.0, 0.0},
            {0.0,    0.7,    0.1,    0.001,    0.0001,    0.0,    0.0,  0.0},
            {0.0,    0.0,    0.7,    0.1,    0.001,    0.0001,    0.0,  0.0},
            {0.0,    0.0,    0.0,    0.7,    0.1,    0.001,    0.0001,  0.0},
            {0.0,    0.0,    0.0,    0.0,    0.7,    0.1,    0.001,     0.0001},
            {0.0,    0.0,    0.0,    0.0,    0.0,    0.7,    0.1,   0.001},
            {0.0,    0.0,    0.0,    0.0,    0.0,    0.0,    0.7,   0.1},
            {0.0,    0.0,    0.0,    0.0,    0.0,    0.0,    0.0,   0.7}};
}

//snake
/*

        {{0.7,    0.1,    0.001,    0.0001,    0.0,    0.0,    0.0, 0.0},
        {0.0,    0.7,    0.1,    0.001,    0.0001,    0.0,    0.0,  0.0},
        {0.0,    0.0,    0.7,    0.1,    0.001,    0.0001,    0.0,  0.0},
        {0.0,    0.0,    0.0,    0.7,    0.1,    0.001,    0.0001,  0.0},
        {0.0,    0.0,    0.0,    0.0,    0.7,    0.1,    0.001,     0.0001},
        {0.0,    0.0,    0.0,    0.0,    0.0,    0.7,    0.1,   0.001},
        {0.0,    0.0,    0.0,    0.0,    0.0,    0.0,    0.7,   0.1},
        {0.0,    0.0,    0.0,    0.0,    0.0,    0.0,    0.0,   0.7}}

*/

/*
            {-0.73,    0.1,    -0.75,    0.0,    -0.95,    0.0,    0.32,    0.0},
            {0.24,    0.7,    0.1,    -0.91,    0.51,    0.4,    0.67,  0.0},
            {-0.38,    -0.2,    0.7,    0.1,    0.23,    0.1,    0.85,  0.0},
            {-0.06,    0.0,    0.74,    -0.7,    0.1,    -0.3,    0.01, 0.0},
            {0.0,    -0.41,    -0.32,    0.09,    -0.9,    0.1,    -0.1,    0.0},
            {0.06,    0.23,    0.96,    0.00,    -0.4,    -0.7,    0.3, 0.0},
            {0.58,    -0.6,    -0.43,    -0.5,    0.00,    0.75,    0.7,    0.0},
            {0.0,    0.0,    0.0,    0.0,    0.0,    0.0,    0.0,   0.0}    */
