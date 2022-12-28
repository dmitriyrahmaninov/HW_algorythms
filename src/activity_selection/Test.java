package activity_selection;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Activity> list = new ArrayList<>();
        list.add(new Activity("c", 2, 4));
        list.add(new Activity("a", 1, 3));
        list.add(new Activity("b", 1, 7));
        list.add(new Activity("f", 7, 8));
        list.add(new Activity("e", 4, 6));
        list.add(new Activity("d", 5, 9));

        ActivitySelection activitySelection = new ActivitySelection();
        activitySelection.selectActivity(list);
    }
}
