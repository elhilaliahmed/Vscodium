package acl.resource;

/**
 *
 * @author ahmed elhilali
 */
public class File extends Resource {
    private String content;

    /**
     * The File constructor take two parameters: name and content.
     * @param name file name
     * @param content file content
     */
    public File(String name, String content) {
        super(name);
        this.content = content;

    }

    /**
     * The getContent method gets the file's content.
     * @return the file's content
     */
    public String getContent() {
        return content;
    }
}
