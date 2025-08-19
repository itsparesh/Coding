public class Solution {
    private TrieNode root = new TrieNode();
    StringBuilder res =  new StringBuilder();

    public String longestCommonPrefix(String[] strs) {
        for (String str: strs) {
            insert(str);
        }
        if (root.children.size() != 1) {
            return "";
        }
        TrieNode node = root;
        while (!node.isEndOfWord && node.children.size() == 1) {
            char ch = node.children.keySet().iterator().next();
            res.append(ch);
            node = node.children.get(ch);
        }
        return res.toString();
    }

    private void insert(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            node.children.computeIfAbsent(c, k -> new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
