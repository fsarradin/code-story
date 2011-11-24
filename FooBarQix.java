
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import java.util.*;
import java.util.functions.*;

public class FooBarQix {
	private static NavigableMap<Integer, String> FILTERS = new TreeMap<Integer, String>() {{
		put(3, "Foo");
		put(5, "Bar");
		put(7, "Qix");
	}};
	
	private static Mapper<Integer, Mapper<Integer, Optional<String>>> FOOBARQIX_FROM_DIVISIBILITY
		= divisor -> value -> {
			if (value % divisor != 0) return Optional.<String>absent();
			else return Optional.of(String.valueOf(FILTERS.get(divisor)));
		};
	
	private static Iterable<Mapper<Integer, Optional<String>>> FOOBARQIX_FROM_DIVISIBILITIES
		= FILTERS.navigableKeySet().map(FOOBARQIX_FROM_DIVISIBILITY);

	private static Operator<Optional<String>> OPTIONAL_STRING_REDUCER
		= (r1, r2) -> {
			if (!r1.isPresent()) return r2;
			else if (!r2.isPresent()) return r1;
			else return Optional.of(r1.get() + r2.get());
		};

	private static <K, V> Optional<V> getFrom(Map<K, V> map, K key) {
		if (!map.containsKey(key)) return Optional.absent();
		else return Optional.of(map.get(key));
	}

	private static Mapper<Character, Optional<String>> FOOBARQIX_FROM_DIGIT
		= c -> getFrom(FILTERS, Character.digit(c, 10));

	private static Mapper<Integer, String> toFooBarQix = value -> {
		String stringOfValue = String.valueOf(value);

		Iterable<Optional<String>> rule1Results = FOOBARQIX_FROM_DIVISIBILITIES.map(f -> (Optional<String>) (f.map(value)));
		Optional<String> result1 = rule1Results.reduce(Optional.<String>absent(), OPTIONAL_STRING_REDUCER);

		Iterable<Optional<String>> rule2Results = Arrays.iterable(toCharacterArray(stringOfValue)).map(FOOBARQIX_FROM_DIGIT);
		Optional<String> result2 = rule2Results.reduce(result1, OPTIONAL_STRING_REDUCER);

		return (String) (result2.or(String.valueOf(stringOfValue)));
	};

	private static Character[] toCharacterArray(String st) {
		Character[] result = new Character[st.length()];
		for (int i = 0; i < st.length(); i++) {
			result[i] = Character.valueOf(st.charAt(i));
		}
		return result;
	}

	public static void main(String... args) {
		for (int n = 1; n <= 100; n++) {
			System.out.println(toFooBarQix.map(n));
		}
	}
}

