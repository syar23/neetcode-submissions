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

        //edge case
        if(intervals == null || intervals.size()<1)
            return 0;

        /// Build event points: +1 for start, -1 for end
        // To allow touching (end == start) without conflict, sort (time asc, type asc)
        // where type: -1 (end) before +1 (start).
        List<int[]> events = new ArrayList<>();
        for (Interval it : intervals) {
            events.add(new int[]{it.start, +1});
            events.add(new int[]{it.end,   -1});
        }
        events.sort((a, b) -> (a[0] != b[0]) ? Integer.compare(a[0], b[0])
                                             : Integer.compare(a[1], b[1])); // end(-1) before start(+1)

        int cur = 0, max = 0;
        for (int[] e : events) {
            cur += e[1];
            max = Math.max(max, cur);
        }
        return max; // minimum days (colors/rooms) needed
            
    }
}
