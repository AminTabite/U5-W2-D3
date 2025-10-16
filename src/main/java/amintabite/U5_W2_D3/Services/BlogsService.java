package amintabite.U5_W2_D3.Services;

import amintabite.U5_W2_D3.Entities.Autore;
import amintabite.U5_W2_D3.Exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import amintabite.U5_W2_D3.Entities.BlogPost;
import amintabite.U5_W2_D3.Payloads.NewBlogPayload;
import amintabite.U5_W2_D3.Repositories.BlogpostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Slf4j




public class BlogsService {

    @Autowired
    AutoreService autoreService;

    @Autowired
    BlogpostRepository blogpostRepository;


    public Page<BlogPost> findAll(int pageNumber, int pageSize, String sortBy) {
        if (pageSize > 4) pageSize = 4;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return blogpostRepository.findAll(pageable);
    }


    // vedi tutti user


    public BlogPost savesudb(NewBlogPayload payload){

        Autore autore = autoreService.findById(Long.parseLong(String.valueOf(payload.getAutoreid())));
        if(autore== null)  {throw new NotFoundException("autore non trovato");}

        BlogPost newBlog = new BlogPost(
                payload.getCategoria(),
                payload.getTitolo(),
                payload.getContenuto(),
                payload.getTempolettura()
        );

        newBlog.setAutore(autore);

        BlogPost savedblog = blogpostRepository.save(newBlog);
        log.info("Blog " + savedblog.getTitolo() + " salvato correttamente con autore " + autore.getNome());
        return savedblog;

    }


    public BlogPost findById(long blogid){
        return blogpostRepository.findById(blogid)
                .orElseThrow(() -> new NotFoundException ("Blog non trovato"));
    }



    public BlogPost findByIdAndUpdate(long blogid, NewBlogPayload payload){

        BlogPost found = blogpostRepository.findById(blogid)
                .orElseThrow(() -> new NotFoundException("Modifica fallita"));

                found.setCategoria(payload.getCategoria());
                found.setTitolo(payload.getTitolo());
                found.setContenuto(payload.getContenuto());
                found.setTempolettura(payload.getTempolettura());

        return found;
    }


        public void findByIdAndDelete(long blogid){
            BlogPost found = blogpostRepository.findById(blogid)
                    .orElseThrow(() -> new NotFoundException("Cancellazione fallita"));
            blogpostRepository.delete(found);
        }



    }




