package callcontrol;

import java.time.LocalDateTime;

/**
 * The CallDataRecord is used to collect the billing data of a phone call.
 * The class contains the numbers of the calling- and called-party, and a timestamp for the time when the connection has been established and another one for when the connection is disconnected.
 * @author ahmed elhilali
 */
public class CallDataRecord {
    private PhoneNumber callingParty;
    private PhoneNumber calledParty;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean connectionSwitchedOn;

    /**
     * The CallDataRecord constructor takes two arguments, a calling- and called-party.
     * @param callingParty phone number
     * @param calledParty phone number
     */
    public CallDataRecord (PhoneNumber callingParty, PhoneNumber calledParty) {
        this.callingParty = callingParty;
        this.calledParty = calledParty;
    }

    /**
     *
     * @return calling party number.
     */
    public PhoneNumber getCallingParty () {
        return callingParty;
    }

    /**
     *
     * @return return the called party number.
     */
    public PhoneNumber getCalledParty () {
        return calledParty;
    }

    /**
     *
     * @return the time of when the connection got established.
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     *
     * @return the time of when the connection got disconnected.
     */
    public LocalDateTime getEndTime () {
        return endTime;
    }

    /**
     * The establish method sets set the startTime giving that the connectionSwitchedOn is false.
     */
    public void establish () {
        if (connectionSwitchedOn) {
            return;
        }
        connectionSwitchedOn = true;
        startTime = LocalDateTime.now ();
    }

    /**
     * The disconnect method sets the endTime giving that the connectionSwitchedOn is true.
     */
    public void disconnect () {
        if (!connectionSwitchedOn) {
            return;
        }
        connectionSwitchedOn = false;
        endTime = LocalDateTime.now ();
    }

    /**
     * The toString method returns a string representation of the record depending on the CallDataRecord state.
     * @return a string
     */
    @Override
    public String toString () {
        String callingCalled = "calling: " + callingParty + ", called: " + calledParty;
        String callingCalledStart = callingCalled + ", start: " + startTime;

        if (startTime == null) {
            return callingCalled + ", start: not yet established";
        }
        if (endTime == null) {
            return callingCalledStart + ", end: still established";
        }
        return callingCalledStart + ", end: " + endTime;
    }
}
