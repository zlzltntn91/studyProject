package programmers.stack_que;

import org.junit.Test;

import java.util.Arrays;

/**
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
 * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 */
public class Stock {
    public int[] solution(int[] prices) {
        int[] answer = {};
        return answer;
    }

    @Test
    public void solution() {
        int[] prices = {1, 2, 3, 2, 3}; // [4, 3, 1, 1, 0]
//        int[] prices = {5, 3, 2, 1}; // [4, 3, 1, 1, 0]
        int[] answers = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int answer = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    answer = j - i;
                } else {
                    break;
                }
            }
            answers[i] = answer == 0 ? 1 : answer;
        }
        answers[answers.length - 1] = 0;
        System.out.println(Arrays.toString(answers));


    }

    @Test
    public void solution2() {
        int[] prices = {1, 2, 3, 2, 3}; // [4, 3, 1, 1, 0]
        int[] answer = new int[prices.length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = i + 1; j < answer.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j - i;
                    break;
                }
                if (j == answer.length - 1) answer[i] = j - i;
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
