package bohdanmayorchak.test_yurii.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionUtils {
    private CollectionUtils() {
        throw new UnsupportedOperationException();
    }

    public static  <T, K> List<T> mapToList(List<K> ls, Function<K, T> mapper) {
        return ls.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
