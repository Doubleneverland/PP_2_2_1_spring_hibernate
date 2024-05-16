package hiber.model;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private String series;

    public Car() {}

    public Car(String model, String series) {
        this.model = model;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, series);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return Objects.equals(id, car.id) &&
                Objects.equals(model, car.model) &&
                Objects.equals(series, car.series);
    }
}
