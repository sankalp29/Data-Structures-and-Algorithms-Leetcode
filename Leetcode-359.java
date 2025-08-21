/**
 * Time complexity : O(1) per shouldPrintMessage() call
 * Space complexity : O(N) 
 */
class Logger {
    Map<String, Integer> lastPrintTime;
    public Logger() {
        lastPrintTime = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!lastPrintTime.containsKey(message)) {
            lastPrintTime.put(message, timestamp);
            return true;
        }

        int lastPrintedAt = lastPrintTime.get(message);
        if (timestamp - lastPrintedAt < 10) return false;

        lastPrintTime.put(message, timestamp);
        return true;
    }
}