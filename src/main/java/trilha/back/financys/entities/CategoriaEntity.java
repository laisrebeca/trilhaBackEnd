package trilha.back.financys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categoroias")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id")
    private Long id;

    @Column(name= "name")
    private String name;

    @Column(name= "description")
    private String description;

    @OneToMany(mappedBy = "categoryId")
    @JsonIgnore
    private List<LancamentoEntity> entries;

}