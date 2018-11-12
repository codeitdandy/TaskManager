package com.alltasks.scheduler.controller;

import com.alltasks.scheduler.domain.Task;
import com.alltasks.scheduler.repository.TaskRepository;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.text.ParseException;

import java.time.Duration;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


@Controller
public class TaskController {


	private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @GetMapping(value = "/tasks", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    Flux<Task> findTasks() throws ParseException {
    
    	/*List<Task> taskList = taskRepository.findAllWithCreationDateTimeAfter(
    	          new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(UtilityTask.getCurrentDateTimeFormatted()));*/
    		
    	
    	
    	
    	List<Task> taskList = taskRepository.findAll();
    	List<Task> taskList1=null;
    	Map<String,Task> sortedDateMap=new TreeMap<String,Task>();
    	for(Task task:taskList) {
    	sortedDateMap.put(task.getDueDate(),task);
    	}
    	 taskList1=sortedDateMap.values().stream().collect((Collectors.toList()));
    	
    	Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
    	//interval.subscribe((i) -> taskRepository.findAll());
    	Flux<Task> tasks = Flux.fromIterable(taskList1);
		return Flux.zip(interval, tasks).map(Tuple2::getT2);
	

    }

   

    

    @GetMapping("/")
    Mono<String> home() {
        return Mono.just("task");
    }



}
