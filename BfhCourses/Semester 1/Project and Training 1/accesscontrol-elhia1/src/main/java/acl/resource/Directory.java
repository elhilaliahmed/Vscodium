package acl.resource;


import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ahmed elhilali
 */
public class Directory extends Resource {

    private List<Resource> children;

    /**
     * The Directory constructs take a name that's handled by the Resource constructor and initializes the children list.
     * @param name Directory name
     */
    public Directory(String name) {
        super(name);
        children = new LinkedList<>();
    }

    /**
     * The add method adds resource objects to the children list.
     * @param resource
     */
    public void add(Resource resource) {
        children.add(resource);
        resource.setParent(this);
    }

    /**
     * The getContent method checks the list of resource and returns them.
     * @return the names of the sub-directories and files saved in the children list
     */
    @Override
    public String getContent() {
       String result = "";
       for (Resource resource : children) {
           result += resource.getName() + "\n";
       }
       return result;
    }
}
