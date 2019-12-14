package main.java.Builder;

class Main {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .addFirstName(new FirstName())
                .addLastName(new LastName())
                .addMiddleName(new MiddleName())
                .addCountry(new Country())
                .addAddress(new Address())
                .addPhone(new Phone())
                .addAge(new Age())
                .addGender(new Gender())
                .createPerson();

    }

    public static class Address{}
}
