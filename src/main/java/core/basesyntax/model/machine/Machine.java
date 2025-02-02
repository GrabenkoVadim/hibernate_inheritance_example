package core.basesyntax.model.machine;

import jakarta.persistence.*;

@Entity
@Table(name = "machines")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Machine {
    private int year;
    private String maker;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
