package ua.kpi.tef.demo_ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.kpi.tef.demo_ticket.entity.Hotel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Optional<Hotel> findHotelById(Long id);

    @Query(nativeQuery = true, value ="select * from hotel where city = :city " +
            "and departure_date = :departureDate and arrival_date = :arrivalDate and apartment_type = :apartmentType")
    List<Hotel> findByAllParameters(@Param("city") String city,
                                                          @Param("departureDate") LocalDate departureDate,
                                                          @Param("arrivalDate") LocalDate arrivalDate,
                                                          @Param("apartmentType") String apartmentType);

    /*@Query(nativeQuery = true, value ="select * from trip where from_where = :fromWhere and where_to= :whereTo " +
            "and departure_date = :departureDate and arrival_date = :arrivalDate")
    List<Hotel> findByFromWhereAndWhereToAndDepartureDateAndArrivalDate(@Param("fromWhere") String fromWhere,
                                                                       @Param("whereTo") String whereTo,
                                                                       @Param("departureDate") LocalDate departureDate,
                                                                       @Param("arrivalDate") LocalDate arrivalDate);*/
}
