package org.wecancodeit.Coursewithinstructors;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CoursePopulatorTest {
	
	// Save and load a course - DONE
	// generate a course id - DONE
	//	save a textbook to a particular course - DONE
	//	establish course to topics relationship
	//	establish topic to courses relationship
	//	find courses for a topic
	//	find courses for a particular topic id

		@Autowired
		CoursesRepository courseRepo;
		@Autowired
		TextbookRepository textbookRepo;
		@Autowired
		TopicsRepository topicRepo;
		
		@Test
		public void populatorShouldSaveandLoadCourse() {
			Course testCourse = courseRepo.save(new Course("test", "test", new Topic("test topic")));
			//Act
			Course underTest = courseRepo.findOne(3L); // WHY 2 OR 3
			//Assert
			assertThat(underTest, is(equalTo(testCourse)));
		}
		
		// ask donny about different Long ids for assertion
		@Test
		public void populatorShouldGenerateCourseId() {
			Course testIdCourse = courseRepo.save(new Course("test", "test"));
			
			Boolean underTest = courseRepo.exists(2L); 
			
			assertTrue(underTest);
		}
		
		@Test
		public void populatorShouldSaveTextbookToCourse() {
			Course underTestCourse = courseRepo.save(new Course("TestbookCourseTest", "3rd test", new Topic("test topic")));
			Textbook underTextbook = textbookRepo.save(new Textbook("TestBook", underTestCourse));
			
			assertTrue(textbookRepo.exists(1L));
		}
		
		@Test
		public void populatorShouldEstablishRelationshipBetweenCourseToTopics() {
			Topic underTestTopic = topicRepo.save(new Topic("Head First test"));
			Course underTestCourse = courseRepo.save(new Course("TestbookCourseTest", "3rd test", underTestTopic));
			
			// access course through topics and vice versa
			assertTrue(underTestCourse.getTopics().contains(underTestTopic));
		}
}
