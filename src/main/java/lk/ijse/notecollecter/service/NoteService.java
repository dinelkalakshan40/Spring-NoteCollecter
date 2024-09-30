package lk.ijse.notecollecter.service;

import lk.ijse.notecollecter.dto.NoteStatus;
import lk.ijse.notecollecter.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
        void saveNote(NoteDTO noteDTO);
        List<NoteDTO> getAllNotes();
        NoteStatus getNote(String noteId);
        boolean deleteNote(String noteId);
        boolean updateNote(String noteId, NoteDTO noteDTO);

}
