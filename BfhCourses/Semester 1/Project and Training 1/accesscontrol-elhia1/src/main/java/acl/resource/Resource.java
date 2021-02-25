package acl.resource;

import acl.access.AccessControlList;
import acl.access.AccessRight;
import acl.user.User;

/**
 * The Resource class is the base class for the Directory and File class.
 * @author ahmed elhilali
 */
public abstract class Resource {
    private String name;
    private AccessControlList accessControlList;
    private Directory parent;

    /**
     * Resource constructor take a name parameter
     * @param name
     */
    public Resource(String name) {
        this.name = name;
    }

    /**
     *
     * @param accessControlList object
     */
    public void setACL(AccessControlList accessControlList){
        this.accessControlList = accessControlList;
    }

    /**
     * The accessBy method allows the user to read the content of a resource provided that the accessRight is GRANTED.
     * @param user
     * @return a string.
     */
    public String accessBy(User user) {
        Resource resource = this;
        AccessRight accessRight = null;
        while (resource.parent != null) {
            if (resource.accessControlList != null && resource.accessControlList.getAccessRightFor(user) != null) {
                break;
            }
            resource = resource.parent;
        }

        if (resource.accessControlList != null) {
            accessRight = resource.accessControlList.getAccessRightFor(user);
        }
        if (accessRight == AccessRight.GRANTED) {
            return getContent();
        }
        return "Exception: Access denied";
    }

    /**
     * The getContent method returns the name of the file or the directory.
     * @return a string
     */
    public String getContent(){
        return name;
    }

    /**
     * The getName method returns the name of the file or the directory.
     * @return a string
     */
    public String getName(){
        return name;
    }

    /**
     * The setParent method sets the parent directory.
     * @param parent
     */
    public void setParent(Directory parent){
        this.parent = parent;
    }
}
