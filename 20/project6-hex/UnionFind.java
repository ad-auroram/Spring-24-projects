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

    public void union(int num1, int num2){
        int group1 = find(num1);
        int group2 = find(num2);
        if (group1==group2){
            return;
        }
        if (Size[group1]<Size[group2]){
            Size[group2]+=Size[group1];
            Parents[group1] = group2;
        }else{
            Size[group1]+=Size[group2];
            Parents[group2] = group1;
        }
    }
}
