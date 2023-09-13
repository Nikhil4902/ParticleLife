package Particle;

import ParameterSettings.Parameters;

import java.util.Arrays;

public class ForceRelations {
    public static double[][] ForceConstants;
    public static final double ForceScalingFactor = Parameters.forceScalingFactor;

    public ForceRelations(int n){
        ForceConstants = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ForceConstants[i][j] =  2 * Math.random() - 1;
            }
        }
    }

    public ForceRelations(double[][] rel){
        ForceConstants = rel;
        if (rel.length < Parameters.numTypes){
            System.out.println("Wrong dimensions. Assigning random weights.");
            new ForceRelations(Parameters.numTypes);
        } else {
            for (double[] arr : rel) {
                if (arr.length < Parameters.numTypes){
                    System.out.println("Wrong dimensions. Assigning random weights.");
                    new ForceRelations(Parameters.numTypes);
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        for (double[] arr: Arrays.copyOfRange(ForceConstants,0,Parameters.numTypes)) {
            ans.append(Arrays.toString(Arrays.copyOfRange(arr,0,Parameters.numTypes))).append("\n");
        }
        return ans.toString();
    }

    private static final double beta = Parameters.particleShieldRadius/Parameters.particleMaxInfluenceRadius;
    public static double calculateForce(double a, double r){
        r = r / Parameters.particleMaxInfluenceRadius;
        if (r < beta){
            return ForceScalingFactor * (r / beta - 1);
        } else if (beta < r && r < 1) {
            return ForceScalingFactor * a * (1 - Math.abs(2 * r - 1 - beta) / (1 - beta));
        } else {
            return 0;
        }
    }
}
