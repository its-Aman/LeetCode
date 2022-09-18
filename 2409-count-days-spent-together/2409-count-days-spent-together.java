class Solution {
    int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] prefixMonths = new int[13];

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        for (int i = 0; i < months.length; i++)
            prefixMonths[i + 1] = months[i] + prefixMonths[i];

        var aliceArrive = parse(arriveAlice);
        var aliceLeave = parse(leaveAlice);

        var bobArrive = parse(arriveBob);
        var bobLeave = parse(leaveBob);

        if (bobArrive > aliceLeave || aliceArrive > bobLeave)
            return 0;

        var start = Math.max(aliceArrive, bobArrive);
        var end = Math.min(aliceLeave, bobLeave);

        return end - start + 1;
    }

    private int parse(String s) {
        String[] arr = s.split("-");
        int month = Integer.parseInt(arr[0]);
        int date = Integer.parseInt(arr[1]);

        return prefixMonths[month-1] + date;
    }
}