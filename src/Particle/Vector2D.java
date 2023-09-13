package Particle;

public class Vector2D {
    public double x, y;
    public Vector2D(){
        this(0,0);
    }

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D other){
        this.x = other.x;
        this.y = other.y;
    }

    public Vector2D add(Vector2D other){
        return new Vector2D(this.x + other.x,this.y + other.y);
    }


    public Vector2D multiply(double scalar){
        return new Vector2D(this.x * scalar, this.y * scalar);
    }

    public double dot(Vector2D other){
        return this.x * other.x + this.y * other.y;
    }

    public double length(){
        return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
    }

    public void normalize(){
        double len = this.length();
        this.x /= len;
        this.y /= len;
    }

    public Vector2D normalized(){
        double len = this.length();
        if (len == 0){
            return new Vector2D();
        }
        return new Vector2D(this.x / len, this.y / len);
    }


    public double angle(){//with (1,0)
        return Math.acos(this.x/this.length());
    }

    public double angle(Vector2D other){
        return Math.acos(other.dot(this)/(this.length()*other.length()));
    }

    @Override
    public String toString() {
        return "<" + this.x + ", " + this.y + ">";
    }
}
