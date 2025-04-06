// Time Complexity: O(n) where n is the number of days
// Space Complexity: O(n) for the stack

import java.util.Stack;

class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        //maintain monotonic decreasing stack for next greater
        int n = temperatures.length;

        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }

        return res;
    }
}