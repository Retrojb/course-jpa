package org.wecancodeit.Coursewithinstructors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {

		@Autowired
		TopicsRepository topicRepo;
		@Autowired
		TextbookRepository textRepo;
		@Autowired
		CoursesRepository courseRepo;
		
		@RequestMapping("/")
		public String home() {
			return courseRepo.findOne(1L).toString();
		}
}
