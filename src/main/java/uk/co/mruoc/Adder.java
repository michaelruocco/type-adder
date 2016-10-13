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

        if (object instanceof Integer)
            return toBigDecimal((int) object);

        if (object instanceof Double)
            return toBigDecimal((double)object);

        return toBigDecimal(object.toString());
    }

    private BigDecimal toBigDecimal(int i) {
        return format(BigDecimal.valueOf(i));
    }

    private BigDecimal toBigDecimal(double d) {
        return format(BigDecimal.valueOf(d).stripTrailingZeros());
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
