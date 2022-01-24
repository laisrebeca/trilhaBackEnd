package trilha.back.financys.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import trilha.back.financys.entities.CategoriaEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LancamentoDto {
    private String name;
    private String date;
    private String amount;
    private String description;
    private String paid;
    private String type;
    private CategoriaEntity categoryId;
}
