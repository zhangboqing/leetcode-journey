import java.util.TreeMap;

/**
 * @author zhangboqing
 * @date 2019-11-25
 */
public class Leetcode_211 {

    /*
      设计一个支持以下两种操作的数据结构：

        void addWord(word)
        bool search(word)
        search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。

        示例:

        addWord("bad")
        addWord("dad")
        addWord("mad")
        search("pad") -> false
        search("bad") -> true
        search(".ad") -> true
        search("b..") -> true
        说明:

        你可以假设所有单词都是由小写字母 a-z 组成的。
    */

    class WordDictionary {

        private class Node {
            public boolean isWorkd;
            public TreeMap<Character, Node> next;

            public Node(boolean isWorkd) {
                this.isWorkd = isWorkd;
                next = new TreeMap<>();
            }

            public Node() {
                this(false);
            }
        }

        public Node root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            if (word == null) {
                return;
            }

            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null) {
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }

            if (!cur.isWorkd) {
                cur.isWorkd = true;
            }
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            if (word == null) {
                return false;
            }

            return match(root, word, 0);
        }

        private boolean match(Node node, String word, int index) {

            if (node == null) {
                return false;
            }
            char c = word.charAt(index);
            if ('.' != c) {
                Node next = node.next.get(c);
                if (next == null) {
                    return false;
                }
                if ((word.length() == index +1)) {
                    if (next.isWorkd) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return match(next,word,index+1);
                }

            } else {
                for (Node next :  node.next.values()) {
                    if ((word.length() == index +1)) {
                        if (next.isWorkd) {
                            return true;
                        }
                    } else {
                        boolean match = match(next, word, index + 1);
                        if (match) {
                            return true;
                        }
                    }
                }

                return false;
            }

        }

//        public boolean match(String word, int index, Node node){
//            if(index == word.length())
//                return node.isWorkd;
//            char ch = word.charAt(index);
//            if(ch == '.'){
//                for(char c : node.next.keySet()){
//                    if(node.next.get(c) != null && match(word, index + 1, node.next.get(c)))
//                        return true;
//                }
//                return false;
//            }else{
//                if(node.next.get(ch) == null)
//                    return false;
//                else
//                    return match(word, index + 1, node.next.get(ch));
//            }
//
//        }

    }


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
