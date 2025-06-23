package Tools;

import java.util.HashMap;
import java.util.Map;


class TrieNode { // 字典树节点

    public final Map<Character, TrieNode> children;
    public boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}


class Trie { // 字典树

    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) { // 插入单词
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.children.containsKey(c)) p.children.put(c, new TrieNode());
            p = p.children.get(c);
        }
        p.isWord = true;
    }

    public TrieNode searchPrefix(String word) { // 查找前缀
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.children.containsKey(c)) return null;
            p = p.children.get(c);
        }
        return p;
    }

    public boolean search(String word) { // 查找单词
        TrieNode p = searchPrefix(word);
        return p != null && p.isWord;
    }
}