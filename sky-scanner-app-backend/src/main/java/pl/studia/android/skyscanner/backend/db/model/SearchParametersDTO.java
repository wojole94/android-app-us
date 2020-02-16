package pl.studia.android.skyscanner.backend.db.model;



import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name="search_parameters")
public class SearchParametersDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_user_account")
    UserAccountDTO userAccountDTO;

    @Column(name="fly_from")
    String flyFrom;
    @Column(name="fly_to")
    String flyTo;
    @Column(name="date_from")
    LocalDate dateFrom;
    @Column(name="date_to")
    LocalDate dateTo;
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
    @Column(name="only_weekends")
    Boolean onlyWeekends;
    @Column(name = "transfers_count")
    Integer transfersCount;
    @Column(name = "price")
    Double currentPrice;
    @Column(name = "departure_date")
    LocalDateTime exactDepartureDate;
    @Column(name = "arrival_date")
    LocalDateTime exactArrivalDate;
    @Column(name="deep_link", length = 15000)
    String deepLink;
    @Column(name = "real_transfers_number")
    Integer realTransfersNumber;
}
