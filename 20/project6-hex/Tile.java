

public class Tile {
    public int location;
    public String color;

    public Tile(int location, String color){
        this.location=location;
        this.color=color;
    }

    public void updateColor(String color){
        this.color=color;
    }


    public String toString() {
        if (color=="red"){
            return  "\u001B[31m"+"R"+"\u001B[0m";
        }else if (color=="blue"){
            return  "\u001B[34m"+"B"+"\u001B[0m";
        }else{
            return "0";
        }
    }
}
