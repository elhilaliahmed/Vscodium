/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package acl;

import static acl.access.AccessRight.DENIED;
import static acl.access.AccessRight.GRANTED;

import acl.access.AccessControlEntity;
import acl.access.AccessControlList;
import acl.resource.Directory;
import acl.resource.File;
import acl.user.User;

public class Main {
	public static void main(String[] args) {
		// create directory hierarchy
		Directory root = new Directory("root");
		Directory docs = new Directory("docs");
		Directory personal = new Directory("personal");
		File letter = new File("letter", "Dear Bill, don't kill. Regards Joe");
		root.add(docs);
		docs.add(personal);
		docs.add(letter);

		// Joe wants to read letter without access rights --> no access
		User joe = new User("Joe");
		System.out.println(letter.accessBy(joe));

		// Access right GRANTED on root --> Joe can read letter
		AccessControlList acl = new AccessControlList();
		acl.add(new AccessControlEntity(joe, GRANTED));
		root.setACL(acl);
		System.out.println(letter.accessBy(joe));

		// Additional access right DENIED on docs --> Joe cannot read letter
		acl = new AccessControlList();
		acl.add(new AccessControlEntity(joe, DENIED));
		docs.setACL(acl);
		System.out.println(letter.accessBy(joe));

		// Additional access right GRANTED on letter --> Joe can read letter
		acl = new AccessControlList();
		acl.add(new AccessControlEntity(joe, GRANTED));
		letter.setACL(acl);
		System.out.println(letter.accessBy(joe));
	}
}
