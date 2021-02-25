/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package acl.access;

import acl.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * The AccessControlList is a container for AccessControlEntity objects.
 * @author ahmed elhilali
 */
public class AccessControlList{

    private List<AccessControlEntity> accessControlEntities;

    /**
     * AccessControlList constructor initializes the accessControlEntities
     */
    public AccessControlList() {
        accessControlEntities = new ArrayList<>();
    }

    /**
     * The add method checks the the list of associated AccessControlEntity Objects with the highest precedence.
     * @param accessControlEntity
     */
    public void add(AccessControlEntity accessControlEntity) {
        for (AccessControlEntity ace : accessControlEntities) {
            if (ace.getAccessRight().equals(AccessRight.GRANTED)) {
                accessControlEntities.set(accessControlEntities.indexOf(ace), accessControlEntity);
            }
        }
        accessControlEntities.add(accessControlEntity);
    }

    /**
     * The getAccessRightFor searches the list of associated AccessControlEntity,
     * objects for the one with the highest precedence for the given user.
     * @param user
     * @return accessRight
     */
    public AccessRight getAccessRightFor(User user) {
        for (AccessControlEntity accessControlEntity : accessControlEntities) {
            if (user.equals(accessControlEntity.getUser())) {
                return accessControlEntity.getAccessRight();
            }
        }
        return null;
    }

}