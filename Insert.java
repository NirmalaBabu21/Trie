public class Insert{
    static class Node{
        Node[] children;
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
    public static void main(String args[]){

        String words[]={"the","a","there","their","any"};
        for(int i=0;i<words.length;i++)
        insert(words[i]);
    }

}