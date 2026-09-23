class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0)
            return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : hand) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        while (!map.isEmpty()) {

            int min = Collections.min(map.keySet());

            for (int i = 0; i < groupSize; i++) {

                int num = min + i;

                if (!map.containsKey(num))
                    return false;

                map.put(num, map.get(num) - 1);

                if (map.get(num) == 0)
                    map.remove(num);
            }
        }

        return true;
    }
}