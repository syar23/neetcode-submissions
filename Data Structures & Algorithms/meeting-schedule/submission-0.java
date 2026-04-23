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
    public boolean canAttendMeetings(List<Interval> intervals) {
      
        if(intervals == null || intervals.size()<1)
            return true;

        //1.sort by start time of meetings
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));

        // 2. Check for overlap
        int prevEnd = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start < prevEnd) {
                return false;  // overlap found
            }
            prevEnd = curr.end;
        }

        return true; // no overlaps → can attend all


    }
}
