package com.imooc.course.client;

import com.imooc.course.entity.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：断路器实现类
 */
@Component
public class CourseListClientHystrix implements CourseListClient{
    @Override
    public List<Course> courseList() {
        List<Course> defaultCourses = new ArrayList<>();
        Course course = new Course();
        course.setId(1);
        course.setCourseId(1);
        course.setCourseName("默认课程");
        course.setValid(1);
        defaultCourses.add(course);
        return defaultCourses;//或者也可以返回return Collections.emptyList()空列表
    }
}
