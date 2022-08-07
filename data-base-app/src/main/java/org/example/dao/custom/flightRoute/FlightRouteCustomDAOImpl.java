package org.example.dao.custom.flightRoute;

import lombok.RequiredArgsConstructor;
import org.example.model.*;
import org.example.dto.filter.FilterObj;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
@Repository
@Transactional
public class FlightRouteCustomDAOImpl implements FlightRouteCustomDAO {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<FlightRoute> filter(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        String airCompanyName = filterObj.getAirCompanyName();
        Integer price = filterObj.getPrice();
        Integer duration = filterObj.getDuration();
        String transfer = filterObj.getTransfer();
        Predicate predicateA = criteriaBuilder.like(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateB = criteriaBuilder.like(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateC = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateD = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicateE = criteriaBuilder.like(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        Predicate predicateF = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), price);
        Predicate predicateG = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.duration), duration);
        Predicate predicateHStart1 = criteriaBuilder.like(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateHEnd1 = criteriaBuilder.like(root.get(FlightRoute_.routeEnd), transfer);
        Predicate predicateH1 = criteriaBuilder.and(predicateHStart1, predicateHEnd1);
        Predicate predicateHStart2 = criteriaBuilder.like(root.get(FlightRoute_.routeStart), transfer);
        Predicate predicateHEnd2 = criteriaBuilder.like(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateH2 = criteriaBuilder.and(predicateHStart2, predicateHEnd2);
        Predicate predicateH = criteriaBuilder.or(predicateH1, predicateH2);
        Predicate predicate1 = criteriaBuilder.or(
                predicateA,
                predicateB,
                predicateC,
                predicateD,
                predicateE,
                predicateF,
                predicateG
        );
        Predicate predicateAB = criteriaBuilder.and(predicateA, predicateB);
        Predicate predicateAC = criteriaBuilder.and(predicateA, predicateC);
        Predicate predicateAD = criteriaBuilder.and(predicateA, predicateD);
        Predicate predicateAE = criteriaBuilder.and(predicateA, predicateE);
        Predicate predicateAF = criteriaBuilder.and(predicateA, predicateF);
        Predicate predicateAG = criteriaBuilder.and(predicateA, predicateG);
        Predicate predicateBC = criteriaBuilder.and(predicateB, predicateC);
        Predicate predicateBD = criteriaBuilder.and(predicateB, predicateD);
        Predicate predicateBE = criteriaBuilder.and(predicateB, predicateE);
        Predicate predicateBF = criteriaBuilder.and(predicateB, predicateF);
        Predicate predicateBG = criteriaBuilder.and(predicateB, predicateG);
        Predicate predicateCD = criteriaBuilder.and(predicateC, predicateD);
        Predicate predicateCE = criteriaBuilder.and(predicateC, predicateE);
        Predicate predicateCF = criteriaBuilder.and(predicateC, predicateF);
        Predicate predicateCG = criteriaBuilder.and(predicateC, predicateG);
        Predicate predicateDE = criteriaBuilder.and(predicateD, predicateE);
        Predicate predicateDF = criteriaBuilder.and(predicateD, predicateF);
        Predicate predicateDG = criteriaBuilder.and(predicateD, predicateG);
        Predicate predicateEF = criteriaBuilder.and(predicateE, predicateF);
        Predicate predicateEG = criteriaBuilder.and(predicateE, predicateG);
        Predicate predicateFG = criteriaBuilder.and(predicateF, predicateG);
        Predicate predicate2 = criteriaBuilder.or(
                predicateAB,
                predicateAC,
                predicateAD,
                predicateAE,
                predicateAF,
                predicateAG,
                predicateBC,
                predicateBD,
                predicateBE,
                predicateBF,
                predicateBG,
                predicateCD,
                predicateCE,
                predicateCF,
                predicateCG,
                predicateDE,
                predicateDF,
                predicateDG,
                predicateEF,
                predicateEG,
                predicateFG
        );
        Predicate predicateABC = criteriaBuilder.and(predicateAB, predicateC);
        Predicate predicateABD = criteriaBuilder.and(predicateAB, predicateD);
        Predicate predicateABE = criteriaBuilder.and(predicateAB, predicateE);
        Predicate predicateABF = criteriaBuilder.and(predicateAB, predicateF);
        Predicate predicateABG = criteriaBuilder.and(predicateAB, predicateG);
        Predicate predicateABH = criteriaBuilder.or(predicateAB, predicateH);
        Predicate predicateACD = criteriaBuilder.and(predicateAC, predicateD);
        Predicate predicateACE = criteriaBuilder.and(predicateAC, predicateE);
        Predicate predicateACF = criteriaBuilder.and(predicateAC, predicateG);
        Predicate predicateADE = criteriaBuilder.and(predicateAD, predicateE);
        Predicate predicateADF = criteriaBuilder.and(predicateAD, predicateF);
        Predicate predicateADG = criteriaBuilder.and(predicateAD, predicateG);
        Predicate predicateAEF = criteriaBuilder.and(predicateAE, predicateF);
        Predicate predicateAEG = criteriaBuilder.and(predicateAE, predicateG);
        Predicate predicateAFG = criteriaBuilder.and(predicateAF, predicateG);
        Predicate predicateBCD = criteriaBuilder.and(predicateBC, predicateD);
        Predicate predicateBCE = criteriaBuilder.and(predicateBC, predicateE);
        Predicate predicateBCF = criteriaBuilder.and(predicateBC, predicateF);
        Predicate predicateBCG = criteriaBuilder.and(predicateBC, predicateG);
        Predicate predicateBDE = criteriaBuilder.and(predicateBD, predicateE);
        Predicate predicateBDF = criteriaBuilder.and(predicateBD, predicateF);
        Predicate predicateBDG = criteriaBuilder.and(predicateBD, predicateG);
        Predicate predicateBEF = criteriaBuilder.and(predicateBE, predicateF);
        Predicate predicateBEG = criteriaBuilder.and(predicateBE, predicateG);
        Predicate predicateBFG = criteriaBuilder.and(predicateBF, predicateG);
        Predicate predicateCDE = criteriaBuilder.and(predicateCD, predicateE);
        Predicate predicateCDF = criteriaBuilder.and(predicateCD, predicateF);
        Predicate predicateCDG = criteriaBuilder.and(predicateCD, predicateG);
        Predicate predicateCEF = criteriaBuilder.and(predicateCE, predicateF);
        Predicate predicateCEG = criteriaBuilder.and(predicateCE, predicateG);
        Predicate predicateCFG = criteriaBuilder.and(predicateCE, predicateG);
        Predicate predicateDEF = criteriaBuilder.and(predicateDE, predicateF);
        Predicate predicateDEG = criteriaBuilder.and(predicateDE, predicateG);
        Predicate predicateDFG = criteriaBuilder.and(predicateDF, predicateG);
        Predicate predicateEFG = criteriaBuilder.and(predicateEF, predicateG);
        Predicate predicate3 = criteriaBuilder.or(
                predicateABC,
                predicateABD,
                predicateABE,
                predicateABF,
                predicateABG,
                predicateABH,
                predicateACD,
                predicateACE,
                predicateACF,
                predicateADE,
                predicateADF,
                predicateADG,
                predicateAEF,
                predicateAEG,
                predicateAFG,
                predicateBCD,
                predicateBCE,
                predicateBCF,
                predicateBCG,
                predicateBDE,
                predicateBDF,
                predicateBDG,
                predicateBEF,
                predicateBEG,
                predicateBFG,
                predicateCDE,
                predicateCDF,
                predicateCDG,
                predicateCEF,
                predicateCEG,
                predicateCFG,
                predicateDEF,
                predicateDEG,
                predicateDFG,
                predicateEFG
        );
        Predicate predicateABCD = criteriaBuilder.and(predicateABC, predicateD);
        Predicate predicateABCE = criteriaBuilder.and(predicateABC, predicateE);
        Predicate predicateABCF = criteriaBuilder.and(predicateABC, predicateF);
        Predicate predicateABCG = criteriaBuilder.and(predicateABC, predicateG);
        Predicate predicateABCH = criteriaBuilder.or(predicateABC, predicateH);
        Predicate predicateABDE = criteriaBuilder.and(predicateABD, predicateE);
        Predicate predicateABDF = criteriaBuilder.and(predicateABD, predicateF);
        Predicate predicateABDG = criteriaBuilder.and(predicateABD, predicateG);
        Predicate predicateABDH = criteriaBuilder.or(predicateABD, predicateH);
        Predicate predicateACDE = criteriaBuilder.and(predicateACD, predicateE);
        Predicate predicateACDF = criteriaBuilder.and(predicateACD, predicateF);
        Predicate predicateACDG = criteriaBuilder.and(predicateACD, predicateG);
        Predicate predicateABEF = criteriaBuilder.and(predicateABE, predicateF);
        Predicate predicateABEG = criteriaBuilder.and(predicateABE, predicateG);
        Predicate predicateABEH = criteriaBuilder.or(predicateABE, predicateH);
        Predicate predicateADEF = criteriaBuilder.and(predicateADE, predicateF);
        Predicate predicateADEG = criteriaBuilder.and(predicateADE, predicateG);
        Predicate predicateABFG = criteriaBuilder.and(predicateABF, predicateG);
        Predicate predicateABFH = criteriaBuilder.or(predicateABF, predicateH);
        Predicate predicateAEFG = criteriaBuilder.and(predicateAEF, predicateG);
        Predicate predicateABGH = criteriaBuilder.and(predicateAEF, predicateG);
        Predicate predicateBCDE = criteriaBuilder.and(predicateBCD, predicateE);
        Predicate predicateBCDF = criteriaBuilder.and(predicateBCD, predicateF);
        Predicate predicateBCDG = criteriaBuilder.and(predicateBCD, predicateG);
        Predicate predicateBDEF = criteriaBuilder.and(predicateBDE, predicateF);
        Predicate predicateBDEG = criteriaBuilder.and(predicateBDE, predicateG);
        Predicate predicateBEFG = criteriaBuilder.and(predicateBEF, predicateG);
        Predicate predicateCDEF = criteriaBuilder.and(predicateCDE, predicateF);
        Predicate predicateCDEG = criteriaBuilder.and(predicateCDE, predicateG);
        Predicate predicateCEFG = criteriaBuilder.and(predicateCEF, predicateG);
        Predicate predicate4 = criteriaBuilder.or(
                predicateABCD,
                predicateABCE,
                predicateABCF,
                predicateABCG,
                predicateABCH,
                predicateABDE,
                predicateABDF,
                predicateABDG,
                predicateABDH,
                predicateACDE,
                predicateACDF,
                predicateACDG,
                predicateABEF,
                predicateABEG,
                predicateABEH,
                predicateADEF,
                predicateADEG,
                predicateABFG,
                predicateABFH,
                predicateAEFG,
                predicateABGH,
                predicateBCDE,
                predicateBCDF,
                predicateBCDG,
                predicateBDEF,
                predicateBDEG,
                predicateBEFG,
                predicateCDEF,
                predicateCDEG,
                predicateCEFG
        );
        Predicate predicateABCDE = criteriaBuilder.and(predicateABCD, predicateE);
        Predicate predicateABCDF = criteriaBuilder.and(predicateABCD, predicateF);
        Predicate predicateABCDG = criteriaBuilder.and(predicateABCD, predicateF);
        Predicate predicateABCDH = criteriaBuilder.or(predicateABCD, predicateH);
        Predicate predicateABCEF = criteriaBuilder.and(predicateABCE, predicateF);
        Predicate predicateABCEG = criteriaBuilder.and(predicateABCE, predicateG);
        Predicate predicateABCEH = criteriaBuilder.or(predicateABCE, predicateH);
        Predicate predicateABCFG = criteriaBuilder.and(predicateABCF, predicateG);
        Predicate predicateABCFH = criteriaBuilder.or(predicateABCF, predicateH);
        Predicate predicateABCGH = criteriaBuilder.or(predicateABCG, predicateH);
        Predicate predicateABDEF = criteriaBuilder.and(predicateABDE, predicateF);
        Predicate predicateABDEG = criteriaBuilder.and(predicateABDE, predicateG);
        Predicate predicateABDEH = criteriaBuilder.or(predicateABDE, predicateH);
        Predicate predicateABDFG = criteriaBuilder.and(predicateABDF, predicateG);
        Predicate predicateABDFH = criteriaBuilder.or(predicateABDF, predicateH);
        Predicate predicateABDGH = criteriaBuilder.or(predicateABDG, predicateH);
        Predicate predicateABEFG = criteriaBuilder.and(predicateABEF, predicateG);
        Predicate predicateABEFH = criteriaBuilder.or(predicateABEF, predicateH);
        Predicate predicateABFGH = criteriaBuilder.or(predicateABFG, predicateH);
        Predicate predicateACDEF = criteriaBuilder.and(predicateACDE, predicateF);
        Predicate predicateACDEG = criteriaBuilder.and(predicateACDE, predicateG);
        Predicate predicateACDFG = criteriaBuilder.and(predicateACDF, predicateG);
        Predicate predicateADEFG = criteriaBuilder.and(predicateADEF, predicateG);
        Predicate predicateBCDEF = criteriaBuilder.and(predicateBCDE, predicateF);
        Predicate predicateBCDEG = criteriaBuilder.and(predicateBCDE, predicateG);
        Predicate predicateBDEFG = criteriaBuilder.and(predicateBDEF, predicateG);
        Predicate predicateCDEFG = criteriaBuilder.and(predicateCDEF, predicateG);
        Predicate predicate5 = criteriaBuilder.or(
                predicateABCDE,
                predicateABCDF,
                predicateABCDG,
                predicateABCDH,
                predicateABCEF,
                predicateABCEG,
                predicateABCEH,
                predicateABCFG,
                predicateABCFH,
                predicateABCGH,
                predicateABDEF,
                predicateABDEG,
                predicateABDEH,
                predicateABDFG,
                predicateABDFH,
                predicateABDGH,
                predicateABEFG,
                predicateABEFH,
                predicateABFGH,
                predicateACDEF,
                predicateACDEG,
                predicateACDFG,
                predicateADEFG,
                predicateBCDEF,
                predicateBCDEG,
                predicateBDEFG,
                predicateCDEFG
        );
        Predicate predicateABCDEF = criteriaBuilder.and(predicateABCDE, predicateF);
        Predicate predicateABCDEG = criteriaBuilder.and(predicateABCDE, predicateG);
        Predicate predicateABCDEH = criteriaBuilder.or(predicateABCDE, predicateH);
        Predicate predicateACDEFG = criteriaBuilder.and(predicateACDEF, predicateG);
        Predicate predicateBCDEFG = criteriaBuilder.and(predicateBCDEF, predicateG);
        Predicate predicate6 = criteriaBuilder.or(
                predicateABCDEF,
                predicateABCDEG,
                predicateABCDEH,
                predicateACDEFG,
                predicateBCDEFG
        );
        Predicate predicateABCDEFG = criteriaBuilder.and(predicateABCDEF, predicateG);
        Predicate predicateABCDEFH = criteriaBuilder.or(predicateABCDEF, predicateH);
        Predicate predicate7 = criteriaBuilder.or(predicateABCDEFG, predicateABCDEFH);
        Predicate predicate8 = criteriaBuilder.or(predicateABCDEFG, predicateH);
        Field[] declaredFields = FilterObj.class.getDeclaredFields();
        int count = 0;
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                if (field.get(filterObj) != null) {
                    count++;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        switch (count) {
            case 1:
                query.where(predicate1).distinct(true);
                break;
            case 2:
                query.where(predicate2).distinct(true);
                break;
            case 3:
                query.where(predicate3).distinct(true);
                break;
            case 4:
                query.where(predicate4).distinct(true);
                break;
            case 5:
                query.where(predicate5).distinct(true);
                break;
            case 6:
                query.where(predicate6).distinct(true);
                break;
            case 7:
                query.where(predicate7).distinct(true);
                break;
            case 8:
                query.where(predicate8).distinct(true);
                break;
            default:
                query.select(root).distinct(true);
                break;
        }
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Predicate predicate = criteriaBuilder.equal(root.get(FlightRoute_.id), id);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }
}
