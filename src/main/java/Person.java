
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="person")
public class Person {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue
    @GenericGenerator(name = "id",strategy = "increment")
    @Column (name="id")
    private int id;
    @Column (name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars= new ArrayList<>();

    public Person() {
    }


    public void addCar(Car car) {
        cars.add(car);
        car.setPerson(this);

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
