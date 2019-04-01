package com.example.experiment_01.respository;

import com.example.experiment_01.entity.Course;
import com.example.experiment_01.entity.Elective;
import com.example.experiment_01.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ElectiveRepository {
    @PersistenceContext
    private EntityManager em;
    public void addElective() {
        Student stud1 = new Student("zhanyeye");
        Student stud2 = new Student("xiaoming");
        em.persist(stud1);
        em.persist(stud2);
        Course c1 = new Course("math");
        Course c2 = new Course("english");
        em.persist(c1);
        em.persist(c2);
        Elective e1 = new Elective();
        e1.setCourse(c1);
        e1.setStudent(stud1);
        Elective e2 = new Elective();
        e2.setCourse(c1);
        e2.setStudent(stud2);
        em.persist(e1);
        em.persist(e2);

    }
}
