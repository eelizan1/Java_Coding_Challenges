package TMobile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IntervalMain {
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        mergeIntervals(input);
    }

    // sort the intervals (a.start <= b.start
    // identify an overlap
        // if b.start <= a.end
    // create c interval such that:
        // c.start = a.start
        // c.end = max(a.end, b.end)
    static List<Interval> mergeIntervals(List<Interval> intervalList) {
        // sort the incoming interval list
        Collections.sort(intervalList, (a, b) -> Integer.compare(a.getStart(), b.getEnd()));

        // result list
        List<Interval> resultList = new ArrayList<>();
        // used to iterate the list
        Iterator<Interval> intervalIterator = intervalList.iterator();
        // current instance interval (a) with start and end values
        Interval interval = intervalIterator.next();
        int start = interval.getStart(); // set the start to a.start
        int end = interval.getEnd();

        // iterate through the list
        while(intervalIterator.hasNext()) {
            interval = intervalIterator.next();

            // if there's an overlap determine c's interval end
            if(interval.getStart() <= end) {
                end = Math.max(interval.getEnd(), end);
            } else {
                // add current interval to list
                resultList.add(new Interval(start, end));
                // move down the list
                start = interval.getStart();
                end = interval.getEnd();
            }
        }

        // add the last interval
        resultList.add(new Interval(start, end));

        return resultList;
    }
}
