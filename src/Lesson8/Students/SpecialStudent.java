package Lesson8.Students;

import java.util.Arrays;

/**
 * Created by slash22 on 13.07.2017.
 */
public class SpecialStudent extends CollegeStudent {

    long secretKey;
    String email;

    public SpecialStudent(String firstName, String lastName, int group, Course[] coursesTaken, long secretKey, String email) {
        super(firstName, lastName, group, coursesTaken);
        this.secretKey = secretKey;
        this.email = email;
    }

    @Override
    public String toString() {
        return "SpecialStudent{" +
                "collegeName='" + collegeName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", rating=" + rating +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", group=" + group +
                ", coursesTaken=" + Arrays.toString(coursesTaken) +
                ", secretKey=" + secretKey +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
