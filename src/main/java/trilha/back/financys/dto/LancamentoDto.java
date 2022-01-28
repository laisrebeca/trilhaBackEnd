package trilha.back.financys.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import trilha.back.financys.entities.CategoriaEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoDto {
    @NotNull @NotEmpty(message = "Preenchimento Obrigatório: Name")
    @Size(min = 3, max = 45, message = "O minimo é 3 e o maximo 45 Caracteres")
    private String name;

    @NotNull @NotEmpty(message = "Preenchimento Obrigatório: Description ")
    @Size(min = 15, max = 150, message = "O minimo é 15 e o maximo 150 Caracteres")
    private String description;

    @NotNull @NotEmpty(message = "Preenchimento Obrigatório: Type")
    @Size(min = 3, max = 10, message = "O minimo é 3 e o maximo 10 Caracteres")
    private String type;

    @NotNull @NotEmpty(message = "Preenchimento Obrigatório: Date")
    private String date;

    @NotNull(message = "Preenchimento Obrigatório: Amount")
    private Double amount;

    @NotNull(message = "Preenchimento Obrigatório: Paid")
    private Boolean paid;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    private CategoriaEntity categoryId;
}
