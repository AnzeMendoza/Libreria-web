package edu.sucho.libreriaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E, I> extends JpaRepository<E, I> {
}
