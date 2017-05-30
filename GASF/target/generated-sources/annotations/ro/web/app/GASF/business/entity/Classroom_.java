package ro.web.app.GASF.business.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ro.web.app.GASF.business.entity.Course;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-30T22:39:31")
@StaticMetamodel(Classroom.class)
public class Classroom_ { 

    public static volatile CollectionAttribute<Classroom, Course> courseCollection;
    public static volatile SingularAttribute<Classroom, Integer> classroomid;
    public static volatile SingularAttribute<Classroom, String> classroomname;

}