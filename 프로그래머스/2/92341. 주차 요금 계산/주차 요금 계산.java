import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        // 입차 시 맵에 넣고 출차 시 시간 측정. (리스트가 남아있을 경우 23:59분 출차로 측정)
        // map에 차량 번호별 누적 시간 저장
        // 요금 계산
        Map<Integer, String> parking = new HashMap<>();
        Map<Integer, Integer> acc = new HashMap<>();
        Set<Integer> keySet = new HashSet<>();

        for(String record : records){
            String[] s = record.split(" ");
            String time = s[0];
            int car = Integer.parseInt(s[1]);
            String inout = s[2];
            
            if(inout.equals("IN")){
                parking.put(car, time);
                keySet.add(car);
            }else{
                int end = minute(time);
                int start = minute(parking.get(car));
                int diff = end - start;
                acc.put(car, acc.getOrDefault(car, 0) + diff);
                parking.remove(car);
                keySet.add(car);
            }
        }
        parking.forEach((k,v)-> {
            int end = minute("23:59");
            int start = minute(v);
            int diff = end - start;
            acc.put(k, acc.getOrDefault(k, 0) + diff);
        });
        
        ArrayList<Integer> al = new ArrayList<>(keySet);
        Collections.sort(al);
        answer = new int[al.size()];
        for(int i = 0; i < al.size(); i++){
            int total = acc.get(al.get(i));
            System.out.println(total);
            if(total <= fees[0]){
                answer[i] = fees[1];
            }else{
                int add = (total - fees[0]) / fees[2];
                if((total - fees[0]) % fees[2] != 0){
                    add += 1;
                }
                answer[i] = fees[1] + add * fees[3];
            }
        }
        return answer;
    }
    
    public int minute(String time){
        String[] hm = time.split(":");
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }
}
// import java.util.*;
// import java.time.*;
// class Solution {
//     public int[] solution(int[] fees, String[] records) {
//         int[] answer = {};
//         // 입차 시 맵에 넣고 출차 시 시간 측정. (리스트가 남아있을 경우 23:59분 출차로 측정)
//         // map에 차량 번호별 누적 시간 저장
//         // 요금 계산
//         Map<Integer, String> parking = new HashMap<>();
//         Map<Integer, Integer> acc = new HashMap<>();
//         Set<Integer> keySet = new HashSet<>();

//         for(String record : records){
//             String[] s = record.split(" ");
//             String time = s[0];
//             int car = Integer.parseInt(s[1]);
//             String inout = s[2];
            
//             if(inout.equals("IN")){
//                 parking.put(car, time);
//                 keySet.add(car);
//             }else{
                
//                 String[] endT = time.split(":");
//                 String[] startT = parking.get(car).split(":");
//                 LocalTime end = LocalTime.of(Integer.parseInt(endT[0]), Integer.parseInt(endT[1]));
//                 LocalTime start = LocalTime.of(Integer.parseInt(startT[0]), Integer.parseInt(startT[1]));
//                 Duration duration = Duration.between(start, end);
//                 int diff = (int)duration.toMinutes();
//                 acc.put(car, acc.getOrDefault(car, 0) + diff);
//                 parking.remove(car);
//                 keySet.add(car);
//             }
//         }
//         parking.forEach((k,v)-> {
//             String[] startT = parking.get(k).split(":");
//             LocalTime end = LocalTime.of(23, 59);
//             LocalTime start = LocalTime.of(Integer.parseInt(startT[0]), Integer.parseInt(startT[1]));
//             Duration duration = Duration.between(start, end);
        
//             int diff = (int)duration.toMinutes();
//             acc.put(k, acc.getOrDefault(k, 0) + diff);
//         });
        
//         ArrayList<Integer> al = new ArrayList<>(keySet);
//         Collections.sort(al);
//         answer = new int[al.size()];
//         for(int i = 0; i < al.size(); i++){
//             int total = acc.get(al.get(i));
//             System.out.println(total);
//             if(total <= fees[0]){
//                 answer[i] = fees[1];
//             }else{
//                 int add = (total - fees[0]) / fees[2];
//                 if((total - fees[0]) % fees[2] != 0){
//                     add += 1;
//                 }
//                 answer[i] = fees[1] + add * fees[3];
//             }
//         }
            
            
            
//         return answer;
//     }
    
//     public int minute(String time){
        
//     }
// }