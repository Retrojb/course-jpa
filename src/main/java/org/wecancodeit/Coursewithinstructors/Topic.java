package org.wecancodeit.Coursewithinstructors;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Topic {
	@Id
	@GeneratedValue
	private Long id; 
	private String name;
	
	@OneToMany
	private Collection<Course> courses;

	protected Topic() {}
	
	public Topic(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public Collection<Course> getCourses() {
		return courses;
	}
	
}
