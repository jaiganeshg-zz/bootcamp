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
        assertThat(new Measurement(5, Unit.FOOT), is(new Measurement(5, Unit.FOOT)));
    }
    @Test
    public void shouldCompareEqualInchUnit() throws Exception {
        assertThat(new Measurement(5, Unit.INCH), is(new Measurement(5, Unit.INCH)));
    }
    @Test
    public void shouldCompareNonEqualDifferentUnit() throws Exception {
        assertThat(new Measurement(5, Unit.FOOT), is(not(new Measurement(5, Unit.INCH))));
    }
    @Test
    public void shouldCompareEqualDifferentUnitFootToInches() throws Exception {
        assertThat(new Measurement(12, Unit.INCH), is(new Measurement(1, Unit.FOOT).convertToInches()));
    }
    @Test
    public void shouldCompareEqualDifferentUnitYardToInches() throws Exception {
        assertThat(new Measurement(36, Unit.INCH), is(new Measurement(1, Unit.YARD).convertToInches()));
    }

    @Test
    public void shouldCompareEqualDifferentUnitYardToFoot() throws Exception {
        assertThat(new Measurement(3, Unit.FOOT), is(new Measurement(1, Unit.YARD).convertToFoot()));
    }

    @Test(expected = InputMismatchException.class)
    public void shouldThrowExceptionIfConvertToSameUnitIsCalled1() throws Exception {
        new Measurement(1, Unit.INCH).convertToInches();
    }

    @Test(expected = InputMismatchException.class)
    public void shouldThrowExceptionIfConvertToSameUnitIsCalled2() throws Exception {
        Measurement measurement = new Measurement(0, Unit.FOOT);
        new Measurement(1, Unit.FOOT).convertToFoot();
    }

    @Test(expected = InputMismatchException.class)
    public void shouldThrowExceptionIfConvertToUpperUnitIsCalled2() throws Exception {
        Measurement measurement = new Measurement(0, Unit.FOOT);
        new Measurement(1, Unit.INCH).convertToFoot();
    }

    @Test
    public void addTwoMeasurementsOfSameUnit() {
        assertThat(new Measurement(4, Unit.INCH), is(new Measurement(1, Unit.INCH).addMeasurement(new Measurement(3, Unit.INCH))));
        assertThat(new Measurement(2, Unit.FOOT), is(new Measurement(1, Unit.FOOT).addMeasurement(new Measurement(1, Unit.FOOT))));
        assertThat(new Measurement(4, Unit.YARD), is(new Measurement(3, Unit.YARD).addMeasurement(new Measurement(1, Unit.YARD))));
    }

    @Test
    public void addYardToFoot() {
        Measurement measurementYard = new Measurement(1, Unit.YARD);
        Measurement measurementFoot = new Measurement(2, Unit.FOOT);
        measurementFoot.addMeasurement(measurementYard);
        assertThat(new Measurement(5, Unit.FOOT), is(measurementFoot));
    }


    @Test
    public void addYardToInches() {
        Measurement measurementYard = new Measurement(1, Unit.YARD);
        Measurement measurementInch = new Measurement(1, Unit.INCH);
        measurementInch.addMeasurement(measurementYard);
        assertThat(new Measurement(37, Unit.INCH), is(measurementInch));
    }

    @Test
    public void addFootToInches() {
        Measurement measurementFoot = new Measurement(1, Unit.FOOT);
        Measurement measurementInch = new Measurement(1, Unit.INCH);
        measurementInch.addMeasurement(measurementFoot);
        assertThat(new Measurement(13, Unit.INCH), is(measurementInch));
    }

    @Test(expected = InputMismatchException.class)
    public void shouldThrowExceptionIfAddInchToFootCalled() throws Exception {
        Measurement measurement = new Measurement(0, Unit.FOOT);
        new Measurement(1, Unit.INCH).convertToFoot();
    }



//    @Test
//    public void addTwoMeasurements() {
//        assertThat(new Measurement(4, Unit.INCH), is(new Measurement(1, Unit.INCH).addMeasurement(new Measurement(3, Unit.INCH))));
//    }
}
