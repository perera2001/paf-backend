package PAF.demo.service;

import PAF.demo.dto.PublicPostDTO;

import java.util.List;

public interface PublicPostService {
    String savePost(PublicPostDTO publicPostDTO);

    List<PublicPostDTO> getAllPosts();

    String updatPost(PublicPostDTO publicPostDTO);

    String deletePost(int id);
}
