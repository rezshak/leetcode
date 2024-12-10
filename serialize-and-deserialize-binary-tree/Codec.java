// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Use preorder traversal for serialization
        if (root == null) {
            return "null";
        }

        // Recursive serialization with comma-separated values
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // nlr
    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null");
            sb.append(",");
            return;
        }
        sb.append(node.val);
        sb.append(",");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Use a queue to keep track of nodes during deserialization
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(Queue<String> nodes) {
        // Remove the first node from the queue
        String val = nodes.poll();

        // If null, return null
        if (val.equals("null")) {
            return null;
        }

        // Preorder DFS reconstruction
        TreeNode node = new TreeNode(Integer.parseInt(val));

        // Recursively deserialize left and right subtrees
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);

        return node;
    }

    public static void main(String[] args) {
        var codec = new Codec();

        var root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        String serialized1 = codec.serialize(root1);
        System.out.println(serialized1); // 1,2,null,null,3,4,null,null,5,null,null
        TreeNode deserialized1 = codec.deserialize(serialized1);
        String serialized2 = codec.serialize(deserialized1);
        System.out.println(serialized2); // 1,2,null,null,3,4,null,null,5,null,null

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
