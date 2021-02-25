/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package callcontrol;

/**
 * The CallControl class controls a phone call, which can either be incoming or outgoing.
 * @author ahmed elhilali
 */
public class CallControl {

    /**
     * The CallState enum contains the states that the call will pass through.
     */
    protected enum CallState {
        IDLE, DIALING, ALERTING, CONNECTED, DISCONNECTED, RELEASED
    }

    private PhoneNumber localParty;
    private CallDataRecord callDataRecord;
    private CallState state;

    /**
     * The CallControl constructor take a phone number as a parameter and sets the state to idle.
     * @param localParty
     */
    public CallControl(PhoneNumber localParty) {
        this.localParty = localParty;
        state = CallState.IDLE;
    }

    /**
     * The dial method take a phone number that will be called (outgoing) as an argument.
     * It sets the state to DIALING giving that the state is IDLE.
     * It creates a new instance of the CallDataRecord using the localParty and the calledParty numbers as arguments.
     * @param calledParty is used for an outgoing call.
     * @return a callDataRecord
     */
    public CallDataRecord dial (PhoneNumber calledParty) {
        if (state == CallState.IDLE) {
            state = CallState.DIALING;
            callDataRecord = new CallDataRecord(localParty, calledParty);
        }
        return callDataRecord;
    }

    /**
     * The alert method take a phone number that will be calling (incoming) as an argument.
     * It sets the state to ALERTING giving that the state is IDLE.
     * It creates a new instance of the CallDataRecord using the callingParty and the localParty numbers as arguments.
     * @param callingParty is used for an incoming calling
     * @return a callDataRecord
     */
    public CallDataRecord alert (PhoneNumber callingParty) {
        if (state == CallState.IDLE) {
            state = CallState.ALERTING;
            callDataRecord = new CallDataRecord(callingParty, localParty);
        }
        return callDataRecord;
    }

    /**
     *
     * @return the callDataRecord
     */
    public CallDataRecord getCDR () {
        return callDataRecord;
    }

    /**
     * If the current state is DISCONNECTED, the connect method uses the establish method to start a connection.
     */
    public void connect () {
        if (state == CallState.ALERTING) {
            state = CallState.CONNECTED;
            callDataRecord.establish();
        }
    }

    /**
     * If the current state is CONNECTED, the disconnect method uses the disconnected method to stop the connection
     */
    public void disconnect () {
        if (state == CallState.CONNECTED) {
            state = CallState.DISCONNECTED;
            callDataRecord.disconnect();
        }
    }

    /**
     *
     * @return the current state
     */
    public CallState getState () {
        return state;
    }

    /**
     * The alert method alters the state to ALERTING if the giving state is DIALING.
     */
    public void alert () {
        if (state == CallState.DIALING) {
            state = CallState.ALERTING;
        }
    }

    /**
     * The release method alters the state to RELEASED if the giving state is not CONNECTED and is not RELEASED.
     */
    public void release () {
        if (state != CallState.CONNECTED && state != CallState.RELEASED) {
            state = CallState.RELEASED;
        }
    }
}