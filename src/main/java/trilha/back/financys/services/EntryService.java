package trilha.back.financys.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import trilha.back.financys.entities.Category;
import trilha.back.financys.entities.Entry;
import trilha.back.financys.repository.CategoryRepository;
import trilha.back.financys.repository.EntryRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public Entry createService (Entry entry){
        entry.setId(ThreadLocalRandom.current().nextLong(1, 10000));
        return entryRepository.save(entry);
    }
    public List<Entry> readAll() {
        return new ArrayList<>(entryRepository.findAll());
    }


    public Entry findById(Long id) {
        Optional<Entry> entry = entryRepository.findById(id);
        return entry.get();
    }

    public void deleteById(Long id) {
        entryRepository.deleteById(id);
    }

    public Entry update(Entry  entry, Long id) {
        try {
            Entry entryUpdate =entryRepository.findById(id)
                    .orElseThrow();
            entryUpdate.setName(entry.getName());
            entryUpdate.setDescription(entry.getDescription());
            entryUpdate.setAmount(entry.getAmount());
            entryUpdate.setPaid(entry.getPaid());
            entryUpdate.setType(entry.getType());
            entryUpdate.setDate(entry.getDate());
            entryUpdate.setCategoryId(entry.getCategoryId());
            return entryRepository.save(entryUpdate);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean validateCategoryById(Category categoryId) {
        for (Entry value : entryRepository.findAll()) {
            if (value.getId() == categoryId.getId()) {
                return true;
            }
        }

        return false;

    }
}