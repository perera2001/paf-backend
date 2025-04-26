package PAF.demo.service.impl;

import PAF.demo.dto.PublicPostDTO;
import PAF.demo.entity.PublicPost;
import PAF.demo.repo.PublicPostRepo;
import PAF.demo.service.PublicPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicPostServiceIMPL implements PublicPostService {
    @Autowired
    private PublicPostRepo publicPostRepo;

    @Override
    public String savePost(PublicPostDTO publicPostDTO) {
        PublicPost publicPost = new PublicPost(
                publicPostDTO.getId(),
                publicPostDTO.getDescription(),
                publicPostDTO.getPhoto()
        );
        publicPostRepo.save(publicPost);
        return publicPostDTO.getDescription();

    }

    @Override
    public List<PublicPostDTO> getAllPosts() {
        List<PublicPost> getAllPosts = publicPostRepo.findAll();
        List<PublicPostDTO> allPostDTOList = new ArrayList<>();

        if (getAllPosts.size() > 0) {
            for (PublicPost publicPost : getAllPosts) {
                PublicPostDTO publicPostDTO = new PublicPostDTO(
                        publicPost.getId(),
                        publicPost.getDescription(),
                        publicPost.getPhoto()
                );
                allPostDTOList.add(publicPostDTO);
            }
            return allPostDTOList;
        } else {
            throw new RuntimeException("No MakeOrders found");
        }


    }

    @Override
    public String updatPost(PublicPostDTO publicPostDTO) {
        if (publicPostRepo.existsById(publicPostDTO.getId())) {
            PublicPost publicPost = publicPostRepo.getReferenceById(publicPostDTO.getId());

            publicPost.setDescription(publicPostDTO.getDescription());
            publicPost.setPhoto(publicPostDTO.getPhoto());
            publicPostRepo.save(publicPost);
            return publicPostDTO.getDescription() + "Updated";

        } else {
            throw new RuntimeException("No MakeOrder found");
        }

    }

    @Override
    public String deletePost(int id) {
        if(publicPostRepo.existsById(id)){
            publicPostRepo.deleteById(id);
            return id + " deleted";
        }else{
            throw new RuntimeException("No MakeOrder found");
        }

    }
}
