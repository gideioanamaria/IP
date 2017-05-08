package ro.web.GASF.business.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ro.web.GASF.business.entity.Course;
import ro.web.GASF.business.entity.Specialization;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-07T00:07:44")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, Long> studentid;
    public static volatile SingularAttribute<Student, String> firstName;
    public static volatile SingularAttribute<Student, String> lastName;
    public static volatile SingularAttribute<Student, String> cnp;
    public static volatile SingularAttribute<Student, String> telephonenumber;
    public static volatile CollectionAttribute<Student, Course> courseCollection;
    public static volatile SingularAttribute<Student, String> adress;
    public static volatile SingularAttribute<Student, Specialization> specializationid;
    public static volatile SingularAttribute<Student, String> email;
    public static volatile SingularAttribute<Student, Integer> anstudiu;

}