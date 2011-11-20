package fr.frs.codestory.exercise1;

import com.google.common.base.Optional;

import java.util.Map;

public class Maps2 {

    /**
     *
     * @param map
     * @param key
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Optional<V> getFrom(Map<K, V> map, K key) {
        if (!map.containsKey(key)) return Optional.absent();
        return Optional.of(map.get(key));
    }

}
