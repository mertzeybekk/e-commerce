package comIsteGelsinApp.Getir.Service;

import comIsteGelsinApp.Getir.Dto.Request.AddressRequest;
import comIsteGelsinApp.Getir.Dto.Response.AddressResponse;
import comIsteGelsinApp.Getir.Entity.Address;
import comIsteGelsinApp.Getir.Entity.UserInfo;
import comIsteGelsinApp.Getir.Mapper.ModelMapperService;
import comIsteGelsinApp.Getir.Repository.AddressRepository;
import comIsteGelsinApp.Getir.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AddressService implements AddressServiceImpl{
    private AddressRepository addressRepository;
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    public AddressService(AddressRepository addressRepository, UserRepository userRepository, ModelMapperService modelMapperService) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public String add(AddressRequest addressRequest) {
        Optional<UserInfo>userInfo=this.userRepository.findById(addressRequest.getUserInfoId());
        Address address=new Address();
        address.setUserInfo(userInfo.get());
        address.setBuildingName(addressRequest.getBuildingName());
        address.setCity(addressRequest.getCity());
        address.setDistrict(addressRequest.getDistrict());
        address.setBuildingNumber(addressRequest.getBuildingNumber());
        address.setCreatedDate(addressRequest.getCreatedDate());
        this.addressRepository.save(address);
        return "User address succes be added";
    }

    @Override
    public String delete(int id) {
       this.addressRepository.deleteById(id);
        return "User address succes be deleted";
    }

    @Override
    public String update(AddressRequest addressRequest, int id) {
      Optional<Address>address= Optional.of(this.addressRepository.findById(id).get());
      if(address.isPresent()){
         address.get().setBuildingNumber(addressRequest.getBuildingNumber());
         address.get().setDistrict(addressRequest.getDistrict());
         address.get().setPostalCode(addressRequest.getPostalCode());
         this.addressRepository.save(address.get());

      }
        return "User address succes be updated";
    }

    @Override
    public List<AddressResponse> getAll() {
        List<Address>addressList=this.addressRepository.findAll();
        List<AddressResponse>addressResponses=addressList.stream().map(address -> this.modelMapperService.forResponse().map(address,AddressResponse.class)).collect(Collectors.toList());
        return addressResponses;
    }

    @Override
    public List<AddressResponse> getById(int id) {
        List<Address> userInfos=this.userRepository.findById(id).get().getAddress();
        List<AddressResponse>addressResponses=userInfos.stream().map(address -> this.modelMapperService.forResponse().map(address, AddressResponse.class)).collect(Collectors.toList());
        return addressResponses;
    }
}
