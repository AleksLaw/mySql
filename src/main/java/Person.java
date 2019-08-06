
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="person")
public class Person {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private int id;
    @Column (name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;

    public Person() {
    }

    public Person(int id,String name, String lastname, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        cars = new ArrayList<>();

    }

    public void addCar(Car car) {
        car.setPerson(this);
        cars.add(car);
    }

    public void removeAuto(Car car) {
        cars.remove(car);
    }


    public List<Car> getCar() {
        return cars;
    }

    public void setAutos(List<Car> cars) {
        this.cars = cars;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
