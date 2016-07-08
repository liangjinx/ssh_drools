package zhinan.liang.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 * Created by liang on 2016/6/16.
 */
@Entity
@Table
public class Student implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int age;
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;

        Student student = (Student) obj;

        if (id != student.id) return false;
        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
