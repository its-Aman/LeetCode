class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

    for(String token: tokens) {
      if(Arrays.asList("+", "-", "*", "/").contains(token)){
        int ans = applyOps(stack.pop(), stack.pop(), token);
        stack.push(ans);
      } else {
        stack.push(Integer.parseInt(token));
      }
    }
    
    return stack.pop();
  }

  public int applyOps(int num1, int num2, String op) {
    int ans = 0;
    switch(op) {
      case "+": ans = num2 + num1; break;
      case "-": ans = num2 - num1; break;
      case "/": ans = num2 / num1; break;
      case "*": ans = num2 * num1; break;
    }
    return ans;
  }

  
}