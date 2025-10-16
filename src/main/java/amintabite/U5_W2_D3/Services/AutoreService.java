package amintabite.U5_W2_D3.Services;

import amintabite.U5_W2_D3.Entities.Autore;
import amintabite.U5_W2_D3.Exceptions.BadRequestException;
import amintabite.U5_W2_D3.Exceptions.NotFoundException;
import amintabite.U5_W2_D3.Payloads.NewAutorePayload;
import amintabite.U5_W2_D3.Repositories.AutoreRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class AutoreService {

    @Autowired
    private Cloudinary imageUploader;


    @Autowired
    private AutoreRepository autoreRepository;



    public Page<Autore> findAll(int pageNumber, int pageSize, String sortBy) {
        if (pageSize > 20) pageSize = 20; // limitiamo la dimensione della pagina
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return autoreRepository.findAll(pageable);
    }

    // Salva un nuovo autore
    public Autore saveautore(NewAutorePayload payload) {
        Autore newAutore = new Autore(
                payload.getNome(),
                payload.getCognome(),


                payload.getEmail(),
                payload.getDatanascita()
        );
        Autore savedAutore = autoreRepository.save(newAutore);
        log.info("Autore " + savedAutore.getCognome() + " salvato correttamente!");
        return savedAutore;
    }


    public Autore findById(long autoreid) {
        return autoreRepository.findById(autoreid)

                .orElseThrow(() -> new NotFoundException("Autore non trovato"));
    }


    public Autore findByIdAndUpdate(long autoreid, NewAutorePayload payload) {
        Autore found = autoreRepository.findById(autoreid)
                .orElseThrow(() -> new NotFoundException("Modifica fallita"));


        found.setNome(payload.getNome());
        found.setCognome(payload.getCognome());
        found.setEmail(payload.getEmail());
        found.setDatanascita(payload.getDatanascita());
        return autoreRepository.save(found);
    }


    public void findByIdAndDelete(long autoreid) {
        Autore found = autoreRepository.findById(autoreid)


                .orElseThrow(() -> new RuntimeException("Cancellazione fallita"));
        autoreRepository.delete(found);
        log.info("Autore con ID " + autoreid + " eliminato correttamente.");
    }

    public String uploadAvatar(Long autoreid , MultipartFile file) {

        if (file.isEmpty()) throw new BadRequestException("File vuoto!");
        if (file.getSize() > MAX_SIZE) throw new BadRequestException("File troppo grande!");
        if (!ALLOWED_TYPES.contains(file.getContentType())) throw new BadRequestException("I formati permessi sono png e jpeg!");

        Autore found = autoreRepository.findById(autoreid)
                .orElseThrow(() -> new NotFoundException("Autore non trovato"));





        // Controllo che l'utente esista...
        try {
            Map result = imageUploader.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String imageURL = (String) result.get("url");

            // ... qua va salvato l'url dentro il record dello user di riferimento
            return imageURL;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
