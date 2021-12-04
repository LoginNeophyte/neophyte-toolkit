package fluent;

import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/**
 * Created on 22.11.2021 by
 *
 * @author alexandrov
 */
public class TernaryOp<V> extends Cascade<TernaryOp<V>, V> {

    TernaryOp(boolean actionAllowed, TernaryOp<V> origin) {
        super(actionAllowed, origin, null, TernaryOp::new);
    }

    TernaryOp(boolean actionAllowed) {
        this(actionAllowed, null);
    }

    public TernaryOp<V> yes(V value) {
        return swapWhen(actionAllowed, rebox(value));
    }

    public TernaryOp<V> yes(Supplier<V> value) {
        return swapWhen(actionAllowed, rebox(value.get()));
    }

    public TernaryOp<V> yesThenAsk(boolean condition) {
        return expandSelf(actionAllowed, condition);
    }

    public TernaryOp<V> yesThenAsk(BooleanSupplier condition) {
        return expandSelf(actionAllowed, condition.getAsBoolean());
    }

    public TernaryOp<V> yesThenBreak(V value) {
        return thenBlock(actionAllowed, value);
    }

    public TernaryOp<V> yesThenBreak(Supplier<V> value) {
        return thenBlock(actionAllowed, value.get());
    }

    public V yesThenYield(V value) {
        return thenUnbox(actionAllowed, value);
    }

    public V yesThenYield(Supplier<V> value) {
        return thenUnbox(actionAllowed, value.get());
    }

    public Optional<V> yesThenOptional(V value) {
        return thenOptional(actionAllowed, value);
    }

    public Optional<V> yesThenOptional(Supplier<V> value) {
        return thenOptional(actionAllowed, value.get());
    }

    public V no(V value) {
        return thenUnbox(!actionAllowed, value);
    }

    public V no(Supplier<V> value) {
        return thenUnbox(!actionAllowed, value.get());
    }

    public TernaryOp<V> noThenAsk(boolean condition) {
        return expandSelf(!actionAllowed, condition);
    }

    public TernaryOp<V> noThenAsk(BooleanSupplier condition) {
        return expandSelf(!actionAllowed, condition.getAsBoolean());
    }

    public TernaryOp<V> noThenBlock(V value) {
        return thenBlock(!actionAllowed, value);
    }

    public TernaryOp<V> noThenBlock(Supplier<V> value) {
        return thenBlock(!actionAllowed, value.get());
    }

    public Optional<V> noThenOptional(V value) {
        return thenOptional(!actionAllowed, value);
    }

    public Optional<V> noThenOptional(Supplier<V> value) {
        return thenOptional(!actionAllowed, value.get());
    }

}
