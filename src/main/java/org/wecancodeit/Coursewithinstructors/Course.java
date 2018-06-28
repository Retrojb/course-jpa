package org.wecancodeit.Coursewithinstructors;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	private String description;
	
	@ManyToMany
	Collection<Topic> topics;
	@OneToMany
	Collection<Textbook> textbooks;

	protected Course() {}
	
	public Course(String title, String description, Topic ...topics) {
		this.title = title;
		this.description = description;
		this.topics = Arrays.asList(topics);
	}
	
	@Override
	public String toString() {
		return title + " " + description + " " + topics.toString();
	}
		
	public Collection<Topic> getTopics() {
		return topics;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	
}
