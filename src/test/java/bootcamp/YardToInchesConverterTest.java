package bootcamp;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class YardToInchesConverterTest {
    @Test
    public void shouldConvertOneYardTo36Inches() throws Exception {
        assertThat(new YardToInchesConverter().convert(1), is(new Measurement(36, Unit.INCH)));
    }

}