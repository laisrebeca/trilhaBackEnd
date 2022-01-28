package trilha.back.financys.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lancamentos")
public class LancamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date")
    private String date;

    @Column(name = "paid")
    private Boolean paid;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    private CategoriaEntity categoryId;

}
