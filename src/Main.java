import java.util.*;

/**
 * @author epochong
 * @date 2019/9/12 21:45
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        if (str.length() < 1) {
            return;
        }
        char[] arr = str.toCharArray();
        ArrayList<Character> arrayList = new ArrayList <>();
        for (int i = 0; i < str.length(); i++) {
            arrayList.add(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                if (str.charAt(i) != str.charAt(i + 1)) {
                    arrayList.remove(i);
                }
            } else if (i == str.length() - 1)  {
                if (str.charAt(i) != str.charAt(i - 1)) {
                    arrayList.remove(str.length() - 1);
                }
            } else {
                if (str.charAt(i) != str.charAt(i + 1) && str.charAt(i - 1) != str.charAt(i)) {
                    arrayList.remove(i);
                }
            }
        }
        class Node{
            char c;
            int times;

            public Node(char c, int times) {
                this.c = c;
                this.times = times;
            }
        }
        class DescComparator implements Comparator<Node> {

            @Override
            public int compare(Node o1, Node o2) {
                if (o1.times > o2.times) {
                    return -1;
                } if (o1.times < o2.times) {
                    return 1;
                }
                return String.valueOf(o1.c).compareTo(String.valueOf(o2.c));
            }
        }
        TreeSet<Node> treeSet = new TreeSet <>();
        HashMap<Character,Integer> map = new HashMap <>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (map.containsKey(arrayList.get(i))) {
                map.put(arrayList.get(i),1);
            } else {
                map.put(arrayList.get(i),map.get(arrayList.get(i) + 1));
            }
        }
        for (Character c :
                map.keySet()) {
            treeSet.add(new Node(c,map.get(c)));
        }
        for (Node node :
                treeSet) {
            System.out.println(node.c + ":" + node.times);
        }
    }
}
