package uk.co.mruoc;

import java.math.BigDecimal;
import java.util.List;


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

        return toBigDecimal((double)object);
    }

    private BigDecimal toBigDecimal(int i) {
        return BigDecimal.valueOf(i);
    }

    private BigDecimal toBigDecimal(double d) {
        return BigDecimal.valueOf(d).stripTrailingZeros();
    }

}
