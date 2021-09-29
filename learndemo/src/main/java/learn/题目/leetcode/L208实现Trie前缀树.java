package learn.题目.leetcode;

import learn.数据结构.tree.trie.table.Trie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class L208实现Trie前缀树 {

    @Test
    public void tt() {
        {
            Trie trie = new Trie();
            trie.insert("apple");
            Assertions.assertTrue(trie.search("apple"));
            Assertions.assertFalse(trie.search("app"));
            Assertions.assertTrue(trie.startsWith("app"));
            trie.insert("app");
            Assertions.assertTrue(trie.search("app"));
        }
    }
}
