package bootcamp;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class InchToInchesConverterTest {
    @Test
    public void shouldConvertSixInchesToSixInches() throws Exception {
        assertThat(new InchToInchesConverter().convert(6), is(new Measurement(6, Unit.INCH)));
    }

}