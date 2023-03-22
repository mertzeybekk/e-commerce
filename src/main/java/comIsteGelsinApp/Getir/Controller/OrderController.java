package comIsteGelsinApp.Getir.Controller;

import comIsteGelsinApp.Getir.Dto.Request.OrderRequest;
import comIsteGelsinApp.Getir.Dto.Response.OrderResponse;
import comIsteGelsinApp.Getir.Service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }
    @PostMapping("/addNewOrder")
    public String addOrder(@RequestBody OrderRequest orderRequest){
        return this.orderService.add(orderRequest);
    }
    @GetMapping("/getAllOrder")
    public List<OrderResponse>getAll(){
        return this.orderService.getAll();
    }
    @GetMapping("/getByIdOrder/{id}")
    public List<OrderResponse>getByIdOrder(@PathVariable int id){
        return this.orderService.getById(id);
    }
}
