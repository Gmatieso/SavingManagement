package net.saving.savingmanagement.repository;

import net.saving.savingmanagement.model.Saving;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingRepository extends JpaRepository<Saving,Long> {
    //Accepts all the crud database methods
}
