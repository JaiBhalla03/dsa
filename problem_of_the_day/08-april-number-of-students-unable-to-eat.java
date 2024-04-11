class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int top = 0;
        Queue<Integer> q = new LinkedList<>();
        //adding the students to the queue
        for(int i = 0 ; i < students.length ; i++){
            q.add(students[i]);
        }
        int count = 0;
        while(!q.isEmpty()){
            if(q.peek() == sandwiches[top]){
                q.poll();
                top++;
                count = 0;
            }
            else{
                q.add(q.poll());
                count++;
                if(count == q.size()){
                    return q.size();
                }
            }
        }
        return 0;
    }
}