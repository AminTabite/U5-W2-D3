package amintabite.U5_W2_D3.Controllers;


import amintabite.U5_W2_D3.Entities.BlogPost;
import amintabite.U5_W2_D3.Payloads.NewBlogPayload;
import amintabite.U5_W2_D3.Services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogpost")

public class BlogpostController {

    @Autowired
    private BlogsService blogsService;




    // 1 get http://localhost:5000/blogpost
    @GetMapping
    public List<BlogPost> getBlogs(){

        return this.blogsService.findAll();

    }


    // 2 post http://localhost:8080/b   logpost
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost createBlogpost(@RequestBody NewBlogPayload body) {
        return blogsService.savesudb(body);
    }


    //3 get http://localhost:8080/blogpost/{blogid}

    @GetMapping("/{blogid}")
    public BlogPost getBlogId(@PathVariable long blogid){
        return blogsService.findById(blogid);

    }


    //4 put http://localhost:5000/blogpost/{blogid}

    @PutMapping("/blogid")
    public BlogPost getBlogByIdAndUpdate(@PathVariable long blogid, @RequestBody NewBlogPayload body){
        return this.blogsService.findByIdAndUpdate(blogid, body);
    }


    //5 delete  public void findByIdAndDelete(long blogid)

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getBlogByIdAndDelete(@PathVariable long blogid) {
        this.blogsService.findByIdAndDelete(blogid);
    }

}
