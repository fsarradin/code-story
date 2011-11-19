package fs.frs.codestory.foobarqix;

import fr.frs.codestory.foobarqix.FooBarQix;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class FooBarQixTest {

    @Test
    public void should_return_1_when_1() {
        assertThat(FooBarQix.toFooBarQix(1)).isEqualTo("1");
    }

    @Test
    public void should_return_2_when_2() {
        assertThat(FooBarQix.toFooBarQix(2)).isEqualTo("2");
    }

    @Test
    public void should_return_Foo_when_6() {
        assertThat(FooBarQix.toFooBarQix(6)).isEqualTo("Foo");
    }

    @Test
    public void should_return_Bar_when_10() {
        assertThat(FooBarQix.toFooBarQix(10)).isEqualTo("Bar");
    }

    @Test
    public void should_return_FooBarQix_when_210() {
        assertThat(FooBarQix.toFooBarQix(210)).isEqualTo("FooBarQix");
    }

    @Test
    public void should_return_Foo_when_13() {
        assertThat(FooBarQix.toFooBarQix(13)).isEqualTo("Foo");
    }

    @Test
    public void should_return_FooBarBar_when_15() {
        assertThat(FooBarQix.toFooBarQix(15)).isEqualTo("FooBarBar");
    }

    @Test
    public void should_return_FooBarBar_when_33() {
        assertThat(FooBarQix.toFooBarQix(33)).isEqualTo("FooFooFoo");
    }

    @Test
    public void should_return_FooBarQixBar_when_105() {
        assertThat(FooBarQix.toFooBarQix(105)).isEqualTo("FooBarQixBar");
    }

}
