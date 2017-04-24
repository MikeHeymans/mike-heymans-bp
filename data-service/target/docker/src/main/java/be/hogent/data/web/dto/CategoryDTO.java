package be.hogent.data.web.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CategoryDTO {
    private Long id;
    private Map<String, String> name;
    private Boolean active;

}
