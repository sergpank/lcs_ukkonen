import stree.SuffixTree;

public class MainTest {

    public static void main(String[] args) {
        SuffixTree tree = new SuffixTree();
        tree.addWord("abc");

        System.out.println(tree.getLongestSubstring());
    }
}
