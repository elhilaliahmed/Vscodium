package callcontrol;

import static callcontrol.CallControl.CallState.ALERTING;
import static callcontrol.CallControl.CallState.CONNECTED;
import static callcontrol.CallControl.CallState.DIALING;
import static callcontrol.CallControl.CallState.DISCONNECTED;
import static callcontrol.CallControl.CallState.IDLE;
import static callcontrol.CallControl.CallState.RELEASED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class CallControlTest {
	PhoneNumber localParty = new PhoneNumber("+41", "31", "3812525");
	PhoneNumber otherParty = new PhoneNumber("+1", "981", "5443132");
	PhoneNumber someParty = new PhoneNumber("+44", "777", "1234567");

	@Test
	void testIDLE_outgoing() {
		CallControl call = new CallControl(localParty);
		assertEquals(IDLE, call.getState());
		call.alert();
		assertEquals(IDLE, call.getState());
		call.connect();
		assertEquals(IDLE, call.getState());
		call.disconnect();
		assertEquals(IDLE, call.getState());
		call.dial(otherParty);
		assertEquals(DIALING, call.getState());
		assertEquals(otherParty, call.getCDR().getCalledParty());
		assertEquals(localParty, call.getCDR().getCallingParty());
	}
	
	@Test
	void testIDLE_incoming() {
		CallControl call = new CallControl(localParty);
		call.alert(otherParty);
		assertEquals(ALERTING, call.getState());
		assertEquals(localParty, call.getCDR().getCalledParty());
		assertEquals(otherParty, call.getCDR().getCallingParty());
	}
	
	@Test
	void testIDLE_release() {
		CallControl call = new CallControl(localParty);
		call.release();
		assertEquals(RELEASED, call.getState());
	}
	
	@Test
	void testDIALING() {
		CallControl call = new CallControl(localParty);
		call.dial(otherParty);
		call.dial(someParty);
		assertEquals(DIALING, call.getState());
		call.alert(someParty);
		assertEquals(DIALING, call.getState());
		call.connect();
		assertEquals(DIALING, call.getState());
		call.disconnect();
		assertEquals(DIALING, call.getState());
		call.alert();
		assertEquals(ALERTING, call.getState());
		assertEquals(otherParty, call.getCDR().getCalledParty());
		assertEquals(localParty, call.getCDR().getCallingParty());
	}

	@Test
	void testDIALING_release() {
		CallControl call = new CallControl(localParty);
		call.dial(otherParty);
		call.release();
		assertEquals(RELEASED, call.getState());		
	}
	
	@Test
	void testALERTING() {
		CallControl call = new CallControl(localParty);
		call.alert(otherParty);
		call.dial(someParty);
		assertEquals(ALERTING, call.getState());
		call.alert();
		assertEquals(ALERTING, call.getState());
		call.alert(someParty);
		assertEquals(ALERTING, call.getState());
		call.disconnect();
		assertEquals(ALERTING, call.getState());
		call.connect();
		assertEquals(CONNECTED, call.getState());
		assertEquals(localParty, call.getCDR().getCalledParty());
		assertEquals(otherParty, call.getCDR().getCallingParty());
		assertEquals(0, Duration.between(LocalDateTime.now(), call.getCDR().getStartTime()).abs().getSeconds(), 0.1);
		assertNull(call.getCDR().getEndTime());
	}

	@Test
	void testALERTING_release() {
		CallControl call = new CallControl(localParty);
		call.alert(otherParty);
		call.release();
		assertEquals(RELEASED, call.getState());		
	}
	
	@Test
	void testCONNECTED() {
		CallControl call = new CallControl(localParty);
		call.alert(otherParty);
		call.connect();
		LocalDateTime startTime = call.getCDR().getStartTime();
		call.dial(someParty);
		assertEquals(CONNECTED, call.getState());
		call.alert(someParty);
		assertEquals(CONNECTED, call.getState());
		call.alert();
		assertEquals(CONNECTED, call.getState());
		call.connect();
		assertEquals(CONNECTED, call.getState());
		assertEquals(startTime, call.getCDR().getStartTime());
		call.release();
		assertEquals(CONNECTED, call.getState());
		call.disconnect();
		assertEquals(DISCONNECTED, call.getState());
		assertEquals(localParty, call.getCDR().getCalledParty());
		assertEquals(otherParty, call.getCDR().getCallingParty());
		assertEquals(0, Duration.between(LocalDateTime.now(), call.getCDR().getEndTime()).abs().getSeconds(), 0.1);
	}
	
	@Test
	void testDISCONNECTED() {
		CallControl call = new CallControl(localParty);
		call.alert(otherParty);
		call.connect();
		call.disconnect();
		LocalDateTime endTime = call .getCDR().getEndTime();
		call.dial(someParty);
		assertEquals(DISCONNECTED, call.getState());
		call.alert(someParty);
		assertEquals(DISCONNECTED, call.getState());
		call.alert();
		assertEquals(DISCONNECTED, call.getState());
		call.connect();
		assertEquals(DISCONNECTED, call.getState());
		call.disconnect();
		assertEquals(DISCONNECTED, call.getState());
		assertEquals(endTime, call.getCDR().getEndTime());
		call.release();
		assertEquals(RELEASED, call.getState());
		assertEquals(localParty, call.getCDR().getCalledParty());
		assertEquals(otherParty, call.getCDR().getCallingParty());
	}

}
