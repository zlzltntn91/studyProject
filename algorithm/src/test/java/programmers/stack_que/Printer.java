package programmers.stack_que;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Printer {
    @Test
    public void name() {
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;

        Queue<Map<String, Integer>> que = new LinkedList<>();

        List<Map<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int priority = priorities[i];
            map.put("num", priority);
            map.put("idx", i);
            list.add(map);
        }

        for (int i = 0; i < list.size(); ) {

            Map<String, Integer> job = list.get(i);
            Map<String, Integer> importantJob = list.stream().max(Comparator.comparingInt(v -> v.get("num"))).get();

            if(job.get("num") < importantJob.get("num")){
                list.remove(job);
                list.add(job);
            }else if (job.get("num") == importantJob.get("num")){
                que.offer(job);
                list.remove(job);
            }else{
                break;
            }
//            log.info("priority, max = {}, {}", job, importantJob);
            log.info(list.toString());
        }
        log.info("que = {}", que);


        int idx = 0;
        Iterator<Map<String, Integer>> iter = que.iterator();
        while (iter.hasNext()) {
            if(iter.next().get("idx") == location){
                break;
            }
            idx++;
        }
        log.info("idx = {}", idx + 1);
    }

    @Test
    public void fail() {
        int[] priorities = {2, 1, 3, 2};
        int location = 1;
        int answer = 123;
        int flag = priorities.length / 2;
        List<Map<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int priority = priorities[i];
            if (i < flag) {
                map.put(priority, i * -1);
            } else {
                map.put(priority, i);
            }
            list.add(map);
        }
        log.info("list = {}", list);


        List<Map<Integer, Integer>> tt = list.stream()
                .flatMap(v -> v.entrySet().stream())
                .sorted(Comparator.comparingInt(v -> (int) ((Map.Entry) v).getValue()).reversed())
                .sorted(Comparator.comparingInt(v -> (int) ((Map.Entry) v).getKey()).reversed())
                .map(v -> {
                    Map<Integer, Integer> t = new HashMap<>();
                    t.put(v.getKey(), v.getValue());
                    return t;
                })
                .collect(Collectors.toList());


        log.info("list = {}", tt);

        for (int i = 0; i < tt.size(); i++) {
            log.info(tt.get(i).toString());
            if (tt.get(i).containsValue(location < flag ? location * -1 : location)) {
                answer = i;
            }
        }
        log.info("answer = {}", answer);
    }
}
