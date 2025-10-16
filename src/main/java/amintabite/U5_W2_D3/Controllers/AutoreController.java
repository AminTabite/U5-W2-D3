package amintabite.U5_W2_D3.Controllers;

import amintabite.U5_W2_D3.Entities.Autore;
import amintabite.U5_W2_D3.Exceptions.BadRequestException;
import amintabite.U5_W2_D3.Payloads.NewAutorePayload;
import amintabite.U5_W2_D3.Services.AutoreService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/autori")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    // 1 GET http://localhost:5000/autori?page=0&size=10&sortBy=nome
    @GetMapping
    public Page<Autore> getAutori(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "4") int size,
            @RequestParam(defaultValue = "nome") String sortBy) {
        return autoreService.findAll(page, size, sortBy);
    }

    // 2 POST http://localhost:5000/autori
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore createAutore(@RequestBody @Validated NewAutorePayload body,   BindingResult validationResult) {

        if (validationResult.hasErrors()) {

            String message = String.valueOf(validationResult.getAllErrors()
                    .stream()
                    .map(err -> err.getDefaultMessage()).toList());


        }


        return autoreService.saveautore(body);
    }

    // 3 GET http://localhost:5000/autori/{autoreid}
    @GetMapping("/{autoreid}")
    public Autore getAutoreById(@PathVariable long autoreid) {
        return autoreService.findById(autoreid);
    }

    // 4 PUT http://localhost:5000/autori/{autoreid}
    @PutMapping("/{autoreid}")
    public Autore updateAutore(@PathVariable long autoreid, @RequestBody NewAutorePayload body) {
        return this.autoreService.findByIdAndUpdate(autoreid, body);
    }

    // 5 DELETE http://localhost:5000/autori/{autoreid}
    @DeleteMapping("/{autoreid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAutore(@PathVariable long autoreid) {
        this.autoreService.findByIdAndDelete(autoreid);
    }
}
