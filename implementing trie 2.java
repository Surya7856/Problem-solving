import java.util.* ;
import java.io.*; 
class Node{
    Node links[]=new Node[26];
    int ew=0;//endwith
    int cp=0;//currentprefix
    Node get(char c){
        return links[c-'a'];
    }
    boolean containsKey(char c){
        if(links[c-'a']!=null)
            return true;
        else
            return false;
    }
    void put(char c,Node node){
        links[c-'a']=node;

    }
    void increasecp(){
        cp++;
    }
    void decreasecp(){
        cp--;
    }
    void increaseew(){
        ew++;
    }
    void decreaseew(){
        ew--;
    }
    int getEnd(){
        return ew;
    }
    int getPrefix(){
        return cp;
    }

}
public class Trie {
    Node root;
    public Trie() {
        // Write your code here.
        root=new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node=node.get(word.charAt(i));
            node.increasecp();
        }
        node.increaseew();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
            node=node.get(word.charAt(i));
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
            node=node.get(word.charAt(i));
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        // Write your code here.
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return;
            }
            node=node.get(word.charAt(i));
            node.decreasecp();
        }
        node.decreaseew();
    }

}
