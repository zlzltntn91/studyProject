package programmers.stack_que;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
public class Technic {
    @Test
    public void solution2() {
        int[] answer = {};

        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] progresses = {95, 90, 99, 99, 80, 99};

        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        log.info(Arrays.toString(Arrays.stream(dayOfend).toArray()));
        log.info(Arrays.toString(Arrays.stream(dayOfend).filter(i -> i!=0).toArray()));
    }

    @Test
    public void solution() {
        int[] speeds = {1, 1, 1};
        int[] progresses = {90, 90, 90};

//        int[] speeds = {1, 1, 1, 1, 1, 1};
//        int[] progresses = {95, 90, 99, 99, 80, 99};
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        /* 
        TODO: 2021-04-22
        1. progress가 몇일만에 100이 넘는지 계산
        2. 작업일 que 생성
        3. que를 조회하며 첫 작업진행일보다 낮은 진행일은 poll 한다.
        4. 뽑아둔 작업진행일의 개수를 answer에 담는다
         */

        for (int j = 0, progressesLength = progresses.length; j < progressesLength; j++) {
            int i = 0;
            int pro = progresses[j];
            while (true) {
                i++;
                pro += speeds[j];
                if (pro >= 100) {
                    queue.offer(i);
                    break;
                }
            }
            log.info("queue = {}", queue);
        }

        int targetDay = 0;
        int[] que = queue.stream().mapToInt(v -> v.intValue()).toArray();
        int day = 0;
        for (int i = 0; i < que.length; i++) {
            day = 1;
            targetDay = que[i];
            for (int j = i + 1; j < que.length; j++) {
                if(targetDay >= que[j]){
                    day++;
                    if(j == que.length-1) {
                        i = que.length;
                        break;
                    }
                }else{
                    i = j - 1;
                    break;
                }
            }
            answer.add(day);
        }

        answer.stream().mapToInt(v -> v.intValue()).toArray();
        log.info("answer = {}", answer);
    }


}
