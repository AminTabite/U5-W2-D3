package amintabite.U5_W2_D3.Controllers;

import amintabite.U5_W2_D3.Entities.BlogPost;
import amintabite.U5_W2_D3.Payloads.NewBlogPayload;
import amintabite.U5_W2_D3.Services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/blogpost")
public class BlogpostController {

    @Autowired
    private BlogsService blogsService;

    @GetMapping
    public Page<BlogPost> getBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "4") int size,
            @RequestParam(defaultValue = "titolo") String sortBy) {
        return blogsService.findAll(page, size, sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost createBlogpost(@RequestBody NewBlogPayload body) {
        return blogsService.savesudb(body);
    }

    @GetMapping("/{blogid}")
    public BlogPost getBlogById(@PathVariable long blogid) {
        return blogsService.findById(blogid);
    }

    @PutMapping("/{blogid}")
    public BlogPost updateBlog(@PathVariable long blogid, @RequestBody NewBlogPayload body) {
        return blogsService.findByIdAndUpdate(blogid, body);
    }

    @DeleteMapping("/{blogid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlog(@PathVariable long blogid) {
        blogsService.findByIdAndDelete(blogid);
    }
}
