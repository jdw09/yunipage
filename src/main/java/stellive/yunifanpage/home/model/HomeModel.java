package stellive.yunifanpage.home.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter

public class HomeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
}
