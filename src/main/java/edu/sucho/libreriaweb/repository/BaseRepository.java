package edu.sucho.libreriaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<E, I> extends JpaRepository<E, I> {
}
