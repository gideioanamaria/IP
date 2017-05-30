package ro.web.app.GASF.business.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ro.web.app.GASF.business.entity.Course;
import ro.web.app.GASF.business.entity.Student;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-30T22:39:31")
@StaticMetamodel(Specialization.class)
public class Specialization_ { 

    public static volatile CollectionAttribute<Specialization, Course> courseCollection;
    public static volatile SingularAttribute<Specialization, Integer> specializationid;
    public static volatile CollectionAttribute<Specialization, Student> studentCollection;
    public static volatile SingularAttribute<Specialization, String> specializationname;

}