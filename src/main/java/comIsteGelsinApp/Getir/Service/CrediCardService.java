package comIsteGelsinApp.Getir.Service;

import comIsteGelsinApp.Getir.Dto.Request.CrediCardRequest;
import comIsteGelsinApp.Getir.Dto.Response.CrediCardResponse;
import comIsteGelsinApp.Getir.Entity.CrediCard;
import comIsteGelsinApp.Getir.Entity.UserInfo;
import comIsteGelsinApp.Getir.Mapper.ModelMapperService;
import comIsteGelsinApp.Getir.Repository.CrediCardRepository;
import comIsteGelsinApp.Getir.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CrediCardService implements CrediCardImpl{
    private CrediCardRepository crediCardRepository;
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    public CrediCardService(CrediCardRepository crediCardRepository, UserRepository userRepository, ModelMapperService modelMapperService) {
        this.crediCardRepository = crediCardRepository;
        this.userRepository = userRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public String add(CrediCardRequest crediCardRequest) {
        Optional<UserInfo>userInfo=this.userRepository.findById(crediCardRequest.getUserInfoId());
        CrediCard card=new CrediCard();
        card.setUserInfo(userInfo.get());
        card.setCrediCardDate(crediCardRequest.getCrediCardDate());
        card.setCrediCardNumber(crediCardRequest.getCrediCardNumber());
        this.crediCardRepository.save(card);
        return "Credit card created for user";
    }

    @Override
    public String delete(int id) {
        this.crediCardRepository.deleteById(id);
        return "Credit card deleted for user";
    }

    @Override
    public String update(CrediCardRequest crediCardRequest, int id) {
        Optional<CrediCard>crediCard=this.crediCardRepository.findById(id);
        if (crediCard.isPresent()){
            crediCard.get().setCrediCardDate(crediCardRequest.getCrediCardDate());
            crediCard.get().setCrediCardNumber(crediCardRequest.getCrediCardNumber());
            this.crediCardRepository.save(crediCard.get());
        }
        return "Credit card updated for user";
    }

    @Override
    public List<CrediCardResponse> getAll() {
        int count=0;
        List<CrediCard>crediCards=this.crediCardRepository.findAll();
        List<CrediCardResponse>crediCardResponses=new ArrayList<>();
        Map<Integer,UserInfo>userInfoMap;
        for(CrediCard crediCard:crediCards){
            userInfoMap=new HashMap<>();
            CrediCardResponse crediCardResponse=new CrediCardResponse();
            crediCardResponse.setCrediCardDate(crediCard.getCrediCardDate());
            crediCardResponse.setCrediCardNumber(crediCard.getCrediCardNumber());
            userInfoMap.put(count,new UserInfo(crediCard.getUserInfo().getName(),crediCard.getUserInfo().getEmail()));
            crediCardResponse.setUserInfoList(userInfoMap);
           crediCardResponses.add(crediCardResponse);
        }
        return crediCardResponses;
    }

    @Override
    public List<CrediCardResponse> getById(int id) {
     Optional<CrediCard> crediCards=this.crediCardRepository.findById(id);
        List<CrediCardResponse>crediCardResponses=crediCards.stream().
                map(crediCard -> this.modelMapperService.forResponse().
                        map(crediCard,CrediCardResponse.class)).collect(Collectors.toList());
        return crediCardResponses;
    }
}
