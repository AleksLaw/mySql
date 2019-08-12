
public class Main {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car(1, "BMW", "Green");
        Car car2 = new Car(2, "Ford", "Red");
        Car car3 = new Car(3, "Opel", "Black");
        Person person1 = new Person(1, "Alex", "Ivanov", 30);
        Person person2 = new Person(2, "Sveta", "Petrova", 23);
        Person person3 = new Person(3, "Ivan", "Sidorov", 30);

        car1.setPerson(person1);
        person1.addCar(car1);
        car2.setPerson(person2);
        person2.addCar(car2);
        car3.setPerson(person2);
        person2.addCar(car3);
        PersonDAO personDAO = new PersonDAO();

        personDAO.addPerson(person1);
        personDAO.addPerson(person2);
        personDAO.addPerson(person3);

        personDAO.deletePerson(person1);

        Person getperson = personDAO.getPerson(2);

        getperson.getCar().forEach(car -> System.out.println(car.getModel()+" "+car.getColor()));
        System.out.println(getperson.getName() + " " + getperson.getLastname() + " " + getperson.getAge());
//
//
        person2.setName("Yiu");
        personDAO.updatePerson(person2);

    }
}
