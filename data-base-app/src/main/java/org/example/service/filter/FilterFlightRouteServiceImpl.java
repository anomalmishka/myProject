package org.example.service.filter;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.flightRoute.FlightRouteCustomDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.FlightRoute;
import org.example.model.filter.FilterObj;
import org.example.service.filter.api.FilterFlightRouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilterFlightRouteServiceImpl implements FilterFlightRouteService {

    private final FlightRouteCustomDAO flightRouteCustomDAO;

    //**************************************1***************************************************

    @Override
    public List<FlightRoute> findWhereName(FilterObj filterObj) {
        if (filterObj.getAirCompanyName() != null) {
            return flightRouteCustomDAO.findWhereName(filterObj);
        } else {
            throw new ErrorInvalidData("AirCompanyName must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRouteStart(FilterObj filterObj) {
        if (filterObj.getRouteStart() != null) {
            return flightRouteCustomDAO.findWhereRouteStart(filterObj);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

    //**************************************2***************************************************

    @Override
    public List<FlightRoute> findWhereRoute(FilterObj filterObj) {
        if (filterObj.getRouteStart() != null) {
            return flightRouteCustomDAO.findWhereRoute(filterObj);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereDate(FilterObj filterObj) {
        if (filterObj.getDateStart() != null) {
            return flightRouteCustomDAO.findWhereDate(filterObj);
        } else {
            throw new ErrorInvalidData("DateStart must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWherePrice(FilterObj filterObj) {
        if (filterObj.getPriceEnd() != null) {
            return flightRouteCustomDAO.findWherePrice(filterObj);
        } else {
            throw new ErrorInvalidData("PriceEnd must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereDuration(FilterObj filterObj) {
        if (filterObj.getDurationEnd() != null) {
            return flightRouteCustomDAO.findWhereDuration(filterObj);
        } else {
            throw new ErrorInvalidData("DurationEnd must not be null");
        }
    }

    //**************************************3***************************************************

    @Override
    public List<FlightRoute> findWhereRouteName(FilterObj filterObj) {
        if (filterObj.getAirCompanyName() != null) {
            return flightRouteCustomDAO.findWhereRouteName(filterObj);
        } else {
            throw new ErrorInvalidData("AirCompanyName must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereDateName(FilterObj filterObj) {
        if (filterObj.getAirCompanyName() != null) {
            return flightRouteCustomDAO.findWhereDateName(filterObj);
        } else {
            throw new ErrorInvalidData("AirCompanyName must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWherePriceName(FilterObj filterObj) {
        if (filterObj.getAirCompanyName() != null) {
            return flightRouteCustomDAO.findWherePriceName(filterObj);
        } else {
            throw new ErrorInvalidData("AirCompanyName must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRouteTransfer(FilterObj filterObj) {
        if (filterObj.getTransfers() != null) {
            return flightRouteCustomDAO.findWhereRouteTransfer(filterObj);
        } else {
            throw new ErrorInvalidData("Transfers must not be null");
        }
    }

    //**************************************4***************************************************

    @Override
    public List<FlightRoute> findWhereRouteDate(FilterObj filterObj) {
        if (filterObj.getRouteStart() != null) {
            return flightRouteCustomDAO.findWhereRouteDate(filterObj);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRoutePrice(FilterObj filterObj) {
        if (filterObj.getRouteStart() != null) {
            return flightRouteCustomDAO.findWhereRoutePrice(filterObj);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRouteDuration(FilterObj filterObj) {
        if (filterObj.getRouteStart() != null) {
            return flightRouteCustomDAO.findWhereRouteDuration(filterObj);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereDatePrice(FilterObj filterObj) {
        if (filterObj.getDateStart() != null) {
            return flightRouteCustomDAO.findWhereDatePrice(filterObj);
        } else {
            throw new ErrorInvalidData("DateStart must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereDateDuration(FilterObj filterObj) {
        if (filterObj.getDateStart() != null) {
            return flightRouteCustomDAO.findWhereDateDuration(filterObj);
        } else {
            throw new ErrorInvalidData("DateStart must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWherePriceDuration(FilterObj filterObj) {
        if (filterObj.getPriceStart() != null) {
            return flightRouteCustomDAO.findWherePriceDuration(filterObj);
        } else {
            throw new ErrorInvalidData("PriceStart must not be null");
        }
    }

    //**************************************5***************************************************

    @Override
    public List<FlightRoute> findWhereRouteDateName(FilterObj filterObj) {
        if (filterObj.getAirCompanyName() != null) {
            return flightRouteCustomDAO.findWhereRouteDateName(filterObj);
        } else {
            throw new ErrorInvalidData("AirCompanyName must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRoutePriceName(FilterObj filterObj) {
        if (filterObj.getAirCompanyName() != null) {
            return flightRouteCustomDAO.findWhereRoutePriceName(filterObj);
        } else {
            throw new ErrorInvalidData("AirCompanyName must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRouteDurationName(FilterObj filterObj) {
        if (filterObj.getAirCompanyName() != null) {
            return flightRouteCustomDAO.findWhereRouteDurationName(filterObj);
        } else {
            throw new ErrorInvalidData("AirCompanyName must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereDatePriceName(FilterObj filterObj) {
        if (filterObj.getAirCompanyName() != null) {
            return flightRouteCustomDAO.findWhereDatePriceName(filterObj);
        } else {
            throw new ErrorInvalidData("AirCompanyName must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereDateDurationName(FilterObj filterObj) {
        if (filterObj.getAirCompanyName() != null) {
            return flightRouteCustomDAO.findWhereDateDurationName(filterObj);
        } else {
            throw new ErrorInvalidData("AirCompanyName must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWherePriceDurationName(FilterObj filterObj) {
        if (filterObj.getAirCompanyName() != null) {
            return flightRouteCustomDAO.findWherePriceDurationName(filterObj);
        } else {
            throw new ErrorInvalidData("AirCompanyName must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRouteDateTransfer(FilterObj filterObj) {
        if (filterObj.getTransfers() != null) {
            return flightRouteCustomDAO.findWhereRouteDateTransfer(filterObj);
        } else {
            throw new ErrorInvalidData("Transfers must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRoutePriceTransfer(FilterObj filterObj) {
        if (filterObj.getTransfers() != null) {
            return flightRouteCustomDAO.findWhereRoutePriceTransfer(filterObj);
        } else {
            throw new ErrorInvalidData("Transfers must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRouteDurationTransfer(FilterObj filterObj) {
        if (filterObj.getTransfers() != null) {
            return flightRouteCustomDAO.findWhereRouteDurationTransfer(filterObj);
        } else {
            throw new ErrorInvalidData("Transfers must not be null");
        }
    }

    //**************************************6***************************************************

    @Override
    public List<FlightRoute> findWhereRouteDatePrice(FilterObj filterObj) {
        if (filterObj.getRouteStart() != null) {
            return flightRouteCustomDAO.findWhereRouteDatePrice(filterObj);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRouteDateDuration(FilterObj filterObj) {
        if (filterObj.getRouteStart() != null) {
            return flightRouteCustomDAO.findWhereRouteDateDuration(filterObj);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRoutePriceDuration(FilterObj filterObj) {
        if (filterObj.getRouteStart() != null) {
            return flightRouteCustomDAO.findWhereRoutePriceDuration(filterObj);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereDatePriceDuration(FilterObj filterObj) {
        if (filterObj.getDateStart() != null) {
            return flightRouteCustomDAO.findWhereDatePriceDuration(filterObj);
        } else {
            throw new ErrorInvalidData("DateStart must not be null");
        }
    }

    //**************************************7***************************************************

    @Override
    public List<FlightRoute> findWhereRouteDatePriceName(FilterObj filterObj) {
        if (filterObj.getAirCompanyName() != null) {
            return flightRouteCustomDAO.findWhereRouteDatePriceName(filterObj);
        } else {
            throw new ErrorInvalidData("AirCompanyName must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRouteDateDurationName(FilterObj filterObj) {
        if (filterObj.getAirCompanyName() != null) {
            return flightRouteCustomDAO.findWhereRouteDateDurationName(filterObj);
        } else {
            throw new ErrorInvalidData("AirCompanyName must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRoutePriceDurationName(FilterObj filterObj) {
        if (filterObj.getAirCompanyName() != null) {
            return flightRouteCustomDAO.findWhereRoutePriceDurationName(filterObj);
        } else {
            throw new ErrorInvalidData("AirCompanyName must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereDatePriceDurationName(FilterObj filterObj) {
        if (filterObj.getAirCompanyName() != null) {
            return flightRouteCustomDAO.findWhereDatePriceDurationName(filterObj);
        } else {
            throw new ErrorInvalidData("AirCompanyName must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRouteDatePriceTransfer(FilterObj filterObj) {
        if (filterObj.getTransfers() != null) {
            return flightRouteCustomDAO.findWhereRouteDatePriceTransfer(filterObj);
        } else {
            throw new ErrorInvalidData("Transfers must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRouteDateDurationTransfer(FilterObj filterObj) {
        if (filterObj.getTransfers() != null) {
            return flightRouteCustomDAO.findWhereRouteDateDurationTransfer(filterObj);
        } else {
            throw new ErrorInvalidData("Transfers must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRoutePriceDurationTransfer(FilterObj filterObj) {
        if (filterObj.getTransfers() != null) {
            return flightRouteCustomDAO.findWhereRoutePriceDurationTransfer(filterObj);
        } else {
            throw new ErrorInvalidData("Transfers must not be null");
        }
    }

    //**************************************8***************************************************

    @Override
    public List<FlightRoute> findWhereRouteDatePriceDuration(FilterObj filterObj) {
        if (filterObj.getRouteStart() != null) {
            return flightRouteCustomDAO.findWhereRouteDatePriceDuration(filterObj);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

    //**************************************9***************************************************

    @Override
    public List<FlightRoute> findWhereRouteDatePriceDurationName(FilterObj filterObj) {
        if (filterObj.getRouteStart() != null) {
            return flightRouteCustomDAO.findWhereRouteDatePriceDurationName(filterObj);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

    @Override
    public List<FlightRoute> findWhereRouteDatePriceDurationTranfser(FilterObj filterObj) {
        if (filterObj.getTransfers() != null) {
            return flightRouteCustomDAO.findWhereRouteDatePriceDurationTranfser(filterObj);
        } else {
            throw new ErrorInvalidData("Transfers must not be null");
        }
    }

    //**************************************10**************************************************

    @Override
    public List<FlightRoute> findWhereRouteDatePriceDurationTranfserName(FilterObj filterObj) {
        if (filterObj.getTransfers() != null) {
            return flightRouteCustomDAO.findWhereRouteDatePriceDurationTranfserName(filterObj);
        } else {
            throw new ErrorInvalidData("Transfers must not be null");
        }
    }
}
