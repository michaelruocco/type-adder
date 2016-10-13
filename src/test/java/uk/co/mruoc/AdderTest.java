package uk.co.mruoc;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class AdderTest {

    private final Adder adder = new Adder();

    @Test
    public void shouldReturnZeroForEmptyList() {
        List<Object> objects = new ArrayList<>();

        BigDecimal result = adder.add(objects);

        assertThat(result).isEqualTo(BigDecimal.ZERO);
    }

}
