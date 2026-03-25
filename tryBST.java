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

