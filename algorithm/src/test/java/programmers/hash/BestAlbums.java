package programmers.hash;

import lombok.ToString;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class BestAlbums {

    @Test
    public void ifAbsentTest() {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop", "classic"};
        int[] plays = new int[]{500, 600, 150, 800, 2500, 1600};

        Map<String, List<Songs>> map = new HashMap<>();

        for (int i = 0, genresLength = genres.length; i < genresLength; i++) {

            Songs value = Songs.builder()
                    .plays(plays[i])
                    .idx(i)
                    .build();

            map.computeIfAbsent(genres[i], (v) -> new ArrayList<>()).add(value);
        }

        System.out.println(map);

        Map<String, List<Songs>> map2 = new HashMap<>();
        for (int i = 0, genresLength = genres.length; i < genresLength; i++) {

            Songs value = Songs.builder()
                    .plays(plays[i])
                    .idx(i)
                    .build();

            List<Songs> songs = map2.get(genres[i]);
            if (songs != null) {
                songs.add(value);
            } else {
                map2.put(genres[i], new ArrayList<>());
            }
        }

        System.out.println(map);
    }

    @Test
    public void name() {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public int[] solution(String[] genres, int[] plays) {

        Map<String, Map<String, Object>> map = new LinkedHashMap<>();
        Map<String, List<Songs>> map2 = new LinkedHashMap<>();

        for (int i = 0, genresLength = genres.length; i < genresLength; i++) {

            Songs value = Songs.builder()
                    .plays(plays[i])
                    .idx(i)
                    .build();

            ((List<Songs>) map.computeIfAbsent(genres[i], v -> new HashMap<>())
                    .computeIfAbsent("data", v -> new ArrayList<>())).add(value);

            map2.computeIfAbsent(genres[i], v -> new ArrayList<>()).add(value);


            Long totalCount = (Long) map.computeIfAbsent(genres[i], v -> new HashMap<>()).computeIfAbsent(
                    "totalListener", v -> 0L);
            map.get(genres[i]).put("totalListener", totalCount += value.getPlays());
        }

        List<String> ranks = map.entrySet().stream()
                .sorted(Comparator.comparingLong(
                        v -> (long) ((Map.Entry<String, Map<String, Object>>) v).getValue().get(
                                "totalListener")).reversed())
                .map(v -> v.getKey())
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for (String ranked : ranks) {
            List<Integer> tt = map2.get(ranked).stream()
                    .sorted(Comparator.comparingLong(v -> ((Songs) v).getPlays()).reversed())
                    .limit(2)
                    .map(v -> v.getIdx())
                    .collect(Collectors.toList());
            result.addAll(tt);
        }

        return result.stream().mapToInt(v -> v.intValue()).toArray();
    }

    @ToString
    static class Songs {
        int idx;
        long plays;

        public Songs(int idx, long plays) {
            this.idx = idx;
            this.plays = plays;
        }

        public static Builder builder() {
            return new Builder();
        }

        public int getIdx() {
            return idx;
        }

        public long getPlays() {
            return plays;
        }

        public static class Builder {
            int idx;
            long plays;

            public Builder plays(long val) {
                plays = val;
                return this;
            }

            public Builder idx(int val) {
                idx = val;
                return this;
            }

            public Songs build() {
                return new Songs(idx, plays);
            }
        }
    }
}

