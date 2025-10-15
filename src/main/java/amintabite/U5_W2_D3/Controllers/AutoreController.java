package amintabite.U5_W2_D3.Controllers;

import amintabite.U5_W2_D3.Entities.Autore;
import amintabite.U5_W2_D3.Payloads.NewAutorePayload;
import amintabite.U5_W2_D3.Services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autori")

public class AutoreController {

    @Autowired
    private AutoreService autoreService;




    // 1 get http://localhost:5000/autore
    @GetMapping
    public List<Autore> getAutori(){

        return this.autoreService.findAll();

    }


    // 2 post http://localhost:5000/blogpost
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore createAutore(@RequestBody NewAutorePayload body) {
        return autoreService.saveautore(body);
    }


    //3 get http://localhost:5000/autori/{blogid}

    @GetMapping("/{autoreid}")
    public Autore getautoreId(@PathVariable long autoreid){
        return autoreService.findById(autoreid);

    }


    //4 put http://localhost:5000/autori{blogid}

    @PutMapping("/autoreid")
    public Autore getBlogByIdAndUpdate(@PathVariable long autoreid, @RequestBody NewAutorePayload body){
        return this.autoreService.findByIdAndUpdate(autoreid, body);
    }


    //5 delete  public void findByIdAndDelete(long blogid)

    @DeleteMapping("/{autoriId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getAutoreByIdAndDelete(@PathVariable long autoreid) {
        this.autoreService.findByIdAndDelete(autoreid);
    }

}
