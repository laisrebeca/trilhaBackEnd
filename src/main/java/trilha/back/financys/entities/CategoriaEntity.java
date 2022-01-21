package trilha.back.financys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import trilha.back.financys.DTO.CategoriaDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "categoroias")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    @Column(name= "id", nullable= false)
    private Long id;


    @Column(name= "name", nullable = false)
    private String name;


    @Column(name= "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "categoryId")
    @JsonIgnore
    private List<LancamentoEntity> entries;


    public CategoriaDTO transformaEmDTO(CategoriaEntity entity) {
        return new CategoriaDTO(entity.getName(), entity.getDescription());
    }

}