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
// * 3 4
// *
// * Example 2
// * Input
// * 3
// * 2
// * 1 2
// * 2
// * Output:
// * -1 2
// */
////the following is the code to create a stack from a queue
//class Queues{
//    Queue<Integer> q1 = new LinkedList<>();
//    Queue<Integer> q2 = new LinkedList<>();
//    void push(int x){
//        while(!q1.isEmpty()){
//            q2.add(q1.poll());
//        }
//        q1.add(x);
//        while(!q2.isEmpty()){
//            q1.add(q2.poll());
//        }
//    }
//    int pop(){
//        if(q1.isEmpty()) return -1;
//        return q1.poll();
//    }
//}
//public class prog9 {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int q = sc.nextInt();
//        Queues queue = new Queues();
//        List<Integer> ans = new ArrayList<>();
//        while(q-- != 0){
//            int choice = sc.nextInt();
//            if(choice == 1){
//                int x = sc.nextInt();
//                queue.push(x);
//            }
//            else{
//                ans.add(queue.pop());
////            }
//        }
//        for(Integer num : ans){
//            System.out.print(num + " ");
//        }
//    }
//}
