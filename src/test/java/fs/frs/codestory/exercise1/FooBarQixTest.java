package fs.frs.codestory.exercise1;

import fr.frs.codestory.exercise1.FooBarQix;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class FooBarQixTest {

    @Test
    public void should_return_1_when_1() {
        assertThat(FooBarQix.TO_FOO_BAR_QIX.apply(1)).isEqualTo("1");
    }

    @Test
    public void should_return_2_when_2() {
        assertThat(FooBarQix.TO_FOO_BAR_QIX.apply(2)).isEqualTo("2");
    }

    @Test
    public void should_return_Foo_when_6() {
        assertThat(FooBarQix.TO_FOO_BAR_QIX.apply(6)).isEqualTo("Foo");
    }

    @Test
    public void should_return_Bar_when_10() {
        assertThat(FooBarQix.TO_FOO_BAR_QIX.apply(10)).isEqualTo("Bar");
    }

    // outside scope
    @Test
    public void should_return_FooBarQix_when_210() {
        assertThat(FooBarQix.TO_FOO_BAR_QIX.apply(210)).isEqualTo("FooBarQix");
    }

    @Test
    public void should_return_Foo_when_13() {
        assertThat(FooBarQix.TO_FOO_BAR_QIX.apply(13)).isEqualTo("Foo");
    }

    @Test
    public void should_return_FooBarBar_when_15() {
        assertThat(FooBarQix.TO_FOO_BAR_QIX.apply(15)).isEqualTo("FooBarBar");
    }

    @Test
    public void should_return_FooBarBar_when_33() {
        assertThat(FooBarQix.TO_FOO_BAR_QIX.apply(33)).isEqualTo("FooFooFoo");
    }

    // outside scope
    @Test
    public void should_return_FooBarQixBar_when_105() {
        assertThat(FooBarQix.TO_FOO_BAR_QIX.apply(105)).isEqualTo("FooBarQixBar");
    }

}
