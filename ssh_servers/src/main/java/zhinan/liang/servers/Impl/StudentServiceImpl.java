package zhinan.liang.servers.Impl;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;
import zhinan.liang.entitys.Student;
import zhinan.liang.servers.StudentService;

import java.util.List;

/**
 * Created by liang on 2016/6/29.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService{
    /**
     *   @Autowired
    private KnowledgeBase kbase;
     */
    public List<Student> findAllStudent() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession( "ke" );
        Student s=new Student();
        s.setId(1);
        s.setName("zhang");
        s.setAge(23);
        kSession.insert(s);
        kSession.fireAllRules();
        kSession.destroy();
        System.out.println(s.getName());
        return null;
    }

    public List<Student> findByparam(String name) {
        return null;
    }
}
