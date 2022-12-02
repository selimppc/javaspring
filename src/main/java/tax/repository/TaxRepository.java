package tax.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tax.entity.Tax;

@Repository
public interface TaxRepository extends CrudRepository<Tax, String> {
}
