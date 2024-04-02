public class UnionFind {
    private int[] parents;

    public UnionFind(int size){
        parents= new int[size+1];
        for (int i=1; i<parents.length; i++){
            parents[i]=i;
        }
    }
}
