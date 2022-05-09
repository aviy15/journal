package com.journal.journal.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class EntryService {

    private final EntryRepository entryRepository;
    @Autowired
    public EntryService(EntryRepository entryRepository){
        this.entryRepository = entryRepository;
    }
    public List<Entry> getEntries(){
        return entryRepository.findAll();
    }
    public List<Entry> getEntriesSorted(){
        return entryRepository.findAll(Sort.by(Sort.Direction.ASC , "date"));
    }

    public void addNewEntry(Entry entry) {
        if(entry.getContent().length() != 0 && entry.getTitle().length()!=0){
            entryRepository.save(entry);
            //System.out.println("inserted");
        }
        System.out.println(entry);
    }

    public void deleteEntry(Long entryId) {
        if(!entryRepository.existsById(entryId)){
            throw new IllegalStateException("record with id " + entryId + " does not exist");
        }
        entryRepository.deleteById(entryId);
    }
    @Transactional
    public void updateEntry(Long entryId, String entryContent, String entryTitle) {
        if(!entryRepository.existsById(entryId)){
            throw new IllegalStateException("record with id " + entryId + " does not exist");
        }
        Entry entry = entryRepository.getById(entryId);
        if(entryContent!=null && entryContent.length()>0){
            entry.setContent(entryContent);
        }
        if(entryTitle!=null && entryTitle.length()>0){
            entry.setTitle(entryTitle);
        }
    }
}
