/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for(Interval interval: intervals) {
            start.add(interval.start);
            end.add(interval.end);
        }

        start.sort(null);
        end.sort(null);

        int i=0, j=0;
        int max = 0, count = 0;

        while(i < intervals.size()) {
            if(start.get(i) < end.get(j)) {
                i+=1;
                count+=1;
            } else {
                j+=1;
                count-=1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
