package com.alltasks.scheduler.repository;


import com.alltasks.scheduler.domain.Task;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;


@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task, String>,JpaSpecificationExecutor<Date> {


	/*@Query("select a from Task11 a where a.createdAt <= :creationDateTime")
    List<Task> findAllWithCreationDateTimeAfter(
      @Param("creationDateTime") Date creationDateTime);*/
}
