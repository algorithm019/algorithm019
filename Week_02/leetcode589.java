class leetcode589 {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if(root == null) return output;
        //把根节点放进去
        stack.add(root);
        while(!stack.isEmpty()) {

            Node node = stack.pollLast();
            System.out.println(node.val);
            output.add(node.val);
            //这布很关键，根据stack先入后出来的
            //1后面想出3，就得最后放3，这样子就算先出来
            //所以需要这一步
            Collections.reverse(node.children);//集合中的值反转，
            for(Node item: node.children) {//直接把子节点的集合遍历加入栈中
                stack.add(item);
            }
        }
        return output;
        
    }
}