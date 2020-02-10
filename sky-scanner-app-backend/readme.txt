Android request:
POST http://localhost:8080/flight/getBestPriceFlight
    JSON body:
    {
      "city_from": "KTW",
      "city_to": "WAW",
      "search_start_date": "2020-06-15",
      "search_end_date": "2020-09-16",
      "transfers_number": 2,
      "adults_number": 2,
      "children_number": 0,
      "maximum_price": 380,
      "only_weekend_flights": false
    }


    response:
    {
        "city_from": "Katowice",
        "city_to": "Warszawa",
        "price": 294,
        "departure_date": "2020-08-31 16:15:00",
        "arrival_date": "2020-08-31 17:10:00"
    }