package com.alltasks.scheduler.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name = "Task11")
	public class Task extends TaskModel  {
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	   
	    private Long id;	

	    private String title;
	    
        private String dueDate;
	    
	    public String getDueDate() {
			return dueDate;
		}

		public void setDueDate(String dueDate) {
			this.dueDate = dueDate;
		}

		public String getResolvedDate() {
			return resolvedDate;
		}

		public void setResolvedDate(String resolvedDate) {
			this.resolvedDate = resolvedDate;
		}

		private String resolvedDate;

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		@Column(columnDefinition = "text")
	    private String description;
		
		private String priority;
		
		private String status;

		public String getPriority() {
			return priority;
		}

		public void setPriority(String priority) {
			this.priority = priority;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		
		

	    // Getters and Setters (Omitted for brevity)
	}

