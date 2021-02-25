/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package contactbook;

import java.util.Arrays;


public class ContactBook {
    private int contactNumber;
    private int contactCapacity;
    private int lastContact;
    private Contact[] contacts;

    public ContactBook(int initialCapacity) {
        this.contactNumber = 0;
        this.contactCapacity = initialCapacity;
        this.lastContact = 0;
        this.contacts = new Contact[initialCapacity];
    }

    public int getCapacity () {
        return contactCapacity;
    }
    public int getSize() {
        return contactNumber;
    }

    public boolean addContact(Contact contact) {
        if (contact == null) {
            return false;
        }

        int contactIndex = indexOf(contact.getName());
        if (contactIndex == -1) {
            if (!hasAvailableSpace()) {
                doubleCapacity();
            }
            contacts[lastContact] = contact;
            contactNumber++;
            lastContact++;
            return true;
        }
        return false;
    }

    public boolean removeContact(String contact) {
        if (contact == null) {
            return false;
        }

        int contactIndex = indexOf(contact);
        if (contactIndex == - 1) {
            return false;
        }
        contacts[contactIndex] = null;
        contactNumber--;
        return true;
    }

    public Contact findContact(String contact) {
        int contactIndex = indexOf(contact);
        if (contactIndex == -1) {
            return null;
        }
        return contacts[contactIndex];
    }

    private int indexOf(String contact) {
        if (contact != null) {
            for (int i = 0; i < lastContact; i++) {
                Contact value = contacts[i];
                if (value != null && value.getName() == contact) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean hasAvailableSpace() {
        return lastContact < contactCapacity;
    }

    private void doubleCapacity() {
        Contact[] contacts = Arrays.copyOf(this.contacts, contactCapacity * 2);
        contactCapacity = contacts.length;
        this.contacts = contacts;
    }



}