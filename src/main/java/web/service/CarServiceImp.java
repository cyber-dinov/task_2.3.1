package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImp implements CarService {

    public List<Car> carList = new ArrayList<>();

    {
        carList.add(new Car("model1", "series1", 111));
        carList.add(new Car("model2", "series2", 222));
        carList.add(new Car("model3", "series3", 333));
        carList.add(new Car("model4", "series4", 444));
        carList.add(new Car("model5", "series5", 555));

    }

    public List<Car> getCarList() {
        return carList;
    }

    @Override
    public List<Car> getCarsFromList(List<Car> list, Integer count) {

        List<Car> carList = new ArrayList<>();

        if (count == null || count >= 5){
            return list;
        }

        for (int i = 0; i < count; i++){
            carList.add(list.get(i));
        }

        return carList;
    }
}