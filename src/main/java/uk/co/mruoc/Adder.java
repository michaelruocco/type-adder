package uk.co.mruoc;

import java.math.BigDecimal;
import java.util.List;


public class Adder {

    public BigDecimal add(List<Object> objects) {
        if (objects.isEmpty())
            return BigDecimal.ZERO;
        return BigDecimal.valueOf((int)objects.get(0));
    }

}
