package com.imooc.course.service.impl;

import com.imooc.course.client.CourseListClient;
import com.imooc.course.entity.Course;
import com.imooc.course.entity.CourseAndPrice;
import com.imooc.course.entity.CoursePrice;
import com.imooc.course.dao.CoursePriceMapper;
import com.imooc.course.service.CoursePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：课程价格的实现类
 */
@Service
public class CoursePriceServiceImpl implements CoursePriceService {
    @Autowired
    CoursePriceMapper coursePriceMapper;

    @Autowired
    CourseListClient courseListClient;

    @Override
    public CoursePrice getCoursePrice(Integer courseId) {
        return coursePriceMapper.findCoursePrice(courseId);
    }

    @Override
    public List<CourseAndPrice> getCourseAndPrice() {
        List<CourseAndPrice> courseAndPriceList = new ArrayList<>();
        List<Course> courses = courseListClient.courseList();
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            if(course!=null){
                CoursePrice coursePrice = getCoursePrice(course.getCourseId());
                CourseAndPrice courseAndPrice = new CourseAndPrice();
                courseAndPrice.setCourseId(course.getCourseId());
                courseAndPrice.setId(course.getId());
                courseAndPrice.setName(course.getCourseName());
                courseAndPrice.setPrice(coursePrice.getPrice());
                courseAndPriceList.add(courseAndPrice);
            }
        }
        return courseAndPriceList;
    }
}
