package learn.数据结构.tree.trie.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树/字典树
 * 哈希表实现
 */
public class Trie {

    Map<Character, Trie> map = new HashMap<>();
    boolean isWord;

    /**
     * 初始化前缀树
     */
    public Trie() {
        isWord = false;
    }

    /**
     * 插入一个单词
     */
    public void insert(String word) {
        Trie t = this;
        for (int i = 0; i < word.length(); i++) {
            Trie v;
            if ((v = t.map.get(word.charAt(i))) == null) {
                v = new Trie();
                t.map.put(word.charAt(i), v);
            }
            t = v;
            if (i == word.length() - 1) {
                t.isWord = true;
            }
        }
    }

    /**
     * 搜索单词是否存在
     */
    public boolean search(String word) {
        Trie search = searchPrefix(word);
        return search != null && search.isWord;
    }

    /**
     * 搜索是否存在此前缀的单词
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie t = this;
        for (int i = 0; i < prefix.length(); i++) {
            t = t.map.get(prefix.charAt(i));
            if (t == null) return null;
        }
        return t;
    }
}
