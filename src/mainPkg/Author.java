package mainPkg;

/**
 * this class is responsible for keeping track
 * of all Authors
 */

public class Author {
    private int id;
    private String firstName;
    private String lastName;

    /**
     * Create new author object by init values
     *
     * @param id unique ID of author
     */
    public Author(int id, String firstName, String lastName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}