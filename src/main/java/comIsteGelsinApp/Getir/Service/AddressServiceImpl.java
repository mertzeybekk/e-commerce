package comIsteGelsinApp.Getir.Service;

import comIsteGelsinApp.Getir.Dto.Request.AddressRequest;
import comIsteGelsinApp.Getir.Dto.Response.AddressResponse;

import java.util.List;

public interface AddressServiceImpl {
    public String add(AddressRequest addressRequest);
    public String delete(int id);
    public String update(AddressRequest addressRequest,int id);
    public List<AddressResponse>getAll();
    public List<AddressResponse>getById(int id);
}
