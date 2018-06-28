package org.wecancodeit.Coursewithinstructors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class CoursePopulator implements CommandLineRunner {

		@Autowired
		private CoursesRepository courseRepo;
		
		@Autowired
		private TextbookRepository textbookRepo;
		
		@Autowired
		private TopicsRepository topicRepo;
		
		@Override
		public void run(String... args) throws Exception {
			Topic topicJava = topicRepo.save(new Topic("Java"));
//			Topic topicSpring = topicRepo.save(new Topic("Spring"));
			Topic topicTdd = topicRepo.save(new Topic("tdd"));
			
			Course introToJava = courseRepo.save(new Course("Intro to Java", "An introduction to the core java principles", topicJava));
			Course advSoftwareAndDesign  = courseRepo.save(new Course("Advanced Software and Design", "Advanced software principles and advanced", topicJava, topicTdd));
		
			Textbook bookHfj = textbookRepo.save(new Textbook("Head First Java", introToJava));
			Textbook bookHfdp = textbookRepo.save(new Textbook("Head First Design Patterns", advSoftwareAndDesign));
			Textbook bookCleanCode = textbookRepo.save(new Textbook("Clean Code", advSoftwareAndDesign));
			Textbook bookJPA = textbookRepo.save(new Textbook("Intro to JPA", advSoftwareAndDesign));
		}

}
