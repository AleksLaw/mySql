import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column (name = "model")
    private String model;
    @Column(name = "color")
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public Car() {
    }

    public Car(int id,String model, String color) {
        this.id = id;
        this.model = model;
        this.color = color;
    }

    public int getId() {
        return id;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
