package comIsteGelsinApp.Getir.Service;

import comIsteGelsinApp.Getir.Dto.Request.CrediCardRequest;
import comIsteGelsinApp.Getir.Dto.Response.CrediCardResponse;

import java.util.List;

public interface CrediCardImpl {
    public String add(CrediCardRequest crediCardRequest);
    public String delete(int id);
    public String update(CrediCardRequest crediCardRequest,int id);
    public List<CrediCardResponse>getAll();
    public List<CrediCardResponse>getById(int id);
}
