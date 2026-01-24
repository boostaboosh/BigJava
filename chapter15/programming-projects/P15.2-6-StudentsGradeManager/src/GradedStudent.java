public class GradedStudent
{
    private final Student student;
    private String grade;

    public GradedStudent(Student student, String grade)
    {
        if (isInvalidGrade(grade))
        {
            throw new IllegalArgumentException(
                    "Grades must be letter grades from A to F optionally followed by + or -");
        }
        this.student = student;
        this.grade = grade;
    }

    private boolean isInvalidGrade(String grade) {
        return grade.isEmpty() || grade.length() > 2
                || grade.charAt(0) < 'A' || grade.charAt(0) > 'F'
                || (grade.length() == 2 && grade.charAt(1) != '+' && grade.charAt(1) != '-');
    }

    public Student getStudent()
    {
        return this.student;
    }

    public void setGrade(String grade)
    {
        if (isInvalidGrade(grade))
        {
            throw new IllegalArgumentException(
                    "Grades must be letter grades from A to F optionally followed by + or -");
        }
        this.grade = grade;
    }

    public String getGrade()
    {
        return this.grade;
    }

}
