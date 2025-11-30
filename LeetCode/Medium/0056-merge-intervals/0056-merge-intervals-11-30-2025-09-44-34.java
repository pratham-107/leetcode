class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> li = new LinkedList<>();
        for(int [] x : intervals){
            if(li.isEmpty() || li.getLast()[1] < x[0]){
                li.add(x);
            }
            else{
                li.getLast()[1] = Math.max(li.getLast()[1], x[1]);
            }
        }
        return li.toArray(new int[li.size()][]);
    }
}