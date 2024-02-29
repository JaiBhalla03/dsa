class Solution {
    public static Node treeFromString(String s) {
        int[] start = new int[]{0}; // Start index array to allow modification within recursive calls
        return treeFromStringHelper(s, start);
    }

    private static Node treeFromStringHelper(String s, int[] start) {
        if (s == null || s.length() == 0 || start[0] >= s.length()) return null;

        boolean neg = false;
        if (s.charAt(start[0]) == '-') {
            neg = true;
            start[0]++;
        }

        int num = 0;
        int count = 0;
        while (start[0] < s.length() && Character.isDigit(s.charAt(start[0]))) {
            int digit = Character.getNumericValue(s.charAt(start[0]));
            num = num * 10 + digit;
            start[0]++;
            count++;
        }

        if (neg) {
            num = -num;
        }

        Node node = null;
        if(count > 0){
            node = new Node(num);
        }


        if (start[0] < s.length() && s.charAt(start[0]) == '(') {
            start[0]++;
            node.left = treeFromStringHelper(s, start);
        }

        if (start[0] < s.length() && s.charAt(start[0]) == ')') {
            start[0]++;
            return node;
        }

        if (start[0] < s.length() && s.charAt(start[0]) == '(') {
            start[0]++;
            node.right = treeFromStringHelper(s, start);
        }

        if (start[0] < s.length() && s.charAt(start[0]) == ')') {
            start[0]++;
            return node;
        }

        return node;
    }
}
