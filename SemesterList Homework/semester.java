public class semester {

    lessonNode head;
    lessonNode tail;
    semester next;

    public semester()
    {
        this.head = null;
        this.tail = null;
    }

    public void add(int semester, String lessonCode, String lessonName)
    {
        lessonNode newNode = new lessonNode(semester, lessonCode, lessonName);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
            tail.next = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }


    public boolean remove(int index)
    {
        lessonNode iter = head;
        if (index == 0)
        {
            if (head.state){
                head = head.next;
                tail.next = head;
                return true;
            }
            else
                return false;
        }
        else if (index == this.size()-1)
        {
            do {
                iter = iter.next;
            }while (iter.next != tail);
            if (tail.state)
            {
                tail = iter;
                tail.next = head;
                return true;
            }
            else
                return false;

        }
        else
        {
            for (int i = 0; i<index-1;i++)
            {
                iter = iter.next;
            }
            if (iter.state)
            {
                iter.next = iter.next.next;
                return true;

            }
            else
                return false;
        }
    }

    public void display()
    {
        lessonNode iter = head;
        System.out.println("[");
        do {
            if (iter.state)
                System.out.println("Semester: "+iter.semester+" Lesson Code: "+iter.lessonCode+" Lesson Name: "+iter.lessonName);
            iter = iter.next;
        }while (iter!=head);
        System.out.print("]\n");
    }

    public int size()
    {
        int i = 0;
        lessonNode iter = head;
        do {
            i++;
            iter = iter.next;
        }while (iter!=head);

        return i;
    }

    public boolean Disable(int index)
    {
        lessonNode iter = head;
        if (index == 0)
        {
            if (head.state){
                head.state = false;
                return true;
            }
            else
                return false;
        }
        else if (index == this.size()-1)
        {
            if (tail.state)
            {
                tail.state = false;
                return true;
            }
            else
                return false;

        }
        else
        {
            for (int i = 0; i<index-1;i++)
            {
                iter = iter.next;
            }
            if (iter.state)
            {
                iter.state = false;
                return true;

            }
            else
                return false;
        }
    }
    public boolean Enable(int index)
    {
        lessonNode iter = head;
        if (index == 0)
        {
            if (!head.state){
                head.state = true;
                return true;
            }
            else
                return false;
        }
        else if (index == this.size()-1)
        {
            if (!tail.state)
            {
                tail.state = true;
                return true;
            }
            else
                return false;

        }
        else
        {
            for (int i = 0; i<index-1;i++)
            {
                iter = iter.next;
            }
            if (!iter.state)
            {
                iter.state = true;
                return true;

            }
            else
                return false;
        }
    }
    public void showDisabled()
    {
        int i = 0;
        lessonNode iter = head;
        System.out.println("Disabled Nodes:\n[");
        do {
            if (!iter.state)
                System.out.println("Index: "+i+" Semester: "+iter.semester+" Lesson Code: "+iter.lessonCode+" Lesson Name: "+iter.lessonName);
            iter = iter.next;
            i++;
        }while (iter!=head);
        System.out.print("]\n");
    }



}
