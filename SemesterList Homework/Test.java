import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {



        semesterList s = new semesterList();
         s.display();
        ArrayList<lessonNode> lessons = s.getByRange(0,5);
        for (lessonNode lesson:lessons)
        {
            lesson.display();
        }

        ArrayList<lessonNode> lessons_ = s.listSemester(1);

        for (lessonNode lesson:lessons_)
        {
            lesson.display();
        }

        lessonNode lesson =  s.getByCode("FZK1071");
        lesson.display();

    }
}
