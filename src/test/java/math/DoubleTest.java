package math;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Slf4j
public class DoubleTest {

  @Test
  @Ignore
  public void ceilTest () {
    BigDecimal bd = BigDecimal.valueOf(Math.ceil(7.2345 * 10) * 0.1);
    DecimalFormat df = new DecimalFormat();
    df.applyLocalizedPattern("0.00");
    log.debug("DecimalFormat : {}", df.format(bd));
    log.debug("BigDecimal : {}", bd.stripTrailingZeros());
    log.debug("result : {}", Math.ceil(7.2345 * 10) * 0.1);
    log.debug("parse int : {}", (int) Math.ceil(7.2345));
  }
}
