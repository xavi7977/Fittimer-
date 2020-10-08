

package eu.xavi797.fx.timer;

public class TimerEvent {
    public enum Type {
        STARTED, STOPPED, CONTINUED, FINISHED, RESET, WAITING, SECOND
    }

    private final Timer timer;
    private final Type  type;


    // ******************** Constructor ***************************************
    public TimerEvent(final Timer TIMER, final Type TYPE) {
        timer = TIMER;
        type  = TYPE;
    }


    // ******************** Methods *******************************************
    public Timer getTimer() { return timer; }

    public Type getType() { return type; }
}
