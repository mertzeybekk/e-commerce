package comIsteGelsinApp.Getir.Controller;

import comIsteGelsinApp.Getir.Dto.Request.AddressRequest;
import comIsteGelsinApp.Getir.Dto.Response.AddressResponse;
import comIsteGelsinApp.Getir.Service.AddressService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AddressAdd")
public class AddressController {
    private AddressService addressService;
    public AddressController(AddressService addressService){
        this.addressService=addressService;
    }
    @PostMapping("/newAddAddress")

    public String addAddress(@RequestBody AddressRequest addressRequest){
       return this.addressService.add(addressRequest);
    }
    @GetMapping("/getAllAddress")

    public List<AddressResponse> addAddress(){
        return this.addressService.getAll();
    }
    @GetMapping("/getAllAddressById/{id}")

    public List<AddressResponse>getById(@PathVariable int id){
        return this.addressService.getById(id);
    }
    @DeleteMapping("/deleteById/{id}")

    public String deleteById(@PathVariable int id){
        return this.addressService.delete(id);
    }
}
