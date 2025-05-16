class Solution {
    public int maxTwoEvents(int[][] events) {
        record Event (int time, int val, int isstart){}
        int ans = 0;
        int max = 0;
        Event[] evts = new Event[events.length * 2];

        for(int i=0; i<events.length; i++){
            int start = events[i][0];
            int end = events[i][1];
            int val = events[i][2];
            evts[i * 2] = new Event(start, val, 1);
            evts[i * 2 + 1] = new Event(end + 1, val, 0);
        }
        Arrays.sort(evts, Comparator.comparingInt(Event::time).thenComparingInt(Event::isstart));

        for(Event evt : evts){
            if(evt.isstart == 1){
                ans = Math.max(ans, evt.val + max);
            }
            else{
                max = Math.max(max, evt.val);
            }
        }
        return ans;
    }
}