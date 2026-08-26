class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        PriorityQueue<int[]> busyrooms = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        );

        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }
        int[] count = new int[n];

        for (int[] m: meetings) {
            int start = m[0];
            int end = m[1];
            int duration = end - start;
            while (!busyrooms.isEmpty() && busyrooms.peek()[0] <= start) {
        availableRooms.offer(busyrooms.poll()[1]);
    }
            int room;
            if (!availableRooms.isEmpty()) {
                room = availableRooms.poll();
                busyrooms.offer(new int[]{end, room});
            } else {
                int[] earliest = busyrooms.poll();

                int freeTime = earliest[0];
                room = earliest[1];

                // Delay the meeting but preserve its duration
                int newEnd = freeTime + duration;

                busyrooms.offer(new int[]{newEnd, room});
            }

            count[room]++;
        }

        int answer = 0;

        for (int i = 1; i < n; i++) {
            if (count[i] > count[answer]) {
                answer = i;
            }
        }

        return answer;
    }
}



// sort meetings by start

// for each meeting:

//     free rooms that have ended

//     if available room exists:
//         use smallest room
//         schedule normally
//     else:
//         take earliest-free room
//         delay meeting
//         preserve duration

//     count[room]++