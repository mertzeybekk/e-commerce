package comIsteGelsinApp.Getir.Controller;

import comIsteGelsinApp.Getir.Dto.Request.CrediCardRequest;
import comIsteGelsinApp.Getir.Dto.Response.CrediCardResponse;
import comIsteGelsinApp.Getir.Service.CrediCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crediCard")
public class CrediCardController {
    private CrediCardService crediCardService;
    public CrediCardController(CrediCardService crediCardService){
        this.crediCardService=crediCardService;
    }
    @PostMapping("/newAddCrediCard")
    public String addCrediCard(@RequestBody CrediCardRequest crediCardRequest){
        return this.crediCardService.add(crediCardRequest);
    }
    @GetMapping("/getAllCrediCard")
    public List<CrediCardResponse>getAllCrediCard(){
        return this.crediCardService.getAll();
    }
}
