//java file created 
import java.util.*;

class tNode{
    int key;
    tNode left,right;
    
    public tNode(int key){
        this.key=key;
        left=null;
        right=null;
        
    }
} //Function defined

public class tryBST {
    tNode root;
    tryBST(){
        root=null;
    }

    tNode insertRec(tNode root,int key){
        if(root ==null){
            root=new tNode(key);
            return root;

        }if (key<root.key){
            root.left=insertRec(root.left,key);

        }else if(key<root.key){
            root.right =insertRec(root.right,key);
        }

        return root;
    }public void insert (int key){
            root =insertRec(root,key);
}// tryBST checked properly
    boolean istryBST (tNode node ,int min,int max){
        if (node==null){
            return true;

        }if (node.key <min || node.key > max){
            return false;

        }return istryBST(node.left,min,node.key -1)&& istryBST(node.right ,node.key +1,max);
        }// MIN value being found
    int minvalue (tNode node){
        int min =node.key;

        while(node.left != null){
            min =node.left.key;
            node =node.left;
        }
        return min;


    }//Delete Function
    tNode deleteRec(tNode root,int key){
        if (root ==null) {
            return root;

        }if (key<root.key){
            root.left=deleteRec(root.left,key);
        }else if (key>root.key){
            root.right =deleteRec(root.right,key);
        }else{
            if(root.left ==null)
                return root.right;
            else if (root.right ==null)
                return root.left;
            root.key =minvalue(root.right);

            root.right =deleteRec(root.right,root.key);

        }return root;

           }
}
public class tryBST{
    //Balanced TREE BUILD
    static void buildbalanced(BST tree,int start,int end){
        if (start>end)
            return;

        int mid =mid =(start+end)/2;

        tree.insert(mid);

        buildbalanced(tree,start,mid-1);
        buildbalanced(tree,mid +1,end);

    }
    //Remove even numbers
    static void removeEvens(BST tree,int max){
        for (int i=2;i<=max;i+=2){
            tree.root=tree.deleteRec(tree.root ,i);
        }
    }
    public static void main(String []args){
            int n=18;
            int max =(int)Math.pow(2,n)-1;

            int repetitions =30;

            long totalPopulate=0;
            long totalDelete=0;

            for(int i=0;i< repetitions;i++){

            BST tree =new BST();

            //POPULATE TREE
            long startPopulate =System.currentTimeMillis();

            buildbalanced(tree,1,max);

            long endPopulate=System.currentTimeMillis();

            totalPopulate +=(endPopulate -startPopulate);


            //check BST
            if (!tree.isBST(tree.root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
                System.out.println("Tree is npt a BST!");
            }//DELETE EVENS
            long startDelete =System.currentTimeMillis();
            removeEvens (tree,max);

            long endDelete=System.currentTimeMillis();

            totalDelete += (endDelete-startDelete);

        }
        double avgPopulate =totalPopulate/(double)repetitions;
        double avgDelete =totalDelete /(double)repetitions;

        System.out.println("\nMethod\t\t\tNumber of keys\taverage time(ms)");
        System.out.println("Populate tree\t\t"+max+"\t\t"+avgDelete);

    }
}

    

