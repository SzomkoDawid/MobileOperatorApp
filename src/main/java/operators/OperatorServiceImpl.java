package operators;

import operators.OperatorService;

import java.util.concurrent.ThreadLocalRandom;

public class OperatorServiceImpl implements OperatorService {

    public long orange() {
        return ThreadLocalRandom.current().nextLong(500000000, 599999999);
    }

    public long plus() {
        return ThreadLocalRandom.current().nextLong(600000000, 699999999);
    }

    public long tMobile() {
        return ThreadLocalRandom.current().nextLong(700000000, 799999999);
    }

    public long play() {
        return ThreadLocalRandom.current().nextLong(800000000, 899999999);
    }
}
