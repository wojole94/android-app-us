package pl.studia.android.skyscanner.backend.db.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="search_parameters")
public class SearchParameters {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_user_account")
    UserAccount userAccount;

    @Column(name="fly_from")
    String flyFrom;
    @Column(name="fly_to")
    String flyTo;
//    @Column(name="date_from")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YYYY")
//    LocalDate dateFrom;
//    @Column(name="date_to")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YYYY")
//    LocalDate dateTo;
    @Column(name="direct_flights")
    Boolean directFlights;
    @Column
    Integer passengers;
    @Column
    Integer adults;
    @Column
    Integer children;
    @Column(name="price_to")
    Integer maximumPrice;
}
