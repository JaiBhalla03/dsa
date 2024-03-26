//import java.util.*;
//
///*
//
// Test Cases:
// Input :-
// 3
// 3
// 1 2 3
// 4 5 6
// 7 8 9
// output:-
// 1 2 3 6 9 8 7 4 5
//
// input:-
// 3
// 4
// 1 2 3 4
// 5 6 7 8
// 9 10 11 12
// output:-
// 1 2 3 4 8 12 11 10 9 5 6 7
// */
//
//
//public class prog16 {
//    public static void Spiral(int m, int n, int[][] mat){
//        int left = 0;
//        int right = n-1;
//        int top = 0;
//        int bottom = m-1;
//        while(top <= bottom && left <= right){
//            for(int i = left ; i <= right ; i++){
//                System.out.print(mat[top][i] + " ");
//            }
//            top++;
//            for(int i = top ; i <= bottom ; i++){
//                System.out.print(mat[i][right] + " ");
//            }
//            right--;
//            if(top < bottom){
//                for(int i = right ; i >= left ; i--){
//                    System.out.print(mat[bottom][i] + " ");
//                }
//                bottom--;
//            }
//            if(left < right){
//                for(int i = bottom ; i >= top ; i--){
//                    System.out.print(mat[i][left] + " ");
//                }
//                left++;
//            }
//        }
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        int[][] mat = new int[m][n];
//        for(int i = 0 ; i < m ; i++){
//            for(int j = 0 ; j < n ; j++){
//                mat[i][j] = sc.nextInt();
//            }
//        }
//        Spiral(m, n, mat);
//    }
//}
