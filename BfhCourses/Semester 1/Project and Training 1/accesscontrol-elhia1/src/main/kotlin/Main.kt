/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */
package acl

import acl.access.AccessControlEntity
import acl.access.AccessControlList
import acl.access.AccessRight
import acl.resource.Directory
import acl.resource.File
import acl.user.User

fun main() {
  // create directory hierarchy
  val root = Directory("root")
  val docs = Directory("docs")
  val personal = Directory("personal")
  val letter = File("letter", "Dear Bill, don't kill. Regards Joe")
  root.add(docs)
  docs.add(personal)
  docs.add(letter)

  // Joe wants to read letter without access rights --> no access
  val joe = User("Joe")
  println(letter.accessBy(joe))

  // Access right GRANTED on root --> Joe can read letter
  var acl = AccessControlList()
  acl.add(AccessControlEntity(joe, AccessRight.GRANTED))
  root.ACL = acl
  println(letter.accessBy(joe))

  // Additional access right DENIED on docs --> Joe cannot read letter
  acl = AccessControlList()
  acl.add(AccessControlEntity(joe, AccessRight.DENIED))
  docs.ACL = acl
  println(letter.accessBy(joe))

  // Additional access right GRANTED on letter --> Joe can read letter
  acl = AccessControlList()
  acl.add(AccessControlEntity(joe, AccessRight.GRANTED))
  letter.ACL = acl
  println(letter.accessBy(joe))
}
