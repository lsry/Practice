import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode0208{}

class Trie {
    private static class Node{
        public boolean isWord;
        public Map<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()){
            if (!cur.next.containsKey(c)){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()){
            if (!cur.next.containsKey(c)){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()){
            if (!cur.next.containsKey(c)){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    /**
     * 删除单词，依次将该单词字符从树中删除即可
     * 根据单词字符所在位置，其中可能有四种情况：
     * 1）最后字符不为叶子节点，则设置 isWord 为 false 即可；
     * 2）若所删字符含有其他分支，则停止删除；
     * 3）若所删字符为其他单词最后字符，则停止删除；
     * 4）无上述条件，此时仅为单支树，则直接删除
     * @param word 指定删除的单词
     */
    public void delete(String word){
        if (!search(word)){
            return;
        }
        Deque<Node> stack = new LinkedList<>();
        Node cur = root;
        for (char c : word.toCharArray()){
            stack.addFirst(cur);
            cur = cur.next.get(c);
        }
        if (cur.next == null || cur.next.isEmpty()){
            for (int i = word.length() - 1;i >= 0;i--){
                char c = word.charAt(i);
                Node pre = stack.removeFirst();
                if ((i != word.length() - 1 && pre.next.get(c).isWord) || !pre.next.get(c).next.isEmpty()){
                    break;
                }
                pre.next.remove(c);
            }
        } else {
            cur.isWord = false;
        }
    }
}