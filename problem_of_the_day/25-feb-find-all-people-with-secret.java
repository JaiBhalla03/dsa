class Solution {
    public List<Integer> bfs(int first_person, int N, Map<Integer, List<int[]>> adjancency_list){
        boolean[] visited_array = new boolean[N];
        PriorityQueue<int[]> min_heap = new PriorityQueue<int[]>((a, b)->(a[0] - b[0]));
        min_heap.add((new int[]{0,0}));
        min_heap.add((new int[]{0, first_person}));

        while(!min_heap.isEmpty()){
            int[] current_meeting_details_array = min_heap.poll();
            int current_time = current_meeting_details_array[0];
            int current_node = current_meeting_details_array[1];
            if(visited_array[current_node]){
                continue;
            }
            visited_array[current_node] = true;
            for(int[] neighbour_node_meeting_details_array : adjancency_list.getOrDefault(current_node , (new ArrayList<int[]>()))){

                int neighbour_node = neighbour_node_meeting_details_array[0];

                int neighbour_node_time = neighbour_node_meeting_details_array[1];

                if(visited_array[neighbour_node]){
                    continue;
                }

                if(neighbour_node_time >= current_time){
                    min_heap.add((new int[] {neighbour_node_time , neighbour_node}));
                }
            }
        }
        List<Integer> persons_who_knows_secret = new ArrayList<Integer>();
        for(int node = 0; (node<N); node++){
            if(visited_array[node]){
                persons_who_knows_secret.add(node);
            }
        }
        return persons_who_knows_secret;
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> adjancency_list = new HashMap<>();
        for(int[] meeting_details_array : meetings){
            int node1 = meeting_details_array[0];
            int node2 = meeting_details_array[1];
            int time = meeting_details_array[2];
            //since bidirectional
            adjancency_list.computeIfAbsent(node1, (k->(new ArrayList<>()))).add((new int[] {node2, time}));
            adjancency_list.computeIfAbsent(node2, (k->(new ArrayList<>()))).add((new int[] {node1, time}));
        }
        return bfs(firstPerson, n, adjancency_list);
    }
}