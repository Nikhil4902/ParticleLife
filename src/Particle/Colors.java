package Particle;

public enum Colors {

    RED(0), GREEN(1), BLUE(2), CYAN(3), MAGENTA(4), YELLOW(5), ORANGE(6), WHITE(7);

    private final int value;
    Colors(int val){
        this.value = val;
    }

    public int getValue(){
        return this.value;
    }
}
