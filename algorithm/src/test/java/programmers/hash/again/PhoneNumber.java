package programmers.hash.again;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class PhoneNumber {
    @Test
    public void name() {
        String[] numbers = new String[]{"119", "119234", "56", "123", "78", "113", "112", "97674223"};
        for (String number : numbers) {
            Arrays.stream(numbers).collect(toList()).contains(number.startsWith(number));

        }
    }


}
