public class Tile {
    public String id;
    public int location;
    public String color;

    public Tile(String id, int location, String color){
        this.id=id;
        this.location=location;
        this.color=color;
    }

    private int[] findNeighbors(){
        int[] neighbors= {1,2,3,4,5,6};
        return neighbors;
    }
}
