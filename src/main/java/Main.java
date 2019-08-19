
public class Main {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        car1.setId(1);
        car1.setModel("BMW");
        car1.setColor("Green");

        car2.setId(2);
        car2.setModel("Ford");
        car2.setColor("Red");

        car3.setId(3);
        car3.setModel("Opel");
        car3.setColor("Black");

        System.out.println(car1.getModel());
        System.out.println(car2.getModel());
        System.out.println(car3.getModel());

        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        person1.setName("Sveta");
        person1.setLastname("Petrova");
        person1.setAge(23);
        person1.addCar(car1);

        person2.setName("Alex");
        person2.setLastname("Ivanov");
        person2.setAge(30);
        person2.addCar(car2);
        person2.addCar(car3);

        person3.setName("Ivan");
        person3.setLastname("Sidorov");
        person3.setAge(333);

        car1.setPerson(person1);
        car2.setPerson(person2);
        car3.setPerson(person2);

        PersonDAO personDAO = new PersonDAO();

        personDAO.addPerson(person1);
        personDAO.addPerson(person3);
        personDAO.addPerson(person2);

        personDAO.deletePerson(person1);

        Person getperson = personDAO.getPerson(0);

     //   getperson.getCar().forEach(car -> System.out.println(car.getModel() + " " + car.getColor()));
//        System.out.println(getperson.getName() + " " + getperson.getLastname() + " " + getperson.getAge());

        person2.setName("Yiu");
        personDAO.updatePerson(person2);

    }
}
