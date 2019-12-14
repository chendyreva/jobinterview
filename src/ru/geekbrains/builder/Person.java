package ru.geekbrains.builder;


public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public Person(
            final FirstName newFirstName,
            final LastName newLastName,
            final MiddleName middleName,
            final Country country,
            final Main.Address address,
            final Phone phone,
            final Age age,
            final Gender gender) {
    }


    static class PersonBuilder {
        private FirstName firstName;
        private LastName lastName;
        private MiddleName middleName;
        private Country country;
        private Main.Address address;
        private Phone phone;
        private Age age;
        private Gender gender;


        public PersonBuilder addFirstName(FirstName firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder addLastName(LastName lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder addMiddleName(MiddleName middleName) {
            this.middleName = middleName;
            return this;
        }

        public PersonBuilder addCountry(Country country) {
            this.country = country;
            return this;
        }

        public PersonBuilder addAddress(Main.Address address) {
            this.address = address;
            return this;
        }

        public PersonBuilder addPhone(Phone phone) {
            this.phone = phone;
            return this;
        }

        public PersonBuilder addAge(Age age) {
            this.age = age;
            return this;
        }

        public PersonBuilder addGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Person createPerson() {
            return new Person(firstName, lastName, middleName, country, address, phone, age, gender);
        }
    }
}

