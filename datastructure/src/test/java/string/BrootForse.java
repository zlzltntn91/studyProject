package string;

import org.junit.Test;

public class BrootForse {
    @Test
    public void name() {
        String target = "pspsㄲㄴㄷpspssssps54ps5ps4cd";
        String pattern = "ㄲㄴㄷ";
        int ti = 0;
        int pi = 0;
        
        while (ti != target.length() && pi != pattern.length()) {
            if (target.charAt(ti) == pattern.charAt(pi)) {
                ti++;
                pi++;
            } else {
                ti = ti - pi + 1;
                pi = 0;
            }
        }

        if (pi == pattern.length()) {
            String prefix = target.substring(0, ti - pi);
            String text = target.substring(ti - pi, ti);
            String suffpix = target.substring(ti);
            System.out.printf("found !! // %s%s%s%s%s", prefix, "\'", text, "\'", suffpix);
            System.out.println();
        } else {
            ti = -1;
            System.out.println("not found !!");
        }

        System.out.println(ti);

    }
}
