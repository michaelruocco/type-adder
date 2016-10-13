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

        return BigDecimal.valueOf((int)object);
    }

}
