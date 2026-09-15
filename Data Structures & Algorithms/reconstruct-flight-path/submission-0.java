class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> tks: tickets) {
            map.computeIfAbsent(tks.get(0), k -> new PriorityQueue<>()).add(tks.get(1));
        }

        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", res, map);
        return res;
    }

    public void dfs(String src, LinkedList<String> res, HashMap<String, PriorityQueue<String>> map) {
        PriorityQueue<String> heap = map.get(src);
        while(heap != null && !heap.isEmpty()) {
            String dest = heap.poll();
            dfs(dest, res, map);
        }
        res.addFirst(src);
    }
}
