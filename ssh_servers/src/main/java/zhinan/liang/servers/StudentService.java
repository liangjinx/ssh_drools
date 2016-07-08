package zhinan.liang.servers;

import zhinan.liang.entitys.Student;

import java.util.List;

/**
 * Created by liang on 2016/6/29.
 */
public interface StudentService {
    List<Student> findAllStudent();
    List<Student> findByparam(String name);
}
