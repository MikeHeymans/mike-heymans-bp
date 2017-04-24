package be.hogent.data.service;


import be.hogent.data.model.Logable;
import be.hogent.data.model.ModificationLog;
import be.hogent.data.repository.ModificationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Service
public class ModificationLogService {
    @Autowired
    private ModificationLogRepository modificationLogRepository;

    public void create(Logable logable) {
        Objects.requireNonNull(logable, "logable can't be null");
        ModificationLog modificationLog = ModificationLog.of(logable);
        modificationLogRepository.save(modificationLog);
    }

    public Set<Long> findModified(String table, Date since) {
        Objects.requireNonNull(table, "table_name cannot be null");
        Objects.requireNonNull(since, "since cannot be null");
        return modificationLogRepository.findModified(table, since);
    }
}
