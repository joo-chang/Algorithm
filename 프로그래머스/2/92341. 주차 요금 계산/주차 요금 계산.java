import java.util.*;
import java.time.*;
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
                
                String[] endT = time.split(":");
                String[] startT = parking.get(car).split(":");
                LocalTime end = LocalTime.of(Integer.parseInt(endT[0]), Integer.parseInt(endT[1]));
                LocalTime start = LocalTime.of(Integer.parseInt(startT[0]), Integer.parseInt(startT[1]));
                Duration duration = Duration.between(start, end);
                int diff = (int)duration.toMinutes();
                acc.put(car, acc.getOrDefault(car, 0) + diff);
                parking.remove(car);
                keySet.add(car);
            }
        }
        parking.forEach((k,v)-> {
            String[] startT = parking.get(k).split(":");
            LocalTime end = LocalTime.of(23, 59);
            LocalTime start = LocalTime.of(Integer.parseInt(startT[0]), Integer.parseInt(startT[1]));
            Duration duration = Duration.between(start, end);
        
            int diff = (int)duration.toMinutes();
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
}
// import java.time.Duration;
// import java.time.LocalDateTime;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Iterator;
// import java.time.format.DateTimeFormatter;
// class Solution {
//     public List<Integer> solution(int[] fees, String[] records) {
//         List<Integer> answer = new ArrayList<>();
//         String[] record = new String[3];
//         LocalDateTime date1;
//         LocalDateTime date2;
//         int acc = 0;
//         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
//         Map<String, String> map = new HashMap<>();
//         Map<String, Integer> total = new HashMap<>();
//         for(int i=0; i<records.length; i++){
//             record = records[i].split(" ");
//             System.out.println(records[i]);
//             System.out.println(record[2]);
//             if(record[2].equals("IN")){
//                 map.put(record[1], record[0]);
//                 System.out.println(map.get(record[1]));
//             }else if(record[2].equals("OUT")){
                
//                 date1 = LocalDateTime.parse(record[0], formatter);
//                 date2 = LocalDateTime.parse(map.get(record[1]), formatter);
//                 Duration diff = Duration.between(date1.toLocalTime(), date2.toLocalTime());
                
//                 acc = (int) diff.toMinutes();
//                 System.out.println(acc);
//                 // 기본시간 빼고 0보다 작으면 기본요금 반환
//                 if(acc - fees[0] < 0){
//                     total.put(record[1], total.get(record[1]) + fees[1]);
//                     continue;
//                 }else{
//                     // 아니면 단위 시간으로 나눠서 나머지 0보다 크면 나눈값 +1 해서 단위요금 곱해서 반환
//                     acc = acc - fees[0];
//                     total.put(record[1], acc % fees[2] > 0 ? total.get(record[1]) + fees[1] + (acc / fees[2]) * fees[3] : total.get(record[1]) + fees[1] + (acc / fees[2] + 1) * fees[3]);
//                     total.get(record[1]);
//                     continue;
//                 }
//             }
//         }
//         Iterator<String> keys = map.keySet().iterator();

//         if (!map.isEmpty()){
//             while( keys.hasNext() ){
//                 String key = keys.next();
//                 date1 = LocalDateTime.parse("23:59", formatter);
//                 date2 = LocalDateTime.parse(map.get(key), formatter);
                
//                 Duration diff = Duration.between(date1.toLocalTime(), date2.toLocalTime());
                
//                 acc = (int) diff.toMinutes();
                
//                  // 기본시간 빼고 0보다 작으면 기본요금 반환
//                 if(acc - fees[0] < 0){
                    
//                     total.put(key,total.get(key) + fees[1]);
                    
//                 }else{
//                     // 아니면 단위 시간으로 나눠서 나머지 0보다 크면 나눈값 +1 해서 단위요금 곱해서 반환
//                     acc = acc - fees[0];
//                     total.put(key, acc % fees[2] > 0 ? total.get(key) + fees[1] + (acc / fees[2]) * fees[3] : total.get(key) + fees[1] + (acc / fees[2] + 1) * fees[3]);
                    
//                 }
//             }
            
//         }
//         Iterator<String> keys2 = map.keySet().iterator();
//         while( keys2.hasNext() ){
//             String key = keys2.next();
//             answer.add(total.get(key));
//         }

//         return answer;
//     }
// }