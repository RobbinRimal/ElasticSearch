package elastic;

public class Student {
   private String firstName;
    private String lastName;
    private String ID;

    public Student(){}
    public Student(String firstName,String lastName ){
        this.firstName=firstName;
        this.lastName=lastName;
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


}
