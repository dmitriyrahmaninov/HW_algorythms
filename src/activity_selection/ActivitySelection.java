package activity_selection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {
    public void selectActivity(List<Activity> list) {
        printList(list);
        System.out.println("================");
        list.sort(Comparator.comparingInt(activity -> activity.getEnd())); //сравнение по конечному времени
//        list.sort(Comparator.comparingInt(Activity::getEnd)); //сортируем список 8строка=9строке
        printList(list);
        System.out.println("================");


        Activity first = list.get(0);
        List<Activity> result = new ArrayList<>();
        result.add(first);

        int endTime = first.getEnd();

        for(int i = 1; i < list.size(); i++){ // O(n)
            if(list.get(i).getStart() >= endTime){
                Activity current = list.get(i); // O(1)
                result.add(current);
                endTime = current.getEnd();
            }
        }

        printList(result);

    }
    private void printList(List<Activity> list){
        for(Activity a : list){
            System.out.println(a.getName());

        }
    }
}
