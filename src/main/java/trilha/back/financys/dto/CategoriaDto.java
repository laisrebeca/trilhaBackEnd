package trilha.back.financys.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import trilha.back.financys.entities.LancamentoEntity;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto {

    @NotNull
    @NotEmpty(message = "Preenchimento Obrigatório: Name")
    @Size(min = 3, max = 15, message = "O minimo é 3 e o maximo 15 Caracteres")
    private String name;

    @NotNull @NotEmpty(message = "Preenchimento Obrigatório: Description ")
    @Size(min = 15, max = 50, message = "O minimo é 15 e o maximo 50 Caracteres")
    private String description;

    @OneToMany(mappedBy = "categoryId")
    @JsonIgnore
    private List<LancamentoEntity> entries;



}