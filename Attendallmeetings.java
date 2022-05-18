/*

Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei), determine if a person could attend all meetings.
Input:
[[0,30],[5,10],[15,20]]
Output:
 false
Example 2:
Input:
 [[7,10],[2,4]]

Output:
 true
 
 
 
 
 */
 
 /**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
           public int compare(Interval i1, Interval i2) {
               return i1.start - i2.start;
           } 
        });
        Interval last = null;
        for (Interval i: intervals) {
            if (last != null && i.start < last.end) {
                return false;
            }
            last = i;
        }
        return true;
    }
}


//Sorting




public boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }        
    });
    for (int i = 0; i < intervals.length - 1; i++) {
        if (intervals[i].end > intervals[i + 1].start) return false;
    }
    return true;
}




//Other implementation
//Sorting - throw expection
private boolean canAttendMeetings(Interval[] intervals) {
    try {
        Arrays.sort(intervals, new IntervalComparator());
    } catch (Exception e) {
        return false;
    }
    return true;
}

private class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        if (o1.start < o2.start && o1.end <= o2.start)
            return -1;
        else if (o1.start > o2.start && o1.start >= o2.end)
            return 1;
        throw new RuntimeException();
    }
}
Java 8
public boolean canAttendMeetings(Interval[] intervals) {
    // Sort the intervals by start time
    Arrays.sort(intervals, (x, y) -> x.start - y.start);
    for (int i = 1; i < intervals.length; i++)
        if (intervals[i-1].end > intervals[i].start)
            return false;
    return true;
}
