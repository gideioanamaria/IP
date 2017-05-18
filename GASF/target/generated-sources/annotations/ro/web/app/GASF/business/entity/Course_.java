package ro.web.app.GASF.business.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ro.web.app.GASF.business.entity.Classroom;
import ro.web.app.GASF.business.entity.Specialization;
import ro.web.app.GASF.business.entity.Student;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-17T22:45:26")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile CollectionAttribute<Course, Specialization> specializationCollection;
    public static volatile CollectionAttribute<Course, Classroom> classroomCollection;
    public static volatile CollectionAttribute<Course, Student> studentCollection;
    public static volatile SingularAttribute<Course, Integer> courseYear;
    public static volatile SingularAttribute<Course, String> courseTeacher;
    public static volatile SingularAttribute<Course, Long> courseid;
    public static volatile SingularAttribute<Course, String> coursename;

}