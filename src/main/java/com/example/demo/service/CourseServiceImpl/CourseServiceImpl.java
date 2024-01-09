package com.example.demo.service.CourseServiceImpl;

import com.example.demo.entity.Course;
import com.example.demo.exceptions.CourseNotFoundException;
import com.example.demo.repository.CourseRepo;
import com.example.demo.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Course> getCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourse(Long courseId) {
        return courseRepo.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + courseId));
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        if (!courseRepo.existsById(course.getId())) {
            throw new CourseNotFoundException("Course not found with id: " + course.getId());
        }
        return courseRepo.save(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        if (!courseRepo.existsById(courseId)) {
            throw new CourseNotFoundException("Course not found with id: " + courseId);
        }
        courseRepo.deleteById(courseId);
    }
}

// For Creating API and Service Implementaion using simple logic and java  8

//package com.example.demo.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.example.demo.entity.Course;
//
//public interface CourseRepo  extends JpaRepository<Course,Long>{
//
//}
//
//package com.example.demo.service;
//
//import java.util.List;
//
//import com.example.demo.entity.Course;
//
//public interface CourseService {
//
//	public List<Course> getCourses();
//	public Course getCourse( Long CourseId);
//	public Course createCourse(Course cource);
//	public Course updateCourse(Course cource);
//	public void deleteCourse(Long parseLong);
//	
//	
//		
//	}
//
//package com.example.demo.service.CourseServiceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entity.Course;
//import com.example.demo.repository.CourseRepo;
//import com.example.demo.service.CourseService;
//@Service
//public class CourseServiceImpl implements CourseService {
////	List<Course> list;
//	@Autowired
//	private CourseRepo courseRepo;
//	public CourseServiceImpl() {
////		list=new ArrayList<>();
////		list.add( new Course(1L,"Core java Course","This course contains core java course"));
////		list.add( new Course(2L,"Advanced java Course ","This course contains Advanced java course"));
////		list.add( new Course(3L,"Java 8 ","This course contains core java 8 course"));
////		list.add( new Course(4L,"Spring Boot Rest","This course contains Spring Boot and Rest api course course"));
//	}
//
//	@Override
//	public List<Course> getCourses() {
//		return courseRepo.findAll();
//		
////		return list;
//	}
//
//	@SuppressWarnings("deprecation")
//	@Override
//	public Course getCourse(Long CourseId) {
//		return courseRepo.getOne(CourseId);
////		Course c=null;
////		for( Course cource:list) {
////			if(cource.getId()==CourseId) {
////				c= cource;
////				break;
////			}
////			
////		}
////		return c;
//	}
//
//	@Override
//	public Course createCourse(Course cource) {
////		list.add(cource);
//		courseRepo.save(cource);
//		return cource;
//	}
//
//	@Override
//	public Course updateCourse(Course cource) {
////		list.forEach(e->{
////			if(e.getId()==cource.getId()){
////			   e.setTitle(cource.getTitle());
////			   e.setDescription(cource.getDescription());
////		}
////		});
//		courseRepo.save(cource);
//		return cource;
//	}
//
//	@Override
//	public void deleteCourse(Long parseLong) {
//	@SuppressWarnings("deprecation")
//	Course ent=courseRepo.getOne(parseLong);
//	courseRepo.delete(ent);// TODO Auto-generated method stub
//		
//	}
//	
//	
//
//	}
//		  
