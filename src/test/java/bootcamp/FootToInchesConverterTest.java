package bootcamp;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FootToInchesConverterTest {
    @Test
    public void shouldConvertSixFeetTo72Inches() throws Exception {
        assertThat(new FootToInchesConverter().convert(6), is(new Measurement(72, Unit.INCH)));
    }

}