package comIsteGelsinApp.Getir.Service;

import comIsteGelsinApp.Getir.Dto.Request.OrderRequest;
import comIsteGelsinApp.Getir.Dto.Response.OrderResponse;
import comIsteGelsinApp.Getir.Entity.Order;
import comIsteGelsinApp.Getir.Entity.Product;
import comIsteGelsinApp.Getir.Entity.UserInfo;
import comIsteGelsinApp.Getir.Mapper.ModelMapperService;
import comIsteGelsinApp.Getir.Repository.OrderRepository;
import comIsteGelsinApp.Getir.Repository.ProductRepository;
import comIsteGelsinApp.Getir.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService implements OrderServiceImpl{
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository, ModelMapperService modelMapperService) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public String add(OrderRequest orderRequest) {
        Optional<UserInfo>userInfo= Optional.of(this.userRepository.findById(orderRequest.getUserInfoId()).get());
        for (Integer productNumber:orderRequest.getProductId()) {
            Optional<Product> product = Optional.of(this.productRepository.findById((orderRequest.getProductId().get(productNumber-1).intValue())).get());
            if (product.isPresent()) {
                int Stock = product.get().getUnitInStock() - 1;
                product.get().setUnitInStock(Stock);
            }
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String todayString = today.format(formatter);
            Random rand = new Random();
            int orderNumber = rand.nextInt(10000) + 1;
            Order order = new Order();
            order.setUserInfo(userInfo.get());
            order.setProduct(product.get());
            order.setOrderDate(todayString);
            order.setTotalPrice((int) product.get().getUnitInPrice());
            order.setOrderNumber(orderNumber);
            this.orderRepository.save(order);
            this.productRepository.save(product.get());

        }

        return "succes";
    }

    @Override
    public String delete(int id) {
        this.orderRepository.deleteById(id);
        return "order success delete";
    }

    @Override
    public String update(OrderRequest orderRequest, int id) {
        return null;
    }

    @Override
    public List<OrderResponse> getAll() {
        List<Order>orderList=this.orderRepository.findAll();
        List<OrderResponse>orderResponses=orderList.stream().map(order -> this.modelMapperService.forResponse().map(order, OrderResponse.class)).collect(Collectors.toList());
        return orderResponses;
    }

    @Override
    public List<OrderResponse> getById(int id) {
        List<Order> userInfo=this.userRepository.findById(id).get().getOrders();
        List<OrderResponse>orderResponses=userInfo.stream().map(order -> this.modelMapperService.forResponse().map(order, OrderResponse.class)).collect(Collectors.toList());
        return orderResponses;
    }
}
