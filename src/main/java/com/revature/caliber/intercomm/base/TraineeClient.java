package com.revature.caliber.intercomm.base;

import com.revature.caliber.beans.Trainee;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

public interface TraineeClient {

	/**
	 * Handles get request for returning all trainees with the given batch id as a
	 * request parameter.
	 * 
	 * @param batch The batch id representing the batch to get all the trainees from
	 * @return The list of trainees with the correct batch id.
	 */
	@GetMapping(value = "/user/all/trainee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainee>> findAllByBatch(@RequestParam("batch") Integer batch);

	/**
	 * Handles put request for updating a trainee in a batch
	 * 
	 * @param trainee The trainee to be updated
	 * @return The updated Trainee object and an accepted http-status code
	 */
	@PutMapping(value = "/user/all/trainee/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Trainee> updateTrainee(@Valid @RequestBody Trainee trainee);

}
