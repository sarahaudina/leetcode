// Intuition: Valid string contains parentheses that are surounding valid parentheses. That means every opening parentheses should find their match before the outer parenthese finding their own match. Since the  item appear later in the string will find the match earlieast, this problem can be solved with a LIFO system, hence stack can be used. 

// Solution: we add opening parentheses to the stack, and pop them from the stack when we find the matching closing parenthesees as we iterate the string. if the last item in the stack doesnt match the last item in the string, then its not a valid string.

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // Map available parentheses pairing, so we can easily check what is the correct pair for a closing parentheses. To improve space complexity we can use conditional statement instead, since we only check 4 pairing, using map won't have significant improvement to time complexity'
        Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');

        for (int i=0; i<s.length(); i++) {
            char current = s.charAt(i);
            if (map.containsValue(current)) {
                stack.push(current);
            } else if (stack.empty()) {
                return false;
            } else if (map.get(current)!=stack.pop()){
                return false;
            }
        }

        return stack.empty();
    }
}