package net.saving.savingmanagement.repository;

import net.saving.savingmanagement.model.PersonalSaving;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalSavingRepository extends JpaRepository<PersonalSaving,Long> {
    //Accepts all crud database methods
}
