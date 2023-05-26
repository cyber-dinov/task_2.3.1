package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
@RequestMapping(value = { "/cars", "/cars?count="})
public class CarController {

    private final CarService carServiceImp;

    public CarController(CarService carServiceImp) {
        this.carServiceImp = carServiceImp;
    }


    @GetMapping()
    public String getCountCars(@RequestParam(value = "count", required = false) Integer count , Model model){

        model.addAttribute("countcars", carServiceImp.getCarsFromList(carServiceImp.getCarList(), count));
        return "cars";

    }


}
