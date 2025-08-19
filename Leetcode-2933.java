/**
 * Time complexity : O(N)
 * Space complexity : O(NlogK) (K = avg times an employee accesses) / O(NlogN) worst case
 */
class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> employeeAcessTimes = new HashMap<>();

        for (List<String> access_time : access_times) {
            String name = access_time.get(0);
            String time = access_time.get(1);
            int minute = Integer.parseInt(time.substring(0, 2))*60 + Integer.parseInt(time.substring(2));

            employeeAcessTimes.putIfAbsent(name, new ArrayList<>());
            employeeAcessTimes.get(name).add(minute);
        }

        List<String> highAccessEmpl = new ArrayList<>();
        for (String key : employeeAcessTimes.keySet()) {
            List<Integer> times = employeeAcessTimes.get(key);
            Collections.sort(times);

            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i-2) < 60) {
                    highAccessEmpl.add(key);
                    break;
                }
            }
        }

        return highAccessEmpl;
    }
}