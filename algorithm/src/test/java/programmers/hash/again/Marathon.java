package programmers.hash.again;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

public class Marathon {

    @Test
    public void t() {
        String[] participant = {"mislav", "stanko", "mislav", "ana", "ana", "ana", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        solution(participant, completion);
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : participant) {
        	map.put(s, map.getOrDefault(s, 0).intValue() + 1);
        }

        for (String s : completion) {
            map.computeIfPresent(s, (k, v) -> --v);
        }

        return map.entrySet().stream()
                .filter(v -> v.getValue().intValue() != 0)
                .map(v -> v.getKey())
                .collect(joining());
    }
}
