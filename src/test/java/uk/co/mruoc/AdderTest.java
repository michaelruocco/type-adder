package uk.co.mruoc;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;


public class AdderTest {

    private final Adder adder = new Adder();

    @Test
    public void shouldReturnZeroForEmptyList() {
        List<Object> objects = Collections.emptyList();

        BigDecimal result = adder.add(objects);

        assertThat(result).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void shouldReturnValueOfSingleIntegerAsBigDecimal() {
        List<Object> objects = Arrays.asList(10);

        BigDecimal result = adder.add(objects);

        assertThat(result).isEqualTo(BigDecimal.TEN);
    }

    @Test
    public void shouldReturnValueOfMultipleIntegersAsBigDecimal() {
        List<Object> objects = Arrays.asList(10, 5, 15);

        BigDecimal result = adder.add(objects);

        assertThat(result).isEqualTo(BigDecimal.valueOf(30));
    }

    @Test
    public void shouldHandleNullAndTreatItAsZero() {
        List<Object> objects = Arrays.asList(10, null, 15);

        BigDecimal result = adder.add(objects);

        assertThat(result).isEqualTo(BigDecimal.valueOf(25));
    }

}
