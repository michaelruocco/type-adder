package uk.co.mruoc;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.Test;


public class AdderTest {

    private final Adder adder = new Adder();

    @Test
    public void shouldReturnZeroForEmptyList() {
        BigDecimal result = adder.add(Collections.emptyList());

        assertThat(result).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void shouldReturnValueOfSingleIntegerAsBigDecimal() {
        BigDecimal result = adder.add(10);

        assertThat(result).isEqualTo(BigDecimal.TEN);
    }

    @Test
    public void shouldReturnSumOfMultipleIntegersAsBigDecimal() {
        BigDecimal result = adder.add(10, 5, 15);

        assertThat(result).isEqualTo(BigDecimal.valueOf(30));
    }

    @Test
    public void shouldHandleNullAndTreatItAsZero() {
        BigDecimal result = adder.add(10, null, 15);

        assertThat(result).isEqualTo(BigDecimal.valueOf(25));
    }

    @Test
    public void shouldHandleDoubles() {
        BigDecimal result = adder.add(10, null, 15d);

        assertThat(result).isEqualTo(BigDecimal.valueOf(25));
    }

    @Test
    public void shouldHandleNumericStrings() {
        BigDecimal result = adder.add(10, null, 15d, "15");

        assertThat(result).isEqualTo(BigDecimal.valueOf(40));
    }

    @Test
    public void shouldHandleNonNumericStringAndTreatItAsZero() {
        BigDecimal result = adder.add(10, null, 15d, "test");

        assertThat(result).isEqualTo(BigDecimal.valueOf(25));
    }

    @Test
    public void shouldHandleBigDecimals() {
        BigDecimal result = adder.add(10, null, 15d, "15", BigDecimal.TEN);

        assertThat(result).isEqualTo(BigDecimal.valueOf(50));
    }

    @Test
    public void shouldHandleUnexpectedObjectsAndTreatThemAsZero() {
        BigDecimal result = adder.add(10, null, 15d, "15", new Object(), new Exception());

        assertThat(result).isEqualTo(BigDecimal.valueOf(40));
    }

}
