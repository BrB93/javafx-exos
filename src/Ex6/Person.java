package Ex6;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    //demander a l'utilisateur de rentrer les informations d'une personne
    public void askPerson() {
        System.out.println("Entrez le nom de la personne : ");
        this.lastName = new java.util.Scanner(System.in).nextLine();
        System.out.println("Entrez le prénom de la personne : ");
        this.firstName = new java.util.Scanner(System.in).nextLine();
        System.out.println("Entrez l'âge de la personne : ");
        this.age = new java.util.Scanner(System.in).nextInt();
    }

    //afficher les informations de la personne dans la liste
    public void displayPerson() {
        System.out.println("Nom : " + this.lastName);
        System.out.println("Prénom : " + this.firstName);
        System.out.println("Âge : " + this.age);
    }


    @Override
    public String toString() {
        return lastName + " " + firstName + ", " + age + " ans";
    }
}