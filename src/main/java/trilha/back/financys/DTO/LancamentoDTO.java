package trilha.back.financys.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import trilha.back.financys.entities.CategoriaEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LancamentoDTO {
    private String name;
    private String date;
    private String amount;
    private String description;
    private String paid;
    private CategoriaEntity categoryId;


    public LancamentoDTO(String name, String description, String amount, String date, Boolean paid) {
    }
}
