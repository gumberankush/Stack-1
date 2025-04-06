// Time Complexity: O(n) where n is the number of elements in the array
// Space Complexity: O(n) for the stack

import java.util.Arrays;
import java.util.Stack;

class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 2*n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n]){
                int idx = stack.pop();
                res[idx] = nums[i%n];
            }
            if(i < n){
                stack.push(i);
            }
        }
        return res;
    }
}