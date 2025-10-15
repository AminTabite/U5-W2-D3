package amintabite.U5_W2_D3.Repositories;

import amintabite.U5_W2_D3.Entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogpostRepository extends JpaRepository <BlogPost, Long>{
}
