package ro.web.app.GASF.business.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ro.web.app.GASF.business.entity.Course;
import ro.web.app.GASF.business.entity.Specialization;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-17T22:45:26")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile CollectionAttribute<Student, Course> courseCollection;
    public static volatile SingularAttribute<Student, String> lastName;
    public static volatile SingularAttribute<Student, String> adress;
    public static volatile SingularAttribute<Student, Integer> anstudiu;
    public static volatile SingularAttribute<Student, Specialization> specializationid;
    public static volatile SingularAttribute<Student, String> email;
    public static volatile SingularAttribute<Student, String> cnp;
    public static volatile SingularAttribute<Student, String> firstName;
    public static volatile SingularAttribute<Student, String> telephonenumber;
    public static volatile SingularAttribute<Student, Long> studentid;

}