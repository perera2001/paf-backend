package PAF.demo.controller;


import PAF.demo.dto.PublicPostDTO;
import PAF.demo.entity.PublicPost;
import PAF.demo.service.PublicPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pubpost")
@CrossOrigin
public class PublicPostController {
@Autowired
    private PublicPostService publicPostService;
        @PostMapping(path = "/save")
    public String savePost(@RequestBody PublicPostDTO publicPostDTO){
              publicPostService.savePost(publicPostDTO);
             return "Saved";
        }


    @GetMapping(
            path = "/get-all-posts"
    )
    public List<PublicPostDTO> getAllCustomers(){

        List<PublicPostDTO> allPosts=publicPostService.getAllPosts();
        return allPosts;
    }

    @PutMapping("/update")
    public String updatePost(

            @RequestBody PublicPostDTO publicPostDTO
    ) {
        // Set the ID from the path
        return publicPostService.updatPost(publicPostDTO);
    }



    @DeleteMapping(path="/delete/{id}")
    public String deletePost(@PathVariable(value = "id") int id) {
        String delete =publicPostService.deletePost(id);
        return delete;
    }








}
