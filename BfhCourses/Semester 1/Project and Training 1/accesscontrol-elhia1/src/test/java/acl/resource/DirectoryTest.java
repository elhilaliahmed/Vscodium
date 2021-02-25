package acl.resource;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DirectoryTest {
	private Directory parent;
	private Directory child;
	private File file;
	
	private String parentName;
	private String childName;
	private String fileName;
	

	@BeforeEach
	void setUp() throws Exception {
		parentName = "parent" + LocalDateTime.now();
		parent = new Directory(parentName);
		childName = "child" + LocalDateTime.now();
		child = new Directory(childName);
		fileName = "file" + LocalDateTime.now();
		file = new File(fileName, "blah");
	}

	@Test
	void testGetContentNoChild() {
		assertEquals("", parent.getContent());
	}

	@Test
	void testGetContentSingleChild() {
		parent.add(child);
		assertEquals(childName + "\n", parent.getContent());
	}

	@Test
	void testGetContentMultipleChildren() {
		parent.add(child);
		parent.add(file);
		assertEquals(childName + "\n" + fileName + "\n", parent.getContent());
	}

	@Test
	void testGetName() {
		assertEquals(parentName, parent.getName());
	}
}
