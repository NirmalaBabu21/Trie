public class countSubtree {
    static class Node{
        Node children[];
        boolean eow;
        public Node(){
            children=new Node[26];
            for(int i=0;i<26;i++)
            children[i]=null;
            eow=false;
        }
    }
    static Node root=new Node();
    public static void insert(String words){
        Node curr=root;
        for(int i=0;i<words.length();i++){
            int idx=words.charAt(i)-'a';
            if(curr.children[idx]==null)
            curr.children[idx]=new Node();
            if(i==words.length()-1)
            curr.children[idx].eow=true;
            curr=curr.children[idx];
        }
    }

    public static int countNodes(Node root){
        if(root==null)
        return 0;
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null)
            count=count+countNodes(root.children[i]);
        }
        return count+1;
    }
    public static void main(String args[]){
        String words="apple";
        for(int i=0;i<words.length();i++){
        String suffix=words.substring(i);
        System.out.println(suffix);
        insert(suffix);
        }
        System.out.println(countNodes(root));
    }
}
