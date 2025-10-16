package amintabite.U5_W2_D3.Controllers;

import amintabite.U5_W2_D3.Entities.Autore;
import amintabite.U5_W2_D3.Exceptions.BadRequestException;
import amintabite.U5_W2_D3.Exceptions.ValidationException;
import amintabite.U5_W2_D3.Payloads.NewAutorePayload;
import amintabite.U5_W2_D3.Services.AutoreService;
import com.cloudinary.utils.ObjectUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/autori")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;


    @GetMapping
    public Page<Autore> getAutori(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "4") int size,
            @RequestParam(defaultValue = "nome") String sortBy) {
        return autoreService.findAll(page, size, sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore createAutore(@RequestBody @Validated NewAutorePayload body,   BindingResult validationResult) {

        if (validationResult.hasErrors()) {


            throw new ValidationException(validationResult.getFieldErrors()
                    .stream().map(fieldError -> fieldError.getDefaultMessage()).toList());
        }


        return autoreService.saveautore(body);
    }


    @GetMapping("/{autoreid}")
    public Autore getAutoreById(@PathVariable long autoreid) {
        return autoreService.findById(autoreid);
    }


    @PutMapping("/{autoreid}")
    public Autore updateAutore(@PathVariable long autoreid, @RequestBody NewAutorePayload body) {
        return this.autoreService.findByIdAndUpdate(autoreid, body);
    }


    @DeleteMapping("/{autoreid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAutore(@PathVariable long autoreid) {
        this.autoreService.findByIdAndDelete(autoreid);
    }



    @PatchMapping("/{autoreId}/avatar")
    public String uploadImage(@RequestParam("avatar") MultipartFile file) throws IOException {
        // "avatar" deve corrispondere ESATTAMENTE al nome del campo del MultiPart che contiene il file
        // che è quello che verrà inserito dal frontend
        // Se non corrisponde non troverò il file
        System.out.println(file.getSize());
        System.out.println(file.getOriginalFilename());
        return this.autoreService.uploadAvatar(file);
    }



}




