import java.util.*;

public class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for(int i = 0; i < queries.length; i++) {
            Queue<Integer> queue = map.getOrDefault(queries[i], new ArrayDeque<>());
            queue.offer(i);
            map.put(queries[i], queue);
        }
        Arrays.sort(queries);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> pq = new PriorityQueue(Comparator.comparingInt((int[] a) -> a[1] - a[0]));


        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        int j = 0;
        for(int q : queries) {
            while(j < intervals.length && intervals[j][0] <= q) {
                pq.offer(intervals[j]);
                j++;
            }
            while(!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }
            if(!pq.isEmpty()) {
                int ans = pq.peek()[1] - pq.peek()[0] + 1;
                res[map.get(q).poll()] = ans;
            }

        }

        return res;
    }
}