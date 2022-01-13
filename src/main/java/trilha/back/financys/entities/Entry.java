package trilha.back.financys.entities;

public class Entry {
    private Long id;
    private Long categoryId;
    private String name;
    private String description;
    private String type;
    private String amount;
    private String date;
    private Boolean paid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public Entry(Long id, long categoryId, String name, String description, String type,
                 String amount, String date, Boolean paid) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
    }

    public Entry() {
    }

    @Override
    public String toString() {
        return "Entry { " + "id = " + id +
                ", categoryId = " + categoryId +
                ", name = " + name +
                ", description = " + description +
                ", type = " + type +
                ", amount = " + amount +
                ", date = " + date +
                ", paid = " + paid + " } \n";
    }

}