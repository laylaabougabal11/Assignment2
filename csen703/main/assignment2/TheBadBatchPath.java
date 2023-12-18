package csen703.main.assignment2;

import java.util.ArrayList;

public class TheBadBatchPath {

    private static int[] previous;


    //name check like assignment doc
    public static Integer TatooineToNabooDP(int[] fuel) {
        int length = fuel.length;
        int[] planetsLanded = new int[length];
        previous = new int[length];

        int i = 0;
        do {
            planetsLanded[i] = Integer.MAX_VALUE;
            previous[i] = 0;
            i++;
        } while (i < length);

        planetsLanded[0] = 0;

        i = 1;
        do {
            int j = 0;
            do {
                if (j + fuel[j] >= i && planetsLanded[j] != Integer.MAX_VALUE) {
                    if (planetsLanded[j] + 1 < planetsLanded[i]) {
                        planetsLanded[i] = planetsLanded[j] + 1;
                        previous[i] = j;
                    }
                }
                j++;
            } while (j < i);
            i++;
        } while (i < length);

        return planetsLanded[length - 1];
    }
    //check name like assignment doc
    // . add .get .remove .set .isEmpty .size .clear .contains .indexOf .lastIndexOf .toArray .subList .iterator (7agat el arraylist to use based on google)
    public static ArrayList<Integer> TatooineToNabooPath(int[] fuel) {
        ArrayList<Integer> path = new ArrayList<>();
        int length = fuel.length;
        int minimum = TatooineToNabooDP(fuel);
        int x = length - 1;

        do {
            path.add(x);
            x = previous[x];
        } while (x != 0);
        path.add(0);

        reversePath(path);

        return path;
    }

    // eftekri tgrabi te3meleeha mn 8eir el helper
    private static void reversePath(ArrayList<Integer> list) {
        int first = 0;
        int last = list.size() - 1;
    
        while (first < last) {
            int temp = list.get(first);
            list.set(first, list.get(last));
            list.set(last, temp);
            first++;
            last--;
        }
    }
    
    public static void main(String[] args) {
        int[] fuel = { 2, 3, 1, 1, 4 };
        System.out.println("Minimum number of landings: " + TatooineToNabooDP(fuel));
        System.out.println("Path: " + TatooineToNabooPath(fuel));
    }
}
