package trilha.back.financys.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.entities.Entry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/entry")
public class EntryController {
    private final List<Entry> list = new ArrayList<>();
      @GetMapping("/read")
      public ResponseEntity<List<Entry>> read(){
        Collections.sort(list, Comparator.comparing(Entry::getDate));
        return ResponseEntity.ok().body(list);
      }
      @PostMapping("/create")
      public ResponseEntity<List<Entry>>create(@RequestBody Entry entry) {
        Entry entry1 = new Entry();
        entry1.setId(entry.getId());
        entry1.setName(entry.getName());
        entry1.setDescription(entry.getDescription());
        entry1.setType(entry.getType());
        entry1.setAmount(entry.getAmount());
        entry1.setDate(entry.getDate());
        entry1.setPaid(entry.getPaid());
        entry1.setCategoryId(entry.getCategoryId());
        list.add(entry1);
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
      }
}
