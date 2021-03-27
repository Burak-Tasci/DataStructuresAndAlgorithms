import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class semesterList {

    semester head;

    public semesterList()
    {
        this.head = null;
        for (int i = 1; i<9; i++)
            this.add(makeSemester(i));

    }




    private semester makeSemester(int semesterID)
    {
        semester SEMESTER = new semester();
        try (BufferedReader br = new BufferedReader(new FileReader("src/dersler.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                try {
                    if (values[0].equals(String.valueOf(semesterID)))
                        SEMESTER.add(Integer.valueOf(values[0]),values[1],values[2]);
                }
                catch (NumberFormatException e)
                {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SEMESTER;
    }

    private void add(semester newSemester)
    {
        if (head == null)
        {
            this.head = newSemester;
        }
        else
        {
            semester iter = this.head;
            while (iter.next != null)
                iter = iter.next;

            iter.next = newSemester;

        }
    }

    public void display()
    {
        semester iter = this.head;
        while (iter!= null)
        {
            iter.display();
            iter = iter.next;
        }
    }

    public ArrayList<lessonNode> getByRange(int start_index, int last_index)
    {
        lessonNode iter;
        lessonNode start = null;
        ArrayList<lessonNode> lessons = new ArrayList<>();
        for (int i = start_index; i<last_index;i++)
        {
            start = makeSemester(i+1).head;
            iter = start;
            do {
                lessons.add(iter);
                iter = iter.next;
            }while (iter != start);
        }

        return lessons;
    }
    public ArrayList<lessonNode> listSemester(int semester)
    {
        lessonNode iter;
        lessonNode start = null;
        ArrayList<lessonNode> lessons = new ArrayList<>();

        start = makeSemester(semester).head;
        iter = start;
        do {
            lessons.add(iter);
            iter = iter.next;
        }while (iter != start);


        return lessons;
    }

    public lessonNode getByCode(String code)
    {
        lessonNode lesson;
        lessonNode iter;
        lessonNode start = null;

        for (int i = 0; i<8;i++)
        {
            start = makeSemester(i+1).head;
            iter = start;
            do {
                if (iter.lessonCode.equals(code))
                    return iter;
                iter = iter.next;
            }while (iter != start);
        }
        return null;
    }


}
