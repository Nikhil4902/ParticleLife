package Particle;

import Display.MyPanel;
import ParameterSettings.Parameters;

public class Particle {

    private Vector2D position;
    private Vector2D velocity;
    private int color;

    public static final double FRICTION = Math.pow(0.5,Parameters.deltaT/Parameters.frictionHalfLife);

    public Particle(){
        this(new Vector2D(), new Vector2D(), Colors.RED);
    }


    public Particle(Vector2D position, Vector2D velocity, Colors color) {
        this.position = position;
        this.velocity = velocity;
        this.color = color.getValue();
    }

    //getters
    public Vector2D getPosition(){
        return this.position;
    }

    public double getX(){
        return this.position.x;
    }

    public double getY(){
        return this.position.y;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public int getColor() {
        return color;
    }

    //setters
    public void setColor(Colors color) {
        this.color = color.getValue();
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }

    //utils
    public void updatePos(){
        this.position.x += this.getVelocity().x * MyPanel.getDeltaT();
        this.position.y += this.getVelocity().y * MyPanel.getDeltaT();

        if (this.getPosition().x > Parameters.panelWidth){
            this.position.x -= Parameters.panelWidth;
        }
        if (this.getPosition().y > Parameters.panelHeight){
            this.position.y -= Parameters.panelHeight;
        }
        if (this.getPosition().x < 0){
            this.position.x = Parameters.panelWidth + this.getX();
        }
        if (this.getPosition().y < 0){
            this.position.y = Parameters.panelHeight + this.getY();
        }
    }

    public void updateVel(Vector2D Force){
        this.velocity = this.getVelocity().multiply(FRICTION).add(Force.multiply(MyPanel.getDeltaT()));

    }

    public void update(Vector2D Force){
        this.updateVel(Force);
        this.updatePos();
    }

    private double minAbs(double[] arr){
        double ans = arr[0];
        for(int i = 1; i < arr.length; i++){
            if (Math.abs(arr[i]) < Math.abs(ans)){
                ans = arr[i];
            }
        }
        return ans;
    }

    public double getDistance(Particle other){
        double x1 = other.getX() - this.getX();
        double x2 = x1 + Parameters.panelWidth;
        double x3 = x1 - Parameters.panelWidth;
        double y1 = other.getY() - this.getY();
        double y2 = y1 + Parameters.panelHeight;
        double y3 = y1 - Parameters.panelHeight;
        double x = minAbs(new double[]{x1,x2,x3});
        double y = minAbs(new double[]{y1,y2,y3});

        Vector2D ans = new Vector2D(x,y);
        return ans.length();
    }

    public Vector2D getDirection(Particle other){
        double x1 = other.getX() - this.getX();
        double x2 = x1 + Parameters.panelWidth;
        double x3 = x1 - Parameters.panelWidth;
        double y1 = other.getY() - this.getY();
        double y2 = y1 + Parameters.panelHeight;
        double y3 = y1 - Parameters.panelHeight;
        double x = minAbs(new double[]{x1,x2,x3});
        double y = minAbs(new double[]{y1,y2,y3});

        Vector2D ans = new Vector2D(x,y);
        return ans.normalized();
    }

    public Vector2D getForce(Particle other){
        double r = this.getDistance(other);
        double a = ForceRelations.ForceConstants[this.color][other.color];
        return this.getDirection(other).multiply(ForceRelations.calculateForce(a,r));
    }

    @Override
    public String toString() {
        return "Particle{" +
                "position=" + position +
                ", velocity=" + velocity +
                ", color=" + color +
                '}';
    }
}
