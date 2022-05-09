package com.journal.journal.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/entry")
public class EntryController {
    private final EntryService entryService;
    @Autowired
    public EntryController(EntryService entryService){
        this.entryService = entryService;
    }
    @GetMapping
    public List<Entry> getEntries(){
        return entryService.getEntries();
    }
    @GetMapping(path = "{id}")
    public Entry getEntry(@PathVariable("id") int entryId){ return entryService.getEntries().get(entryId);}
    @PostMapping
    public void registerNewEntry(@RequestBody Entry entry){
        entryService.addNewEntry(entry);
    }
    @PutMapping(path = "{id}")
    public void updateEntry(@PathVariable("id") Long entryId,
                            @RequestBody Entry entry){
        entryService.updateEntry(entryId , entry.getContent() , entry.getTitle());
    }
    @DeleteMapping(path = "{entryId}")
    public void deleteEntry(@PathVariable("entryId") Long entryId){
        entryService.deleteEntry(entryId);
    }
}
