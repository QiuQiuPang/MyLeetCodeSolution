import java.util.Stack;

public class Solution_682 {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","2","C","D","+"}));
    }

    public static int calPoints(String[] ops) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(String op: ops){
            switch (op){
                case "+" :
                    int x = stack.pop(), y = stack.peek(), z = x + y;
                    stack.push(x);
                    stack.push(z);
                    break;
                case "D":
                    stack.add(stack.peek()*2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
}
