package trilha.back.financys.entities;

import lombok.*;
import trilha.back.financys.dto.LancamentoDto;

import javax.persistence.*;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lancamentos")
public class LancamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "type", nullable = false, length = 15)
    private String type;

    @Column(name = "amount", nullable = false)
    private String amount;

    @Column(name = "date", nullable = false, length = 10)
    private String date;

    @Column(name = "paid", nullable = false)
    private Boolean paid;


    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    private CategoriaEntity categoryId;


}
