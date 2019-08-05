

public class Main {
    public static void main(String[] args) throws Exception {
        Person person1 = new Person(1, "Alex", "Ivanov", 30);
        Person person2 = new Person(2, "Sveta", "Petrova", 23);
        Person person3 = new Person(3, "Ivan", "Sidorov", 30);
        PersonDAO personDAO = new PersonDAO();

        personDAO.addPerson(person1);
        personDAO.addPerson(person2);
        personDAO.addPerson(person3);

        personDAO.deletePerson(person1);

        Person getperson = personDAO.getPerson(3);
        System.out.println(getperson.getName() + " " + getperson.getLastname() + " " + getperson.getAge());


        person2.setName("Yiu");
        personDAO.updatePerson(person2);

    }
}
