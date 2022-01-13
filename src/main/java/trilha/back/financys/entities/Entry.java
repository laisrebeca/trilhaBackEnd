package trilha.back.financys.entities;

import javax.persistence.*;


@Entity
@Table(name = "ENTRY")
public class Entry  {

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
    @JoinColumn(name = "category", referencedColumnName = "id")
    private Category category;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Entry(Long id, String name, String description, String type,
                 String amount, String date, Boolean paid, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
        this.category = category;

    }

    public Entry() {
    }

    @Override
    public String toString() {
        return "Entry { " + "id = " + id +
                ", name = " + name +
                ", description = " + description +
                ", type = " + type +
                ", amount = " + amount +
                ", date = " + date +
                ", paid = " + paid + " } \n";
    }

}
