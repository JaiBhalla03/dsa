//import java.util.*;
///**
// * Example 1
// * Input
// * 5
// * 1 2
// * 1 3
// * 2
// * 1 4
// * 2
// * Output:
// *
// *
// * Example 2
// * Input
// * 3
// * 2
// * 1 2
// * 2
// * Output:
// *
// */
//
//class StackQueue{
//    Stack<Integer> s1 = new Stack<>();
//    Stack<Integer> s2 = new Stack<>();
//    void push(int x){
//        while(!s1.isEmpty()){
//            s2.push(s1.pop());
//        }
//        s1.push(x);
//        while(!s2.isEmpty()){
//            s1.push(s2.pop());
//        }
//    }
//    int pop(){
//        if(!s1.isEmpty()) return s1.pop();
//        return -1;
//    }
//}
//public class prog8 {
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int q = sc.nextInt();
//        List<Integer> ans = new ArrayList<>();
//        StackQueue stack = new StackQueue();
//        while(q--  != 0){
//            int choice = sc.nextInt();
//            if(choice == 1){
//                int x = sc.nextInt();
//                stack.push(x);
//            }
//            if(choice == 2){
//                ans.add(stack.pop());
//            }
//        }
//        for(Integer el : ans){
//            System.out.print(el + " ");
//        }
//    }
//}
