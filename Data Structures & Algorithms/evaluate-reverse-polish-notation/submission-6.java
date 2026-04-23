class Solution {
    public int evalRPN(String[] tokens) {
        //use stack to solve this
        // if we find numbers, we push them into stack
        //if we find operand, we pop elements from stack

        /*Stack<Integer> stack = new Stack<>();

        for(String s : tokens) {
            if(!(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*"))) {
                stack.push(Integer.parseInt(s));}
            else {
                if(s.equals("+")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a+b);
                } else if(s.equals("-")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b-a); 
                } else if(s.equals("*")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a*b); 
                } else {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b/a); 
                }
            }

            
            }
            return stack.pop();
            */

            Deque<Integer> stack = new ArrayDeque<>();

        for (String t : tokens) {
            switch (t) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "-" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                }
                case "/" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                }
                default -> stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
        }
    }

