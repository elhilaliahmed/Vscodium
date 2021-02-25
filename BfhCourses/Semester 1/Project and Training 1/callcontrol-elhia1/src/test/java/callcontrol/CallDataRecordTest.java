package callcontrol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CallDataRecordTest {
	private static final String TIMESTAMP_PATTERN = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+){0,1}";

	private CallDataRecord cdr;
	private PhoneNumber calling = new PhoneNumber("+44", "044", "7258912");
	private PhoneNumber called  = new PhoneNumber("001", "982", "5431201");
	
	@BeforeEach
	void setup() {
		cdr = new CallDataRecord(calling, called);
	}
	
	@Test
	void testCallDataRecord() {
		System.out.println(cdr.toString());
		assertTrue(cdr.toString().matches("calling: \\+44 44\\/725 8912, called: \\+1 982\\/543 1201, start: not yet established"));
		assertNull(cdr.getStartTime());
		assertNull(cdr.getEndTime());
	}

	@Test
	void test() throws InterruptedException {
		cdr.establish();
		System.out.println(cdr.toString());
		assertTrue(cdr.toString().matches("calling: \\+44 44\\/725 8912, called: \\+1 982\\/543 1201, start: " + TIMESTAMP_PATTERN + ", end: still established"));
		assertEquals(0.0, Duration.between(cdr.getStartTime(), LocalDateTime.now()).getSeconds(), 0.1);
		assertNull(cdr.getEndTime());
		Thread.sleep(1000);
		cdr.establish();
		assertEquals(1.0, Duration.between(cdr.getStartTime(), LocalDateTime.now()).getSeconds(), 0.1);
		Thread.sleep(1000);
				cdr.disconnect();
		System.out.println(cdr.toString());
		assertTrue(cdr.toString().matches("calling: \\+44 44\\/725 8912, called: \\+1 982\\/543 1201, start: " + TIMESTAMP_PATTERN + ", end: " + TIMESTAMP_PATTERN));
		assertEquals(2.0, Duration.between(cdr.getStartTime(), cdr.getEndTime()).getSeconds(), 0.1);
		Thread.sleep(1000);
		cdr.disconnect();
		assertEquals(2.0, Duration.between(cdr.getStartTime(), cdr.getEndTime()).getSeconds(), 0.1);
	}
}
