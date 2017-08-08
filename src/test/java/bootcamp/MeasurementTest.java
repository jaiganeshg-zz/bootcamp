package bootcamp;

import org.junit.Test;

import java.util.InputMismatchException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by jaiganesh on 08/08/17.
 */
public class MeasurementTest {

    @Test
    public void shouldCompareEqualFootUnit() throws Exception {

        assertThat(new Measurement.MeasurementBuilder(5, Unit.FOOT).build(), is(new Measurement(5, Unit.FOOT, new FootToInchesConverter())));
    }

    @Test
    public void shouldCompareEqualInchUnit() throws Exception {
        assertThat(new Measurement(5, Unit.INCH), is(new Measurement(5, Unit.INCH)));
    }

    @Test
    public void shouldCompareNonEqualDifferentUnit() throws Exception {
        assertThat(new Measurement(5, Unit.FOOT, new FootToInchesConverter()), is(not(new Measurement(5, Unit.INCH))));
    }

    @Test
    public void shouldCompareEqualDifferentUnitFootToInches() throws Exception {
        assertThat(new Measurement(12, Unit.INCH), is(new Measurement(1, Unit.FOOT, new FootToInchesConverter()).convertToInches()));
    }

    @Test
    public void shouldCompareEqualDifferentUnitYardToInches() throws Exception {
        assertThat(new Measurement(36, Unit.INCH), is(new Measurement(1, Unit.YARD, new YardToInchesConverter()).convertToInches()));
    }

    @Test
    public void addTwoMeasurementsOfSameUnit() {
        assertThat(new Measurement(4, Unit.INCH), is(new Measurement(1, Unit.INCH).addMeasurement(new Measurement(3, Unit.INCH))));
        assertThat(new Measurement(24, Unit.INCH), is(new Measurement(1, Unit.FOOT, new FootToInchesConverter()).addMeasurement(new Measurement(1, Unit.FOOT, new FootToInchesConverter()))));
        assertThat(new Measurement(144, Unit.INCH), is(new Measurement(3, Unit.YARD, new YardToInchesConverter()).addMeasurement(new Measurement(1, Unit.YARD, new YardToInchesConverter()))));
    }

    @Test
    public void addYardToFoot() {
        Measurement measurementYard = new Measurement(1, Unit.YARD, new YardToInchesConverter());
        Measurement measurementFoot = new Measurement(2, Unit.FOOT, new FootToInchesConverter());
        assertThat(new Measurement(60, Unit.INCH), is(measurementFoot.addMeasurement(measurementYard)));
    }


    @Test
    public void addYardToInches() {
        assertThat(new Measurement(37, Unit.INCH), is(new Measurement(1, Unit.INCH).addMeasurement(new Measurement(1, Unit.YARD, new YardToInchesConverter()))));
    }

    @Test
    public void addFootToInches() {
        Measurement measurementFoot = new Measurement(1, Unit.FOOT, new FootToInchesConverter());
        Measurement measurementInch = new Measurement(1, Unit.INCH);

        assertThat(new Measurement(13, Unit.INCH), is(measurementInch.addMeasurement(measurementFoot)));
    }
}
