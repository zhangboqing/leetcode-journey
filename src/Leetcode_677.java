import java.util.TreeMap;

/**
 * @author zhangboqing
 * @date 2019-11-25
 */
public class Leetcode_677 {

  /*
    实现一个 MapSum 类里的两个方法，insert 和 sum。

        对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。

        对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。

        示例 1:

        输入: insert("apple", 3), 输出: Null
        输入: sum("ap"), 输出: 3
        输入: insert("app", 2), 输出: Null
        输入: sum("ap"), 输出: 5
  */

    class MapSum {

        private class Node {

            public int value;
            public TreeMap<Character,Node> next;

            public Node(int value) {
                this.value = value;
                next = new TreeMap<>();
            }

            public Node() {
                this(0);
            }
        }


        public Node root;
        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            if (key == null) {
                return;
            }
            insert(root,key,val,0);
        }

        private void insert(Node node, String key, int val  ,int index) {

            if (key.length() == index) {
                return;
            }

            char c = key.charAt(index);
            Node next = node.next.get(c);
            if (next == null) {
                next = new Node();
                node.next.put(c,next);
            }

            if (key.length() == index + 1) {
                next.value = val;
                return;
            }  else {
                insert(next,key,val,index+1);
            }

        }

        public int sum(String prefix) {

            if (prefix == null) {
                return 0;
            }

            Node cur = root;
            int index = 0;
            while (index != prefix.length()) {
                char c = prefix.charAt(index);
                cur = cur.next.get(c);
                if (cur == null) {
                    return 0;
                }
                index++;
            }

            return sum(cur);
        }

        private int sum(Node cur) {
            if (cur.next.values().size() == 0) {
                return cur.value;
            }
            int sum = cur.value;
            for (Node node: cur.next.values()) {
                sum += sum(node);
            }
            return sum;
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
