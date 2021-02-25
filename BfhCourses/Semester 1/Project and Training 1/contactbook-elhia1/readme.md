# Contact Book

Implement a class `Contact` which contains a person's name, email address and phone number.

Implement a class `ContactBook` which contains an array of contacts and provides the following public methods:
- `getCapacity(): int`
  returns the maximum number of contacts
- `getSize(): int`
  returns the actual number of contacts
- `addContact(contact: Contact): boolean` 
  adds a contact if no contact with the same already exists; the return value indicates if the addition was successful
- `findContact(name: String): Contact`
  returns the contact with the given name, or `null` if no such contact exists
- `removeContact(name: String): boolean`
  removes the contact with the given name; the return value indicates if the removal was successful

The class `ContactBook` has a constructor that allows to specify the initial capacity. As contacts are added, the capacity shall be increased if necessary.

_@Kotlin: Kotlin does not know native arrays of objects (`Object[]`). 
Use the collection class `Array<Object>` instead._
_Two solutions are possible:_ 
- _a not nullable Array (`Array<Object>`): this requires the initialization of the Array with a lambda expression,_
- _an Array with nullable elements (`Array<Object?>`): in this case the `arrayOfNulls` function can be used to create the array._
 