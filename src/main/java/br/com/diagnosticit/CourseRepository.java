/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit;

import br.com.diagnosticit.domain.Course;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristianoca
 */
@Repository
@Transactional
public class CourseRepository {
        
    @PersistenceContext
    private EntityManager em;
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public Course findById( Long id ){
        return em.find( Course.class , id );
    }
    
    public void deleteById( Long id ){
        Course course = findById( id );
        em.remove( course );
    }
    
    public Course save( Course course ){
        if( course.getId() == null )
            em.persist( course );
        else
            em.merge( course );
        
        return course;
    }

    public void playWithEntityManager() {
        
        logger.info( "Play With EntityManager" );
        
        Course course1 = new Course( "Web services in 100 steps" );
        em.persist( course1 );
        
        Course course2 = new Course( "RESTFULL services in 100 steps" );
        em.persist( course2 );
                    
        //em.detach( course1 ); // desvincula objeto do contexto persistente
        //em.detach( course2 );
        em.flush();
        
        course1.setName( "Web services in 100 steps atualizado" );
        course2.setName( "RESTFULL services in 100 steps atualizado" );
        
        em.refresh( course1 );
        
        em.flush();
         

    }   


    
}
