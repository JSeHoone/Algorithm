import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTimeMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new HashMap<>();
        
        for (String record : records) {
            String[] input = record.split(" ");
            
            int recordMin = convertMinute(input[0]);
            String numberBoard = input[1];
            String command = input[2];
            
            if (command.equals("IN")) {
                inTimeMap.put(numberBoard, recordMin);
            } else if (command.equals("OUT")) {
                int inTime = inTimeMap.get(numberBoard);
                int parkedTime = recordMin - inTime;
                
                totalTimeMap.merge(numberBoard, parkedTime, Integer::sum);
                inTimeMap.remove(numberBoard);
            }
        }
        
        for (String car : inTimeMap.keySet()) {
            int inTime = inTimeMap.get(car);
            int parkedTime = (23 * 60 + 59) - inTime;
            totalTimeMap.merge(car, parkedTime, Integer::sum);
        }

        return feeCalculator(fees, totalTimeMap);
    }
    
    public int convertMinute(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        return (hour * 60) + min;
    }
    
    public int[] feeCalculator(int[] feeInfo, Map<String, Integer> totalTimeMap) {
        int basicTime = feeInfo[0];
        int basicFee = feeInfo[1];
        int overTime = feeInfo[2];
        int overFee = feeInfo[3];

        List<String> carNumbers = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(carNumbers); // 차량번호 정렬

        int[] response = new int[carNumbers.size()];

        for (int i = 0; i < carNumbers.size(); i++) {
            String car = carNumbers.get(i);
            int totalTime = totalTimeMap.get(car);

            int fee;
            if (totalTime <= basicTime) {
                fee = basicFee;
            } else {
                int over = totalTime - basicTime;
                fee = basicFee + (int) Math.ceil((double) over / overTime) * overFee;
            }
            response[i] = fee;
        }

        return response;
    }
}
