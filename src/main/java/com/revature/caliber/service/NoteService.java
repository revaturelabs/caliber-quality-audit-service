package com.revature.caliber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Note;
import com.revature.caliber.dao.NoteRepository;

/**
 * Implementing the business logic for handling Note objects
 * @author thienle
 *
 */
@Service
public class NoteService {
	
	/**
	 * The repository is responsible for interacting with the note table
	 */
	@Autowired
	NoteRepository noteRepo;
	
	/**
	 * 
	 * @return notes
	 */
	public List<Note> getAllNotes() {
		return noteRepo.findAll();
	}
	
	/**
	 * Save note
	 * @param n
	 * @return
	 */
	public Note createNote(Note n) {
		
		return noteRepo.save(n);
	}
	
	/**
	 * Delete a note
	 * @param id
	 */
	public void deleteNote(Integer id) {
		noteRepo.delete(id);
	}
	
	public Note findById(Integer id) {
		return noteRepo.findOne(id);
	}
	
	/**
	 * Update a note
	 * @param n
	 * @return
	 */
	public Note updateNote(Note n) {
		return noteRepo.save(n);
	}


}
