class Node{
    Node[] links=new Node[26]; 
    boolean flag;
    boolean containsKey(char c){
        if(links[c-'a']!=null)
            return true;
        else
            return false;
    }
    void put(char c,Node root){
        links[c-'a']=root;
    }
    Node get(char c){
        return links[c-'a'];
    }
    void setEnd(){
        flag=true;
    }
    boolean isTrue(){
        return flag;
    }
}




public class Trie {
    static Node root;

    //Initialize your data structure here

    Trie() {
        //Write your code here
        root=new Node();
    }


    //Inserts a word into the trie

    public static void insert(String word) {
        //Write your code here
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node=node.get(word.charAt(i));
        }
        node.setEnd();
    }


    //Returns if the word is in the trie

    public static boolean search(String word) {
        //Write your code here
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node=node.get(word.charAt(i));
        }
        return node.isTrue();
        
    }

    
    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String prefix) {
        //Write your code here
        Node node=root;
        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i)))
                return false;
            node=node.get(prefix.charAt(i));
        }
        return true;
    }
}
