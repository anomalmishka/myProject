package org.example.service.filter.api;

import org.example.model.filter.PriceObj;


public interface PriceService {
    PriceObj getPriceWhereFlightRoute(PriceObj priceObj);
}
