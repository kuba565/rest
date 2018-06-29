package pl.kuba565.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba565.rest.model.News;

public interface NewsRepository extends JpaRepository<News, Long> {
}
