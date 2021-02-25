package acl.access;

import acl.user.User;

/**
 * The AccessControlEntity class provides the user with a readAccessRight.
 * @author ahmed elhilali
 */
public class AccessControlEntity {
    private User user;
    private AccessRight readAccessRight;

    /**
     * The AccessControlEntity associates the user with a specific readAccessRight, i.e., UNSPECIFIED, GRANTED, DENIED.
     * @param user
     * @param readAccessRight
     */
    public AccessControlEntity(User user, AccessRight readAccessRight){
        this.user = user;
        this.readAccessRight = readAccessRight;
    }

    /**
     *  returns the user object.
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * returns the readAccessRight object.
     * @return readAccessRight
     */
    public AccessRight getAccessRight() {
        return readAccessRight;
    }
}
