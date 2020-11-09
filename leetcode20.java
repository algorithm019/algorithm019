class leetcode20 {
    public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            //左边括号就入栈

            for(int i = 0;i < s.length(); i++) {
                //左括号入栈
                char temp = s.charAt(i);
                if(temp == '{' || temp =='(' || temp =='['){
                    stack.push(temp);
                } else {
                    //检查栈是否为控股
                    if(stack.isEmpty()) {
                        return false; //

                    }else {
                        //判断栈顶元素左括号和当前字符的右括号是否匹配
                        char cur = s.charAt(i);
                        char topChar = stack.peek();// return the top value of the stack
                        if(cur == ')' && topChar =='(' || cur =='}' && topChar == '{' || cur == ']' && topChar == '[') {
                            stack.pop();
                        }else {// not element 对应要求
                            return false;
                        }


                    }
                }


            }

            //判断栈是否为空
            if(!stack.isEmpty()) {
                return false;
            }
            return true;

    }
}