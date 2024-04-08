package mhouhouattempt;

//we use recursion to navigate, this is just a simple tree
public class Eval {
    public static class Node {
        String data;
        Node left, right;

        Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

}
