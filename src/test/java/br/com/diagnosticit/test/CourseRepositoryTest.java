/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.test;

import br.com.diagnosticit.CourseRepository;
import br.com.diagnosticit.JpaDemoApplication;
import br.com.diagnosticit.domain.Course;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author cristianoca
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class)
public class CourseRepositoryTest {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    CourseRepository repository;
    
    @Test
    public void contextLoads(){
        Course course = repository.findById( 1L );
        assertEquals("Java Como Programar", course.getName());
    }
}