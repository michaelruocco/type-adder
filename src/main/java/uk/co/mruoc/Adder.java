package uk.co.mruoc;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;


public class Adder {

    public BigDecimal add(List<Object> objects) {
        BigDecimal result = BigDecimal.ZERO;

        if (objects.isEmpty())
            return result;

        for (Object object : objects)
            result = result.add(toBigDecimal(object));

        return result;
    }

    private BigDecimal toBigDecimal(Object object) {
        if (object == null)
            return BigDecimal.ZERO;

        if (object instanceof Number)
            return toBigDecimal((Number) object);

        if (object instanceof String)
            return toBigDecimal((String)object);

        return BigDecimal.ZERO;
    }

    private BigDecimal toBigDecimal(Number number) {
        return format(BigDecimal.valueOf(number.doubleValue()));
    }

    private BigDecimal toBigDecimal(String s) {
        if (NumberUtils.isNumber(s))
            return format(BigDecimal.valueOf(Double.parseDouble(s)));
        return BigDecimal.ZERO;
    }

    private BigDecimal format(BigDecimal d) {
        return d.stripTrailingZeros();
    }

}
