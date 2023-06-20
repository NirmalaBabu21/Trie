public class wordbreak {
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
   public static boolean search(String words){
    Node curr=root;
    for(int i=0;i<words.length();i++){
        int idx=words.charAt(i)-'a';
        if(curr.children[idx]==null)
        return false;
        if(i==words.length()-1 && curr.children[idx].eow==false)
        return false;
        curr=curr.children[idx];
    }
    return true;
   }
   public static boolean wordbrek(String key){
    if(key.length()==0)
    return true;
    for(int i=1;i<=key.length();i++){
        String firstPart=key.substring(0, i);
        String secPart=key.substring(i);
        if(search(firstPart)&& wordbrek(secPart))
        return true;
    }
    return false;
   }
   public static void main(String args[]){
    String words[]={"i","like","sam","mobile","samsung"};
    for(int i=0;i<words.length;i++)
    insert(words[i]);
    System.out.println(wordbrek("ilikesamsung"));
    System.out.println(wordbrek("ilikesung"));
   }
}
