package amintabite.U5_W2_D3.Services;
import amintabite.U5_W2_D3.Entities.Autore;
import amintabite.U5_W2_D3.Payloads.NewAutorePayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AutoreService {


    public List<Autore> autorilist = new ArrayList<>();



    public List<Autore> findAll() {return this.autorilist;}



    public Autore saveautore(NewAutorePayload payload){


        Autore newAutore = new Autore(payload.getNome(), payload.getCognome(), payload.getEmail(), payload.getDatanascita());
        this.autorilist.add(newAutore);
        log.info("Autore" + newAutore.getCognome() + "e' stato salvato!");
        return newAutore;

    }


    public Autore findById(long autoreid) {

        Autore found = null;
        for (Autore autore: autorilist){

            if(autore.getIdautore() == autoreid) found = autore;
        }

        if (found == null) throw new Error("autore non trovato");
        return found;
    }

    public Autore findByIdAndUpdate(long autoreid, NewAutorePayload payload){

        Autore found = null;

        for (Autore autore: autorilist){

            if(autore.getIdautore() == autoreid) {

                found=autore;
                found.setNome(payload.getNome());
                found.setCognome(payload.getCognome());
                found.setEmail(payload.getEmail());
                found.setDatanascita(payload.getDatanascita());

            }


            if(found == null) throw new Error("modifica fallita");


        }

        return found;

    }

    public void findByIdAndDelete(long autoreid){

        Autore found = null;

        for(Autore autore : this.autorilist){

            if (autore.getIdautore() == autoreid) found= autore;

        }
        if (found == null) throw  new Error("cancellazione fallita");
        this.autorilist.remove(found);


    }



}
