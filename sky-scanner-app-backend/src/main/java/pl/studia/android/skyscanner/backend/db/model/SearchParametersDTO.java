package pl.studia.android.skyscanner.backend.db.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="search_parameters")
public class SearchParametersDTO {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    Integer currentPrice;
    @Column(name = "departure_date")
    LocalDateTime exactDepartureDate;
    @Column(name = "arrival_date")
    LocalDateTime exactArrivalDate;


}
