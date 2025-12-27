class Solution {
    /* Link: https://neetcode.io/problems/gas-station/history
     * Finds the starting gas station index from which you can complete
     * the circular route. Returns -1 if impossible.
     *
     * @param gas  array of gas available at each station
     * @param cost array of gas required to travel to the next station
     * @return starting station index, or -1 if not possible
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int gas_sum = 0;      // total gas available across all stations
        int cost_sum = 0;     // total cost to travel all stations
        int total_cost = 0;   // current tank balance during simulation
        int res = 0;          // candidate starting station index

        // Step 1: Calculate total gas
        for (int i : gas) {
            gas_sum += i;
        }

        // Step 2: Calculate total cost
        for (int i : cost) {
            cost_sum += i;
        }

        // Step 3: Quick check: if total gas < total cost, circle impossible
        if (gas_sum < cost_sum) {
            return -1;
        }

        // Step 4: Simulate journey through each station
        for (int i = 0; i < gas.length; i++) {
            // Add fuel gained at station and subtract cost to next station
            total_cost += gas[i] - cost[i];

            // If tank goes negative, starting station must be after i
            if (total_cost < 0) {
                res = i + 1;      // set next station as candidate start
                total_cost = 0;   // reset tank for next attempt
            }
        }

        // Step 5: Return candidate starting station
        return res;
    }
}
