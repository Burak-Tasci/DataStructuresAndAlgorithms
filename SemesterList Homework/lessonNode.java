public class lessonNode {

    lessonNode next;
    String lessonCode;
    int semester;
    String lessonName;
    boolean state;

    public lessonNode() {
        this.state = true;
    }
    public lessonNode(int semester, String lessonCode, String lessonName)
    {
        this.state = true;
        this.semester = semester;
        this.lessonCode = lessonCode;
        this.lessonName = lessonName;
    }

    public lessonNode nextInSemester()
    {
        return this.next;
    }

    public void display()
    {
        System.out.println("Semester: "+this.semester+" Lesson Code: "+this.lessonCode+" Lesson Name: "+this.lessonName);
    }
}
