public class UnionFind {
    private int[] Parents;
    private int[] Size;

    public UnionFind(int size){
        Parents= new int[size+1];
        Size = new int[size+1];
        for (int i=1; i<Parents.length; i++){
            Parents[i]=i;
            Size[i]=1;
        }
    }

    public int find(int num){
        if (Parents[num]==num){
            return num;
        }
        Parents[num]=find(Parents[num]);
        return Parents[num];
    }

    public int union(int num1, int num2){
        return num1;
    }
}
