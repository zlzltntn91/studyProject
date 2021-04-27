package sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class BubbleSort {
    @Test
    public void name() {
        int[] arr = {4, 5, 1, 8, 7, 6, 9, 5, 2, 10};
        int i = 0;

        while (i < arr.length - 1) {
            i++;
        }
        log.debug("init : {}", Arrays.toString(arr));
        int from = 0;

        int e = 0;
        while (from < arr.length - 1) {
            log.info("----------------------회차 : {}", e);
            int lastChangeIdx = arr.length -1;
            for (int j = arr.length - 1; j > from; j--) {
                if (arr[j - 1] > arr[j]) {
                    log.info("바뀔 곳: {}, 지금 배열 : {}", lastChangeIdx, Arrays.toString(arr));
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    lastChangeIdx = j;
                    log.debug("변경 후  : {}", Arrays.toString(arr));
                }
            }
            // 마지막으로 업데이트된 t를 last변수에 넣음
            from = lastChangeIdx;
            e++;
        }
        log.debug("complete : {}", Arrays.toString(arr));
    }

    @Test
    public void name2() {
        int[] arr = {4, 5, 1, 8, 7, 6, 9, 5, 2, 10};
        int i = 0;

        while (i < arr.length - 1) {
            i++;
        }
        log.debug("init : {}", Arrays.toString(arr));
        int last = 0;
        int e = 0;
        while (last < arr.length - 1) {
            log.info("----------------------회차 : {}", e);
            int t = arr.length -1;
            for (int j = arr.length - 1; j > last; j--) {
                if (arr[j - 1] > arr[j]) {
                    log.info("바뀔 곳: {}, 지금 arr : {}", t, Arrays.toString(arr));
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    log.debug("변경 후  : {}", Arrays.toString(arr));
                }
            }
            // 마지막으로 업데이트된 t를 last변수에 넣음
            last++;
            e++;
        }
        log.debug("complete : {}", Arrays.toString(arr));
    }
}
