public class ThreeDimensionalExceptions {

    public class RulesException extends Exception {
        public RulesException () { super(); }
        public RulesException (String message) { super(message); }
        public RulesException (String message, Throwable cause) { super(message, cause); }
        public RulesException (Throwable cause) { super(cause); }
        public RulesException (String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    } //TODO DEFAULT MESSAGE

    public class BoardException extends Exception {
        public BoardException () { super(); }
        public BoardException (String message) { super(message); }
        public BoardException (String message, Throwable cause) { super(message, cause); }
        public BoardException (Throwable cause) { super(cause); }
        public BoardException (String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

    public class CoordinateException extends BoardException { //DONE
        public CoordinateException () { this(""); }
        public CoordinateException (String message) { super("Coordinate Exception: " + message); }
        public CoordinateException (String message, Throwable cause) { super("Coordinate Exception: " + message, cause); }
        public CoordinateException (Throwable cause) { this("", cause); }
        public CoordinateException (String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    } //DONE

    public class CoordinateOutOfBoundsException extends CoordinateException { //DONE
        public CoordinateOutOfBoundsException () { this(""); }
        public CoordinateOutOfBoundsException (String message) { super("Position Out of Bounds: " + message); }
        public CoordinateOutOfBoundsException (String message, Throwable cause) { super("Position Out of Bounds: " + message, cause); }
        public CoordinateOutOfBoundsException (Throwable cause) { this("", cause); }
        public CoordinateOutOfBoundsException (String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    } //DONE

    public class MovementRulesException extends RulesException {
        public MovementRulesException() { super(); }
        public MovementRulesException(String message) { super(message); }
        public MovementRulesException(String message, Throwable cause) { super(message, cause); }
        public MovementRulesException(Throwable cause) { super(cause); }
        public MovementRulesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    } //TODO DEFAULT MESSAGE

    public class MovementOutOfBoundsException extends CoordinateOutOfBoundsException { //DONE
        public MovementOutOfBoundsException () { this(""); }
        public MovementOutOfBoundsException (String message) { super("Move Out of Bounds: " + message); }
        public MovementOutOfBoundsException (String message, Throwable cause) { super("Move Out of Bounds: " + message, new Throwable(cause)); }
        public MovementOutOfBoundsException (Throwable cause) { this("", cause); }
        public MovementOutOfBoundsException (String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    } //DONE

    public class MovementExceedsMaximum extends MovementOutOfBoundsException { //DONE
        public MovementExceedsMaximum () { this(""); }
        public MovementExceedsMaximum (String message) { super("Position Exceeds Maximum: " + message); }
        public MovementExceedsMaximum (String message, Throwable cause) { super("Position Exceeds Maximum: " + message, cause); }
        public MovementExceedsMaximum (Throwable cause) { this("Position Exceeds Maximum: ", cause); }
    } //DONE

    public class MovementExceedsMinimum extends MovementOutOfBoundsException { //DONE
        public MovementExceedsMinimum () { this(""); }
        public MovementExceedsMinimum (String message) { super("Position Exceeds Minimum: " + message); }
        public MovementExceedsMinimum (String message, Throwable cause) { super("Position Exceeds Minimum: " + message, cause); }
        public MovementExceedsMinimum (Throwable cause) { this("Position Exceeds Minimum: ", cause); }
    } //DONE

}
