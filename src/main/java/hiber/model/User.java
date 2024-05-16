package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "first_name")
   private String firstName;

   @Column(name = "last_name")
   @GeneratedValue
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "cars_id")
   private Car empCar;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
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

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar() {
      return empCar;
   }

   public void setCar(Car car) {
      this.empCar = car;
   }

   @Override
   public String toString() {
      return "Id= " + getId() +
              "First Name= " + getFirstName() +
              "Last Name= " + getLastName() +
              "Email= " + getEmail() +
              " Car= " + getCar();
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      User user = (User) obj;
      return Objects.equals(id, user.id) &&
            Objects.equals(firstName, user.firstName) &&
            Objects.equals(lastName, user.lastName) &&
            Objects.equals(email, user.email) &&
            Objects.equals(empCar, user.empCar);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, firstName, lastName, email, empCar);
   }
}
