package Grokking.Merge;

import java.util.*;

public class MergeIntervals {
    //Intervals: [[1,4], [2,5], [7,9]]
    //Output: [[1,5], [7,9]]
    //Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
    //one [1,5].
    //Intervals: [[6,7], [2,4], [5,9]]
    //Output: [[2,4], [5,9]]
    //Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
    //Intervals: [[1,4], [2,6], [3,5]]
    //Output: [[1,6]]
    //Explanation: Since all the given intervals overlap, we merged them into one.
    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 4);
        Interval interval2 = new Interval(2, 5);
        Interval interval3 = new Interval(7, 9);
        List<Interval> list = new ArrayList<>();
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        //merge(list);
        System.out.println(hasOverlap(list));
    }

    static boolean hasOverlap(List<Interval> intervals) {
        // sort intervals
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // list to output merged intervals
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        // use to traverse the list and access list's data
        Iterator<Interval> intervalItr = intervals.iterator();

        // instance of the interval object used as we iterate the list - 'a' interval
        Interval interval = intervalItr.next();
        // list's current interval end
        int end = interval.end;

        while(intervalItr.hasNext()) {
            interval = intervalItr.next();

            if (interval.start <= end) {
                return true;
            }
        }

        return false;
    }


    // 1. sort the intervals on the start time where a.start <= b.start
    // 2. if 'a' overlaps 'b', merge them into new interval c such that:
    // c.start = a.start - a.start will always be the beginning assume sorted
    // c.end = max(a.end, b.end) - a.end = if a overlaps b, b.end if b.end continues past a.end
    static List<Interval> merge(List<Interval> intervals) {
        // sort intervals
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // list to output merged intervals
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        // use to traverse the list and access list's data
        Iterator<Interval> intervalItr = intervals.iterator();

        // instance of the interval object used as we iterate the list - 'a' interval
        Interval interval = intervalItr.next();
        // list's current interval start and end
        int start = interval.start;
        int end = interval.end;

        // loop through list
        while(intervalItr.hasNext()) {
            // the 'b' interval
            interval = intervalItr.next();
            // If ‘a’ overlaps ‘b’ - overlapping intervals, adjust the 'end'
            // b.start <= a.end - if true then we have an overlap
            if(interval.start <= end) {
                // determine c's end by comparing a.end (end) and b.end (interval.end)
                end = Math.max(end, interval.end);
            } else {
                // if no next overlap, add last over lap made
                mergedIntervals.add(new Interval(start, end));
                // assign start and end to next interval's start and end - the interval with no overlap
                start = interval.start;
                end = interval.end;
            }
        }

        // add the last interval if no overlap
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};
