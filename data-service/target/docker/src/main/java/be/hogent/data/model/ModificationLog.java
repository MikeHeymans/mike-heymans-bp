package be.hogent.data.model;

import com.datastax.driver.core.utils.UUIDs;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Table(name = "modification_log")
public class ModificationLog {
    @PartitionKey
    @Column(name = "table_name")
    private String tableName;
    @PartitionKey(1)
    @Column(name = "time")
    private UUID time;
    @PartitionKey(2)
    @Column(name = "id")
    private Long id;

    public static ModificationLog of(Logable logable) {
        ModificationLog modificationLog = new ModificationLog();
        modificationLog.setTableName(logable.getTableName());
        modificationLog.setTime(UUIDs.timeBased());
        modificationLog.setId(logable.getId());
        return modificationLog;
    }
}
