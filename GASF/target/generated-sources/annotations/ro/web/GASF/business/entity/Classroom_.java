package ro.web.GASF.business.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ro.web.GASF.business.entity.Course;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-07T00:07:44")
@StaticMetamodel(Classroom.class)
public class Classroom_ { 

    public static volatile CollectionAttribute<Classroom, Course> courseCollection;
    public static volatile SingularAttribute<Classroom, Integer> classroomid;
    public static volatile SingularAttribute<Classroom, String> classroomname;

}