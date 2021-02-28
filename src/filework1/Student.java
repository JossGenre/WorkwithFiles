package filework1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
    int id;
    String group;
    String name;
    double avgmark;
List<Integer> markset;


    public Student(int id, String group, String name, List<Integer> markset) {
        this.id = id;
        this.group = group;
        this.name = name;
        this.markset = markset;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", markset=" + markset +'\'' +
                ", avgmark=" + avgmark+
                '}';
    }

    public double getAvgmark() {
        return avgmark;
    }

    public void setAvgmark(double avgmark) {
        this.avgmark = avgmark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMarkset() {
        return markset;
    }

    public void setMarkset(List<Integer> markset) {
        this.markset = markset;
    }
}
