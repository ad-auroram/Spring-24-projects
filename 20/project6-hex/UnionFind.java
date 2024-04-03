
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
            System.out.println(num);
            return num;
        }
        System.out.println(num);
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

    public void printParents(){
        for (int i=1; i<Parents.length; i++){
            System.out.println(Parents[i]);
        }
        System.out.println();
    }

    public void printSize(){
        for (int i=1; i<Size.length; i++){
            System.out.println(Size[i]);
        }
        System.out.println();
    }

    public static void main( String [ ] args ) {
        UnionFind union = new UnionFind(5);
        System.out.println("Printing size of unions:");
        union.printSize();
        System.out.println("----------------");
        System.out.println("Printing parents of each index");
        union.printParents();
        System.out.println("----------------");

        System.out.println("Unioning 3 and 4...");
        union.union(3, 4);
        System.out.println();
        System.out.println("Unioning 1 and 5...");
        union.union(1,5);
        System.out.println();

        System.out.println("Printing size of unions:");
        union.printSize();
        System.out.println("----------------");
        System.out.println("Printing parents of each index");
        union.printParents();
        System.out.println("----------------");

        System.out.println("Finding 5:");
        System.out.println(union.find(5));
        System.out.println();
        System.out.println("Finding 4:");
        System.out.println(union.find(4));
        System.out.println();
        System.out.println("Finding 3:");
        System.out.println(union.find(3));

        System.out.println("Unioning 5 and 4:");
        union.union(5,4);
        System.out.println();
        System.out.println("Printing size of unions:");
        union.printSize();
        System.out.println("----------------");
        System.out.println("Printing parents of each index");
        union.printParents();
        System.out.println("----------------");

        System.out.println("Finding 4:");
        union.find(4);


    }
}
