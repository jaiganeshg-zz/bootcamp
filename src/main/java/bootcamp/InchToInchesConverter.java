package bootcamp;

/**
 * Created by jaiganesh on 08/08/17.
 */
public class InchToInchesConverter implements InchConverter {
        public Measurement convert(int length) {
            return new Measurement(length, Unit.INCH);
        }
}
