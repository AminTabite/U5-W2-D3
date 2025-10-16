package amintabite.U5_W2_D3.Repositories;

import amintabite.U5_W2_D3.Entities.Autore;
import amintabite.U5_W2_D3.Services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AutoreRepository extends JpaRepository<Autore,Long> {





}
