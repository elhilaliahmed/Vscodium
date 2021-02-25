package acl.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileTest {
	private String name;
	private String content;
	private File file;

	@BeforeEach
	void setup() {
		name = "Name" + LocalDateTime.now();
		content = "Content" + LocalDateTime.now();
		file = new File(name, content);
	}
	
	@Test
	void testGetName() {
		assertEquals(name, file.getName());
	}
	
	@Test
	void testGetContent() {
		assertEquals(content, file.getContent());
	}
}
