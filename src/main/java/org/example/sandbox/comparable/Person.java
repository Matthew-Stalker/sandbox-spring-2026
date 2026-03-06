package org.example.sandbox.comparable;

public class Person implements Comparable<Person> {

    private String Firstname;
    private String Lastname;
    private int age;

    public Person(String Firstname, String Lastname, int age) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.age = age;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("Firstname='").append(Firstname).append('\'');
        sb.append(", Lastname='").append(Lastname).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Person that) {

        // First compare by age
        if (this.age > that.age) {
            return 1;
        } else if (this.age < that.age) {
            return -1;
        }else {

            // If ages are equal, compare by last name
            if(this.Lastname.compareTo(that.Lastname) > 0){
                return 1;
            } else if(this.Lastname.compareTo(that.Lastname) < 0){
                return -1;
            } else {

                // If Last names are also equal, compare by first name
                if(this.Firstname.compareTo(that.Firstname) > 0){
                    return 1;
                } else if(this.Firstname.compareTo(that.Firstname) < 0){
                    return -1;
                } else {
                    return 0;
                }

            }

        }

    }

}
