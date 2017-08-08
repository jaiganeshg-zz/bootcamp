package bootcamp;

import org.junit.Test;

import static bootcamp.Unit.FOOT;
import static bootcamp.Unit.INCH;
import static bootcamp.Unit.YARD;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by jaiganesh on 08/08/17.
 */
public class MeasurementTest {

    @Test
    public void shouldCompareEqualFootUnit() throws Exception {
        assertThat(new Measurement(5, FOOT), is(new Measurement(5, FOOT)));
    }

    @Test
    public void shouldCompareEqualInchUnit() throws Exception {
        assertThat(new Measurement(5, INCH), is(new Measurement(5, INCH)));
    }

    @Test
    public void shouldCompareNonEqualDifferentUnit() throws Exception {
        assertThat(new Measurement(5, FOOT), is(not(new Measurement(5, INCH))));
    }

    @Test
    public void shouldCompareEqualDifferentUnitFootToInches() throws Exception {
        assertThat(new Measurement(12, INCH), is(new Measurement(1, FOOT).convertToInches()));
    }

    @Test
    public void shouldCompareEqualDifferentUnitYardToInches() throws Exception {
        assertThat(new Measurement(36, INCH), is(new Measurement(1, YARD).convertToInches()));
    }

    @Test
    public void addTwoMeasurementsOfSameUnit() {
        assertThat(new Measurement(4, INCH), is(new Measurement(1, INCH).addMeasurement(new Measurement(3, INCH))));
        assertThat(new Measurement(24, INCH), is(new Measurement(1, FOOT).addMeasurement(new Measurement(1, FOOT))));
        assertThat(new Measurement(144, INCH), is(new Measurement(3, YARD).addMeasurement(new Measurement(1, YARD))));
    }

    @Test
    public void addYardToFoot() {
        Measurement measurementYard = new Measurement(1, YARD);
        Measurement measurementFoot = new Measurement(2, FOOT);
        assertThat(new Measurement(60, INCH), is(measurementFoot.addMeasurement(measurementYard)));
    }


    @Test
    public void addYardToInches() {
        assertThat(new Measurement(37, INCH), is(new Measurement(1, INCH).addMeasurement(new Measurement(1, YARD))));
    }

    @Test
    public void addFootToInches() {
        Measurement measurementFoot = new Measurement(1, FOOT);
        Measurement measurementInch = new Measurement(1, INCH);

        assertThat(new Measurement(13, INCH), is(measurementInch.addMeasurement(measurementFoot)));
    }
}
