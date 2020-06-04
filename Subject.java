package data;

import java.io.Serializable;
import java.util.Objects;

public class Subject implements Serializable {
    private String name;
    private int mark;
    private static final int serialVersionUID = 1;

    public Subject(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return mark == subject.mark &&
                Objects.equals(name, subject.name);
    }


    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }
}
