package programmers.stack_que;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
 * 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
 * <p>
 * ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
 * <p>
 * 예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있을때
 * 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
 */
@Slf4j
public class Truck {

    @Test
    public void solution() {
//        8초
//        int bridge_length = 100;
//        int totalWeight = 100;
//        int[] truck_weights = {10};
        int bridge_length = 2;
        int totalWeight = 10;
        int[] truck_weights = {7, 4, 5, 6};

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        return answer;
    }
}
