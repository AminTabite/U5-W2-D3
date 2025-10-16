package amintabite.U5_W2_D3.Services;

import amintabite.U5_W2_D3.Entities.Autore;
import amintabite.U5_W2_D3.Exceptions.NotFoundException;
import amintabite.U5_W2_D3.Payloads.NewAutorePayload;
import amintabite.U5_W2_D3.Repositories.AutoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AutoreService {

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
}
