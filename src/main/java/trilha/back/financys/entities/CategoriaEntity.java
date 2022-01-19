package trilha.back.financys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
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
    private List<LançamentoEntity> entries;


    public CategoriaEntity(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LançamentoEntity> getEntries() {
        return entries;
    }

    public void setEntries(List<LançamentoEntity> entries) {
        this.entries = entries;
    }

    public CategoriaEntity() {

    }

        @Override
    public String toString() {
        return "Category { " +
                "id = " + id +
                ", name = " + name +
                ", description = " + description + " } \n";
    }
}