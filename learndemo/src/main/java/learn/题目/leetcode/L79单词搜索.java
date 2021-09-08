package learn.题目.leetcode;

import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NonAsciiCharacters")
public class L79单词搜索 {

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int x = 0; x < board[0].length; x++) {
            for (int y = 0; y < board.length; y++) {
                if (board[y][x] == chars[0]) {
                    board[y][x] = (char) (board[y][x] + 100);
                    boolean search = search(board, x, y, chars, 1);
                    board[y][x] = (char) (board[y][x] - 100);
                    if (search) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int x, int y, char[] word, int i) {
        if (i == word.length) return true;
        //上下左右进行搜索
        for (int t = 0; t < 4; t++) {
            int x2, y2;
            if (t == 0) {
                x2 = x;
                y2 = y - 1;
            } else if (t == 1) {
                x2 = x;
                y2 = y + 1;
            } else if (t == 2) {
                x2 = x - 1;
                y2 = y;
            } else {
                x2 = x + 1;
                y2 = y;
            }
            if (isSafe(board, x2, y2) && board[y2][x2] == word[i]) {
                board[y2][x2] = (char) (board[y2][x2] + 100);
                boolean search = search(board, x2, y2, word, i + 1);
                board[y2][x2] = (char) (board[y2][x2] - 100);
                if (search) return true;
            }
        }
        return false;
    }

    private boolean isSafe(char[][] board, int x, int y) {
        if (x < 0) return false;
        if (x >= board[0].length) return false;
        if (y < 0) return false;
        if (y >= board.length) return false;
        return board[y][x] <= 'z';
    }

    @Test
    public void tt() {
        BiPredicate<char[][], String> func = this::exist;
        {
            char[][] data = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            assertTrue(func.test(data, "ABCCED"));
        }
        {
            char[][] data = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            assertTrue(func.test(data, "SEE"));
        }
        {
            char[][] data = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            assertFalse(func.test(data, "ABCB"));
        }
    }

}
