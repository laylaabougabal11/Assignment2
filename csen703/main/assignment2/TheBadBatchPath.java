package csen703.main.assignment2;




import java.util.ArrayList;

public class TheBadBatchPath {

    private static int[] previous;

    public static Integer TatooineToNabooDP(int[] fuel) {
        int length = fuel.length;
        int[] planetsLanded = new int[length];
        previous = new int[length];

        int i = 0;
        while (i < length) {
            planetsLanded[i] = Integer.MAX_VALUE;
            previous[i] = 0;
            i++;
        }

        planetsLanded[0] = 0;

        i = 1;
        while (i < length) {
            int j = 0;
            while (j < i) {
                if (j + fuel[j] >= i && planetsLanded[j] != Integer.MAX_VALUE) {
                    if (planetsLanded[j] + 1 < planetsLanded[i]) {
                        planetsLanded[i] = planetsLanded[j] + 1;
                        previous[i] = j;
                    }
                }
                j++;
            }
            i++;
        }

        return planetsLanded[length - 1];
    }

    //. add .get .remove .set .isEmpty .size .clear .contains .indexOf .lastIndexOf .toArray .subList .iterator (7agat el arraylist to use based on google)
    public static ArrayList<Integer> TatooineToNabooPath(int[] fuel) {
        ArrayList<Integer> path = new ArrayList<>();
        int length = fuel.length;
        int minimum = TatooineToNabooDP(fuel);
        int currentIndex = length - 1;

        while (currentIndex != 0) {
            path.add(currentIndex);
            currentIndex = previous[currentIndex];
        }
        path.add(0);

        reversePath(path);

        return path;
    }

    //eftekri tgrabi te3meleeha mn 8eir el helper
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
