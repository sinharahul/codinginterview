package test;
import java.util.*;
class Trie {
    private Node root;
    class Node {
        Character val;
        Map<Character,Node> map=new HashMap<>();
    }
    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word)
    {
        char[] arr=word.toCharArray();
        Node curr=new Node();
        for(Character ch:arr){
            Node n=new Node();
            n.val=ch;
            if(root!=null)
            {
                curr.map.put(ch,n);
                curr=n;
            }
            else {
                root=curr;
                root.map.put(ch,n);
                curr=n;
            }


        }
    }


    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr=root;
        for(Character ch:word.toCharArray()){
            Node nc=curr.map.get(ch);
            if(nc==null || !ch.equals(curr.val)){
                return false;
            }
            curr=nc;
        }
        return curr.map.size()==0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr=root;
        for(Character ch:prefix.toCharArray()){
            Node nc=curr.map.get(ch);
            if(nc==null){
                return false;
            }
            curr=nc;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */